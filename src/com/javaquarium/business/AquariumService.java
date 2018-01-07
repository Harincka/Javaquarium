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

/**
 * @author johann
 *	Classic Service
 */
public class AquariumService implements IAquariumService{

	private final IAquariumDAO dao;
	
	/* (non-Javadoc)
	 * @see com.javaquarium.business.IAquariumService#getUserAllAquariumPoisson(java.lang.String)
	 */
	@Override
	public Map<String, Integer> getUserAllAquariumPoisson(final String login) {
		final List<AquariumDO> listAquariumPoisson = dao.getUserAllAquariumPoisson(login);
		final Map<String,Integer> poissons = new HashMap<String,Integer>();
		
		//Si notre liste de poisson dans l'aquarium n'est pas vide
		//On peut aller les rechercher
		
		if(listAquariumPoisson != null) {
			for (AquariumDO aquariumPoisson : listAquariumPoisson) {
				poissons.put(aquariumPoisson.getId_poisson().getName(),aquariumPoisson.getSomme());
			}
		}
		
		return poissons;
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.business.IAquariumService#getUserPoisson(java.lang.String, java.lang.String)
	 */
	@Override
	public AquariumDO getUserPoisson(final String login, final String espece) {
		return dao.getAquarium(login, espece);
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.business.IAquariumService#addAquariumPoisson(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void addAquariumPoisson(final String login, final String espece, int count) {
		
		AquariumDO aquariumPoisson = dao.getAquarium(login, espece);
		
		//Si le poisson n'existe pas dans l'aquarium on lui donne les paramètres pour l'insérer
		if(aquariumPoisson == null) {
			
			aquariumPoisson = new AquariumDO();
			final IPoissonDAO poissonDAO = new PoissonDAO();
			final PoissonDO poisson = poissonDAO.getPoisson(espece);
			

			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);
			
			aquariumPoisson.setId_poisson(poisson);
			aquariumPoisson.setId_user(user);
		}
		
		aquariumPoisson.setSomme(count);
		
		dao.addAquariumPoisson(aquariumPoisson);
		
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.business.IAquariumService#removeAllAquariumPoisson(java.lang.String)
	 */
	@Override
	public void removeAllAquariumPoisson(final String login) {
		dao.removeAllAquariumPoisson(login);
		
	}
	
	/**
	 * AquariumService Constructor
	 */
	public AquariumService() {
		dao = new AquariumDAO();
	}

}
