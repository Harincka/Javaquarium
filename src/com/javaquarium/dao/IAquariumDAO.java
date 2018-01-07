package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.AquariumDO;

/**
 * @author johann
 * Classic interface DAO
 */
public interface IAquariumDAO {

	/**
	 * @param login
	 * @return List<AquariumDO>
	 */
	List<AquariumDO> getUserAllAquariumPoisson(final String login);
	
	/**
	 * @param login
	 * @param espece
	 * @return AquariumDO
	 */
	AquariumDO getAquarium(final String login, final String espece);
	
	/**
	 * @param aquarium
	 */
	void addAquariumPoisson(final AquariumDO aquarium);
	
	/**
	 * @param login
	 */
	void removeAllAquariumPoisson(final String login);
}
