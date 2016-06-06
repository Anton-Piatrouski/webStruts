package by.epam.tag.custom;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.exceptions.DaoException;
import by.epam.ifaces.ReservationDAO;
import by.epam.model.beans.Customer;
import by.epam.model.beans.Reservation;
import by.epam.model.factories.ReservationImplFactory;

@SuppressWarnings("serial")
public class CustomerTag extends TagSupport {
	private String var;
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ServletContext context = request.getServletContext();
		String fileName = context.getRealPath("/WEB-INF/Reservation.xml");
		try {
			ReservationDAO reservDao = ReservationImplFactory.getImplementation();
			Reservation reserv = reservDao.getReservation(fileName);
			Customer customer = reserv.getCustomer();
			
			pageContext.setAttribute(var, customer);
			
		} catch(DaoException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() {
		return EVAL_PAGE;
	}
}
