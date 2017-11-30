package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.web.PoissonVO;

public interface IPoissonService {

	List<PoissonVO> createListPoissons();
	void add(final PoissonVO poissonVO);

}