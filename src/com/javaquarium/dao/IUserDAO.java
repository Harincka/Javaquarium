package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserDO;

/**
 * 
 * @author Aurelien
 * classic Interface DAO
 */
public interface IUserDAO {

	/**
	 * @return List<UserDO>
	 */
	List<UserDO> getAll();

	/**
	 * @param login
	 * @param mdp
	 * @return UserDO
	 */
	UserDO checkLogin(final String login, final String mdp);

	/**
	 * @param u
	 */
	void add(final UserDO u);
	
	/**
	 * @param login
	 * @return UserDO
	 */
	UserDO getUser(final String login);

}
