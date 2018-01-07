package com.javaquarium.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AjoutPoissonAquariumAction extends Action {
	
	private static final String FW_SUCCESS = "success";
	
	public static final String ESPECE = "name";
	
	public static final String AQUARIUM = "Aquarium";
	
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		int count = 0;
		
		final String espece = req.getParameter(ESPECE);
		
		@SuppressWarnings("unchecked")
		Map<String, Integer> aquarium = (Map<String, Integer>) req.getSession().getAttribute(AQUARIUM);
		
		//Si on a pas d'aquarium, on en créé 1
		if(aquarium == null) {
			aquarium = new HashMap<String, Integer>();
		}
		//Si on a un aquarium on récupère le nombre de poisson de l'espece à ajouter
		if(aquarium.get(espece) != null) {
			count = aquarium.get(espece);
		}
		
		//Ajout d'un poisson en fonction de l'espece
		aquarium.put(espece, count + 1);
		
		//On ajoute le nouvel aquarium en session
		req.getSession().setAttribute(com.javaquarium.action.AjoutPoissonAquariumAction.AQUARIUM, aquarium);
		
		return mapping.findForward(FW_SUCCESS);
	
	}

}