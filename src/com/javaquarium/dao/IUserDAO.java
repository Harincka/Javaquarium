package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserDO;

/**
 * 
 * @author Aurelien
 *
 */
public interface IUserDAO {

	List<UserDO> getAll();
	UserDO checkLogin(String login,String mdp);
	void add(UserDO u);

}
