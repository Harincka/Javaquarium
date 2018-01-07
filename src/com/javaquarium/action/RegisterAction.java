package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.UserVO;
import com.javaquarium.business.IUserService;

/**
 * @author Aurelien
 *
 * Classic Action
 */
public class RegisterAction extends Action {

	private static final String FW_SUCCESS = "success";
	private static final String FW_FORM_ERROR = "form_error";

	private IUserService userService;
	
	/**
	 * @param userService
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		String forward = FW_SUCCESS;
		final UserVO userVO = (UserVO) form;

		if (userService.validateLogin(userVO.getLogin(), userVO.getPassword())) {
			return mapping.findForward(FW_FORM_ERROR);
		} else {
			userService.addUser(userVO);
			forward = FW_SUCCESS;
		}
		return mapping.findForward(forward);
	}
	
	
}
