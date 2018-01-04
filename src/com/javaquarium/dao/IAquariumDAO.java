package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.AquariumDO;

public interface IAquariumDAO {

	List<AquariumDO> getUserAllAquariumPoisson(final String login);
	
	AquariumDO getUserPoisson(final String login, final String espece);
	
	void addAquariumPoisson(final AquariumDO aquarium);
	
	void removeAllAquariumPoisson(final String login);
}
