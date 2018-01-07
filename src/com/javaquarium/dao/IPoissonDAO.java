package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

/**
 * @author Aurelien
 * classic InterfaceDAO
 */
public interface IPoissonDAO {

	/**
	 * Classic DAO
	 * @return List<PoissonDO>
	 */
	List<PoissonDO> getAll();
	/**
	 * Classic DAO
	 * @param poissonDO
	 */
	void add(PoissonDO poissonDO);
	
	/**
	 * @param name
	 * @return PoissonDO
	 */
	PoissonDO getPoisson(String name);

}
