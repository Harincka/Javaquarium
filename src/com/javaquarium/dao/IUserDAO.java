package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserDO;

/**
 * 
 * @author Aurelien
 *
 */
public interface IUserDAO {

	List<UserDO> getAllUser();
	UserDO getUser(String name);
	void addUser(UserDO u);

}
