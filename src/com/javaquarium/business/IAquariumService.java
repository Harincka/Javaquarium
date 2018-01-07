package com.javaquarium.business;

import java.util.Map;

import com.javaquarium.beans.data.AquariumDO;

/**
 * @author johann
 *	Classic Service
 */
public interface IAquariumService {

	/**
	 * @param login
	 * @return Map
	 */
	Map<String, Integer> getUserAllAquariumPoisson(final String login);
	
	/**
	 * @param login
	 * @param espece
	 * @return AquariumDO
	 */
	AquariumDO getUserPoisson(final String login, final String espece);
	
	/**
	 * @param login
	 * @param espece
	 * @param count
	 */
	void addAquariumPoisson(final String login, final String espece ,int count);
	
	/**
	 * @param login
	 */
	void removeAllAquariumPoisson(final String login);
}
