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

import by.epam.struts.form.LoginForm;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		if ("user".equals(userName) && "user".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			
			//navigation: display reservation page
			return mapping.findForward("success");
		} else {
			ActionMessages errors = new ActionMessages();
			errors.add("failure", new ActionMessage("login.error.failure"));
			saveErrors(request, errors);
			//navigation: redisplay the user form
			return mapping.getInputForward();
		}
	}
}
