package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.business.IUserService;
import com.javaquarium.business.UserService;


public class LoginAction extends Action {

	private IUserService userService;
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	private static final String FW_SUCCESS = "success";
	private static final String FW_FORM_ERROR = "form_error";
	public static final String SESSION_USERNAME = "login";

	
	public ActionForward execute(final ActionMapping mapping, 
			final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		String forward = FW_SUCCESS;

		String login = ((LoginVO) form).getLogin();
		String password = ((LoginVO) form).getPassword();

		if (true) {
			req.getSession()
			.setAttribute(SESSION_USERNAME, ((LoginVO) (form)).getLogin());
			req.getSession();
		} else {
			/* ActionErrors errors = new ActionErrors();
		errors.add("errors.field.login.incorrect.user_or_password", 
				new ActionMessage("errors.field.login.incorrect.user_or_password"));
		saveErrors(req, errors);
			forward = FW_FORM_ERROR; */
		} 
		
		return mapping.findForward(forward);

	}

}
