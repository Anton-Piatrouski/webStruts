package by.epam.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import by.epam.exceptions.DaoException;
import by.epam.ifaces.UserDAO;
import by.epam.model.beans.User;
import by.epam.model.factories.UserImplFactory;
import by.epam.struts.form.LoginForm;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		ActionMessages errors = new ActionMessages();
		
		UserDAO userDao = UserImplFactory.getImplementation();
		try {
			User user = userDao.getUser(userName, password);
			
			if (userName.equals(user.getName())) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			} else {
				errors.add("failure", new ActionMessage("login.error.failure"));
			}
		} catch (DaoException e) {
			errors.add("failure", new ActionMessage("login.error.request.processing"));
		}
		return specifyForward(mapping, request, errors);
	}
	
	private ActionForward specifyForward(ActionMapping mapping, HttpServletRequest request, ActionMessages errors) {
		ActionForward forward = new ActionForward();
		
		if (errors.isEmpty()) {
			//navigation: display reservation page
			forward = mapping.findForward("success");
		} else {
			saveErrors(request, errors);
			//navigation: redisplay the user form
			forward = mapping.getInputForward();
		}
		return forward;
	}
}
