package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

public class AquariumDAO implements IAquariumDAO{

	@Override
	public List<AquariumDO> getUserAllAquariumPoisson(String login) {
		// TODO Auto-generated method stub
		
		Session s = HibernateUtils.getSession();
		
		try {
			
			Query q = s.createQuery("from AquariumDO where user_id= :userid");
			
			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);
			
			q.setString("userid",user.getId().toString());
			
			return (List<AquariumDO>) q.list();
			
		} finally {
			s.close();
		}
	}

	@Override
	public AquariumDO getUserPoisson(String login, String espece) {
		// TODO Auto-generated method stub
		Session s = HibernateUtils.getSession();
		AquariumDO aquariumPoisson = null;
		Query q = s.createQuery("from AquariumDO where user_id= :userid and poisson_id= :poissonid");
		
		final IUserDAO userDAO = new UserDAO();
		final UserDO user = userDAO.getUser(login);
		
		final IPoissonDAO poissonDAO = new PoissonDAO();
		final PoissonDO poisson = poissonDAO.getPoisson(espece);
		
		q.setString("userid", user.getId().toString());
		q.setString("poissonid", poisson.getCode().toString());
		
		aquariumPoisson = (AquariumDO) q.uniqueResult();
		
		s.close();
		
		return aquariumPoisson;
	}

	@Override
	public void addAquariumPoisson(AquariumDO aquariumPoisson) {
		// TODO Auto-generated method stub
		
		Session s = HibernateUtils.getSession();
		
		Transaction t = s.beginTransaction();
		
		s.saveOrUpdate(aquariumPoisson);
		t.commit();
		
		s.close();
		
	}

	@Override
	public void removeAllAquariumPoisson(String login) {
		// TODO Auto-generated method stub
		
		Session s = HibernateUtils.getSession();
		
		final IUserDAO userDAO = new UserDAO();
		final UserDO user = userDAO.getUser(login);
		
		Query q = s.createQuery("delete AquariumDO where user= :userid");
		q.setString("user_id",user.getId().toString());
		q.executeUpdate();
		
		s.close();
		
	}

	
}
