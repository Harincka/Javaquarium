package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

/**
 * @author seb
 *
 */
public interface IPoissonDAO {

	/**
	 * Classic DAO
	 * @return
	 */
	List<PoissonDO> getAll();
	/**
	 * Classic DAO
	 * @param poissonDO
	 */
	void add(PoissonDO poissonDO);

}
