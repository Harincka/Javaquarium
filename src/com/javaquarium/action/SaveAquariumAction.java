package com.javaquarium.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.business.AquariumService;
import com.javaquarium.business.IAquariumService;

public class SaveAquariumAction extends Action {
	
	private static final String FW_SUCCESS = "success";
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		final String login = (String) req.getSession().getAttribute(com.javaquarium.action.LoginAction.SESSION_USERNAME);
		
		Map<String, Integer> aquarium = (Map<String, Integer>) req.getSession().getAttribute(com.javaquarium.action.AjoutPoissonAquariumAction.AQUARIUM);
		

		IAquariumService service = new AquariumService();
		
		//Si on a pas d'aquarium, on en créé 1
		if(aquarium != null) {
			for(String key : aquarium.keySet()) {
				int count = aquarium.get(key);
				
				service.addAquariumPoisson(login, key, count);
			}
		}
		
		return mapping.findForward(FW_SUCCESS);
	
	}

}