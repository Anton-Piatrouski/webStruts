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
import by.epam.model.beans.AncillaryAirComponent;
import by.epam.model.beans.FareFamily;
import by.epam.model.beans.Reservation;
import by.epam.model.factories.ReservationImplFactory;

@SuppressWarnings("serial")
public class FareFamilyTag extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ServletContext context = request.getServletContext();
		String fileName = context.getRealPath("/WEB-INF/Reservation.xml");
		try {
			ReservationDAO reservDao = ReservationImplFactory.getImplementation();
			Reservation reserv = reservDao.getReservation(fileName);
			FareFamily fareFamily = reserv.getFareFamily();
			List<AncillaryAirComponent> components = fareFamily.getAncillaryAirComponents();
			
			String fareFamilyCode = "<tr><td>FareFamilyCode</td><td>" + fareFamily.getFareFamilyCode() + "</td></tr>";
			
			StringBuilder componentsSb = new StringBuilder();
			
			for (AncillaryAirComponent component : components) {
				String ancillaryAirComponentCode = "<tr><td>AncillaryAirComponentCode</td><td>" + component.getAncillaryAirComponentCode() + "</td></tr>";
				componentsSb.append(ancillaryAirComponentCode);
			}
			
			JspWriter out = pageContext.getOut();
			out.write("<table class=\"table table-striped\">");
			out.write(fareFamilyCode);
			out.write(componentsSb.toString());
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
