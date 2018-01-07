package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;

/**
 * @author johann
 *	Classic Service
 */
public interface IPoissonService {

	/**
	 * @return List<PoissonVO>
	 */
	List<PoissonVO> createListPoissons();
	
	/**
	 * @param poissonVO
	 */
	void add(final PoissonVO poissonVO);
	
	/**
	 * @param name
	 * @return PoissonDO
	 */
	PoissonDO getPoisson(final String name);

}