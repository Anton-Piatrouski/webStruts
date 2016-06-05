package by.epam.tag.custom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.exceptions.DaoException;
import by.epam.ifaces.ReservationDAO;
import by.epam.model.beans.Customer;
import by.epam.model.beans.Payment;
import by.epam.model.beans.Reservation;
import by.epam.model.factories.ReservationImplFactory;

@SuppressWarnings("serial")
public class CustomerTag extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ServletContext context = request.getServletContext();
		String fileName = context.getRealPath("/WEB-INF/Reservation.xml");
		try {
			ReservationDAO reservDao = ReservationImplFactory.getImplementation();
			Reservation reserv = reservDao.getReservation(fileName);
			Customer customer = reserv.getCustomer();
			List<Payment> payments = customer.getPayments();
			
			String firstName = "<tr><td>FirstName</td><td>" + customer.getFirstName() + "</td></tr>";
			String lastName = "<tr><td>LastName</td><td>" + customer.getLastName() + "</td></tr>";
			String emailAddress = "<tr><td>EmailAddress</td><td>" + customer.getEmailAddress() + "</td></tr>";
			String phoneNumber = "<tr><td>PhoneNumber</td><td>" + customer.getPhoneNumber() + "</td></tr>";
			
			StringBuilder paymentsSb = new StringBuilder();
			
			for (Payment payment : payments) {
				String amountPaid = "<tr><td>AmountPaid</td><td>" + payment.getAmountPaid() + "</td></tr>";
				String formOfPaymentTypeCode = "<tr><td>FormOfPaymentTypeCode</td><td>" + payment.getFormOfPaymentTypeCode() + "</td></tr>";
				String currencyCode = "<tr><td>CurrencyCode</td><td>" + payment.getCurrencyCode() + "</td></tr>";
				paymentsSb.append(amountPaid);
				paymentsSb.append(formOfPaymentTypeCode);
				paymentsSb.append(currencyCode);
			}
			
			JspWriter out = pageContext.getOut();
			out.write("<table class=\"table table-striped\">");
			out.write(firstName);
			out.write(lastName);
			out.write(emailAddress);
			out.write(phoneNumber);
			out.write(paymentsSb.toString());
			out.write("</table>");
		} catch(IOException | DaoException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() {
		return EVAL_PAGE;
	}
}
