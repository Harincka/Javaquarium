package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;


import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.util.HibernateUtils;

public class PoissonDAO implements IPoissonDAO {
	
	public void add(PoissonDO poisson){
		Session s = HibernateUtils.getSession();
		
		Transaction t = s.beginTransaction();
		
		// On enregistre le poisson dans la base de données
		s.save(poisson);
		
		// On va commencer une transaction
		t.commit();
		
		// On ferme la session de la base de donnée
		s.close();
	}
	
	public List<PoissonDO> getAll(){
		
		Session s = HibernateUtils.getSession();
		
		try {
			
			Query q = s.createQuery("from PoissonDO");
			return (List<PoissonDO>) q.list();
			
		} finally {
			s.close();
		}
					
	}
	
	public PoissonDO getPoisson(String name) {
		Session s = HibernateUtils.getSession();
		PoissonDO poisson = null;
		
		Query q = s.createQuery("from Poisson where nom= :nomPoisson");
		q.setString("nomPoisson", name);
		
		poisson = (PoissonDO) q.uniqueResult();
		
		s.close();
		
		return poisson;
	}

}