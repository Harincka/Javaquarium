package com.javaquarium.business;

import java.util.Map;

import com.javaquarium.beans.data.AquariumDO;

public interface IAquariumService {

	Map<String, Integer> getUserAllAquariumPoisson(String login);
	
	AquariumDO getUserPoisson(final String login, final String espece);
	
	void addAquariumPoisson(final String login, final String espece);
	
	void removeAllAquariumPoisson(final String login);
}
