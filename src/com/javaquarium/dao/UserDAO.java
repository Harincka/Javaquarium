package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

/**
 * @author Aurelien
 * classic DAO
 */
public class UserDAO implements IUserDAO {

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserDAO#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDO> getAll() {
		final Session s = HibernateUtils.getSession();
		try {
			final Query q = s.createQuery("from UserDO");
			return (List<UserDO>) q.list();
		} finally {
			s.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserDAO#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public UserDO checkLogin(final String login, final String pass) {
		final Session s = HibernateUtils.getSession();
		UserDO u = null;
		try {
			final Query q = s.createQuery("from UserDO where login= :myLogin and password= :pass");
			q.setString("myLogin", login);
			q.setString("pass", pass);
			u = (UserDO) q.uniqueResult();
		} finally {
			s.close();
		}
		return u;
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserDAO#add(com.javaquarium.beans.data.UserDO)
	 */
	@Override
	public void add(final UserDO u) {
		final Session s = HibernateUtils.getSession();
		try {
			final Transaction t = s.beginTransaction();
			s.save(u);
			t.commit();
		} finally {
			s.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserDAO#getUser(java.lang.String)
	 */
	@Override
	public UserDO getUser(final String login) {
		final Session s = HibernateUtils.getSession();
		UserDO u = null;
		try {
			final Query q = s.createQuery("from UserDO where login= :myLogin");
			q.setString("myLogin", login);
			u = (UserDO) q.uniqueResult();
		} finally {
			s.close();
		}
		return u;
	}

}
