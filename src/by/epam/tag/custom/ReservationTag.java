package by.epam.tag.custom;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.exceptions.DaoException;
import by.epam.ifaces.ReservationDAO;
import by.epam.model.beans.ResComponent;
import by.epam.model.beans.Reservation;
import by.epam.model.factories.ReservationImplFactory;

@SuppressWarnings("serial")
public class ReservationTag extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ServletContext context = request.getServletContext();
		String fileName = context.getRealPath("/WEB-INF/Reservation.xml");
		try {
			ReservationDAO reservDao = ReservationImplFactory.getImplementation();
			Reservation reserv = reservDao.getReservation(fileName);
			ResComponent resComp = reserv.getResComponent();
			
			String code = "<tr><td>Code</td><td>" + reserv.getCode() + "</td></tr>";
			String description = "<tr><td>Description</td><td>" + reserv.getDescription() + "</td></tr>";
			String componentTypeCode = "<tr><td>ComponentTypeCode</td><td>" + resComp.getComponentTypeCode() + "</td></tr>";
			String createDateTime = "<tr><td>CreateDateTime</td><td>" + resComp.getCreateDateTime() + "</td></tr>";
			String internalStatus = "<tr><td>InternalStatus</td><td>" + resComp.getInternalStatus() + "</td></tr>";
			String sequence = "<tr><td>Sequence</td><td>" + resComp.getSequence() + "</td></tr>";
			
			JspWriter out = pageContext.getOut();
			out.write("<table class=\"table table-striped\">");
			out.write(code);
			out.write(description);
			out.write(componentTypeCode);
			out.write(createDateTime);
			out.write(internalStatus);
			out.write(sequence);
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
