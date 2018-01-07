package com.javaquarium.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.AquariumService;
import com.javaquarium.business.IAquariumService;
import com.javaquarium.business.IPoissonService;

/**
 * @author Aurelien
 *
 * Classic Action
 */
public class ListerEspeceAction extends Action {
	
	private IPoissonService service;
	
	/**
	 * @param service the service to set
	 */
	public void setService(IPoissonService service) {
		this.service = service;
	}
	
	private static final String FW_SUCCESS = "success";
	public static final String SESSION_LIST_POISSON = "LISTE_P";
	
	
	public ActionForward execute (final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res){
		
		List<PoissonVO> poissonVO = service.createListPoissons();
		
		req.getSession().setAttribute(SESSION_LIST_POISSON, poissonVO);
		
		IAquariumService aquariumService = new AquariumService();
		
		@SuppressWarnings("unchecked")
		Map<String, Integer> aquarium = (Map<String, Integer>) req.getSession().getAttribute(com.javaquarium.action.AjoutPoissonAquariumAction.AQUARIUM);

		if (aquarium == null) {
			aquarium = aquariumService.getUserAllAquariumPoisson((String) req.getSession().getAttribute(com.javaquarium.action.LoginAction.SESSION_USERNAME));
			req.getSession().setAttribute(com.javaquarium.action.AjoutPoissonAquariumAction.AQUARIUM,aquarium);
		}
		
		return mapping.findForward(FW_SUCCESS);
		
		
	}

}