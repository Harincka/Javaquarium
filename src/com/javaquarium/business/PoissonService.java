package com.javaquarium.business;

import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.IPoissonDAO;

/**
 * @author johann
 *	Classic Service
 */
public class PoissonService implements IPoissonService {
	
	private IPoissonDAO poissonDao;
	
	/**
	 * @param poissonDao the poissonDao to set
	 */
	public void setPoissonDao(final IPoissonDAO poissonDao) {
		this.poissonDao = poissonDao;
	}
	
	
	/* (non-Javadoc)
	 * @see com.javaquarium.business.IPoissonService#createListPoissons()
	 */
	@Override
	public List<PoissonVO> createListPoissons(){
		
		final List<PoissonVO> listePoisson = new ArrayList<PoissonVO>();
		
		final List<PoissonDO> poissonDO = poissonDao.getAll();
		
		for (PoissonDO p : poissonDO){
			final PoissonVO poissonVO = new PoissonVO();
			
			poissonVO.setName(p.getName());
			poissonVO.setId(p.getId());
			poissonVO.setCouleur(p.getCouleur());
			poissonVO.setDescription(p.getDescription());
			poissonVO.setPrix(p.getPrix());
			poissonVO.setDimension(p.getLongueur() + "x" + p.getLargeur());
			
			listePoisson.add(poissonVO);
			
		}
		
		return listePoisson;
		
	}
	
	/* (non-Javadoc)
	 * @see com.javaquarium.business.IPoissonService#add(com.javaquarium.beans.web.PoissonVO)
	 */
	public void add(final PoissonVO poissonVO) {
		final PoissonDO poisson = map(poissonVO);
		poissonDao.add(poisson);
	}
	
	/* (non-Javadoc)
	 * @see com.javaquarium.business.IPoissonService#getPoisson(java.lang.String)
	 */
	public PoissonDO getPoisson(final String name) {
		return  poissonDao.getPoisson(name);
	}
	
	/**
	 * @param poissonVO
	 * @return PoissonDO
	 */
	private PoissonDO map(final PoissonVO poissonVO) {
		final PoissonDO poisson = new PoissonDO();
		final String[] partsDimension = poissonVO.getDimension().split("x");
		
		poisson.setName(poissonVO.getName());
		poisson.setPrix(poissonVO.getPrix());
		poisson.setCouleur(poissonVO.getCouleur());
		poisson.setLongueur(Float.parseFloat(partsDimension[0]));
		poisson.setLargeur(Float.parseFloat(partsDimension[1]));
		poisson.setDescription(poissonVO.getDescription());
		return poisson;
	}
}