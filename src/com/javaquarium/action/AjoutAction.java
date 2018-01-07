package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;

/**
 * @author Aurelien
 *
 * Classic Action
 */
public class AjoutAction extends Action {
	
	private static final String FW_SUCCESS = "success";
	private IPoissonService service;
	
	/**
	 * @param service the service to set
	 */
	public void setService(IPoissonService service) {
		this.service = service;
	}
	
	
	/* (non-Javadoc)
	 * ajoute un poisson 
	 */
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
				
		final PoissonVO poissonVO = (PoissonVO) form;		
		final PoissonDO poissonDO = service.getPoisson(((PoissonVO) form).getName());
		
		if(poissonDO == null) {
			service.add(poissonVO);
		}
		
		return mapping.findForward(FW_SUCCESS);
	
	}

}