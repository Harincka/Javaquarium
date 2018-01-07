package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.AquariumDO;
import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

/**
 * @author johann
 * Classic DAO
 */
public class AquariumDAO implements IAquariumDAO{

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IAquariumDAO#getUserAllAquariumPoisson(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AquariumDO> getUserAllAquariumPoisson(final String login) {
		
		final Session s = HibernateUtils.getSession();
		
		try {
			
			final Query q = s.createQuery("from AquariumDO where user_id= :userid");
			
			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);
			
			q.setString("userid",user.getId().toString());
			
			return (List<AquariumDO>) q.list();
			
		} finally {
			s.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IAquariumDAO#getAquarium(java.lang.String, java.lang.String)
	 */
	@Override
	public AquariumDO getAquarium(final String login, final String espece) {
		
		final Session s = HibernateUtils.getSession();
		AquariumDO aquariumPoisson = null;
		
		try {
			final Query q = s.createQuery("from AquariumDO where user_id= :userid and poisson_id= :poissonid");
			
			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);
			
			final IPoissonDAO poissonDAO = new PoissonDAO();
			final PoissonDO poisson = poissonDAO.getPoisson(espece);
			
			q.setString("userid", user.getId().toString());
			q.setString("poissonid", poisson.getId().toString());
			
			aquariumPoisson = (AquariumDO) q.uniqueResult();
			
		} finally {
			s.close();
		}
		return aquariumPoisson;
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IAquariumDAO#addAquariumPoisson(com.javaquarium.beans.data.AquariumDO)
	 */
	@Override
	public void addAquariumPoisson(final AquariumDO aquariumPoisson) {
		
		final Session s = HibernateUtils.getSession();
		
		try {
			final Transaction t = s.beginTransaction();
		
			s.saveOrUpdate(aquariumPoisson);
			t.commit();
		} finally {
			s.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IAquariumDAO#removeAllAquariumPoisson(java.lang.String)
	 */
	@Override
	public void removeAllAquariumPoisson(final String login) {
		
		final Session s = HibernateUtils.getSession();
		
		try {
			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);
			
			final Query q = s.createQuery("delete AquariumDO where user_id= :userid");
			q.setString("userid",user.getId().toString());
			q.executeUpdate();
			
		}finally {
			s.close();
		}
	}

	
}
