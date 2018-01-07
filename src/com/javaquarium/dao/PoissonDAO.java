package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.util.HibernateUtils;


/**
 * @author Aurelien
 * classic DAO
 */

public class PoissonDAO implements IPoissonDAO {
	
	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IPoissonDAO#add(com.javaquarium.beans.data.PoissonDO)
	 */
	public void add(final PoissonDO poisson){
		final Session s = HibernateUtils.getSession();
		
		final Transaction t = s.beginTransaction();
		
		// On enregistre le poisson 
		s.save(poisson);
		t.commit();
		s.close();
	}
	
	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IPoissonDAO#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<PoissonDO> getAll(){
		
		final Session s = HibernateUtils.getSession();
		
		try {
			
			final Query q = s.createQuery("from PoissonDO");
			return (List<PoissonDO>) q.list();
			
		} finally {
			s.close();
		}
					
	}
	
	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IPoissonDAO#getPoisson(java.lang.String)
	 */
	public PoissonDO getPoisson(final String name) {
		final Session s = HibernateUtils.getSession();
		PoissonDO poisson = null;
		
		final Query q = s.createQuery("from PoissonDO where name= :nomPoisson");
		q.setString("nomPoisson", name);
		
		poisson = (PoissonDO) q.uniqueResult();
		
		s.close();
		
		return poisson;
	}

}