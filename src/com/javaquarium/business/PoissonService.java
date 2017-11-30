package com.javaquarium.business;

import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.IPoissonDAO;

public class PoissonService implements IPoissonService {
	
	private IPoissonDAO poissonDao;
	
	/**
	 * @param poissonDao the poissonDao to set
	 */
	public void setPoissonDao(IPoissonDAO poissonDao) {
		this.poissonDao = poissonDao;
	}
	
	
	@Override
	public List<PoissonVO> createListPoissons(){
		
		final List<PoissonVO> listePoisson = new ArrayList<PoissonVO>();
		
		final List<PoissonDO> poissonDO = poissonDao.getAll();
		
		for (PoissonDO p : poissonDO){
			final PoissonVO poissonVO = new PoissonVO();
			
			poissonVO.setNom(p.getNom());
			poissonVO.setCode(p.getCode());
			poissonVO.setCouleur(p.getCouleur());
			poissonVO.setDescription(p.getDescription());
			poissonVO.setPrix(p.getPrix());
			poissonVO.setDimension(p.getLongueur() + "x" + p.getLargeur());
			
			listePoisson.add(poissonVO);
			
		}
		
		return listePoisson;
		
	}
	
	public void add(final PoissonVO poissonVO) {
		final PoissonDO poisson = map(poissonVO);
		poissonDao.add(poisson);
	}
	
	
	private PoissonDO map(final PoissonVO poissonVO) {
		final PoissonDO poisson = new PoissonDO();
		String[] partsDimension = poissonVO.getDimension().split("x");
		
		poisson.setNom(poissonVO.getNom());
		poisson.setPrix(poissonVO.getPrix());
		poisson.setCouleur(poissonVO.getCouleur());
		poisson.setLongueur(Float.parseFloat(partsDimension[0]));
		poisson.setLargeur(Float.parseFloat(partsDimension[1]));
		poisson.setDescription(poissonVO.getDescription());
		return poisson;
	}
}