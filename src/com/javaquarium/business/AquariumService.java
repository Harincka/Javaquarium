package com.javaquarium.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.dao.AquariumDAO;
import com.javaquarium.dao.IAquariumDAO;
import com.javaquarium.dao.IPoissonDAO;
import com.javaquarium.dao.IUserDAO;
import com.javaquarium.dao.PoissonDAO;
import com.javaquarium.dao.UserDAO;

public class AquariumService implements IAquariumService{

	private IAquariumDAO dao;
	
	@Override
	public Map<String, Integer> getUserAllAquariumPoisson(String login) {
		// TODO Auto-generated method stub
		final List<AquariumDO> listAquariumPoisson = dao.getUserAllAquariumPoisson(login);
		Map<String,Integer> poissons = new HashMap<String,Integer>();
		
		//Si notre liste de poisson dans l'aquarium n'est pas vide
		//On peut aller les rechercher
		
		if(listAquariumPoisson != null) {
			for (AquariumDO aquariumPoisson : listAquariumPoisson) {
				poissons.put(aquariumPoisson.getId_poisson().getNom(),aquariumPoisson.getSomme());
			}
		}
		
		return poissons;
	}

	@Override
	public AquariumDO getUserPoisson(String login, String espece) {
		// TODO Auto-generated method stub
		return dao.getAquarium(login, espece);
	}

	@Override
	public void addAquariumPoisson(String login, String espece, int count) {
		// TODO Auto-generated method stub
		
		AquariumDO aquariumPoisson = dao.getAquarium(login, espece);
		
		//Si le poisson n'existe pas dans l'aquarium on lui donne les paramètres pour l'insérer
		if(aquariumPoisson == null) {
			IPoissonDAO poissonDAO = new PoissonDAO();
			PoissonDO poisson = poissonDAO.getPoisson(espece);
			

			IUserDAO userDAO = new UserDAO();
			UserDO user = userDAO.getUser(login);
			
			aquariumPoisson.setId_poisson(poisson);
			aquariumPoisson.setId_user(user);
		}
		
		aquariumPoisson.setSomme(count);
		
		dao.addAquariumPoisson(aquariumPoisson);
		
	}

	@Override
	public void removeAllAquariumPoisson(String login) {
		// TODO Auto-generated method stub
		dao.removeAllAquariumPoisson(login);
		
	}
	
	public AquariumService() {
		dao = new AquariumDAO();
	}

}
