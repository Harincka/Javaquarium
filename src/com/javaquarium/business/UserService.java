package com.javaquarium.business;

import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;
import com.javaquarium.dao.IUserDAO;
import com.javaquarium.dao.UserDAO;


/**
 * @author Aurelien
 *
 * Classic service
 */
public class UserService implements IUserService {

	private IUserDAO userDao = new UserDAO();
	
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public List<UserVO> getAllUser() {
		final List<UserDO> listUser = userDao.getAll();
		List<UserVO> users = new ArrayList<UserVO>(listUser.size());
		for (final UserDO user : listUser) {
			users.add(map(user));
		}
		return users;
	}
	
	public void addUser(UserVO user) {
		UserDO u = this.map(user);
		userDao.add(u);
	}

	public UserVO map(final UserDO user) {
		UserVO u = null;
		if (user != null) {
			u = new UserVO();
			u.setLogin(user.getLogin());
			u.setPassword(null);
			u.setRepeatpassword(null);
		}
		return u;
	}

	
	@Override
	public UserDO map(UserVO user) {
		UserDO u = null;
		if (user != null) {
			u = new UserDO();
			u.setLogin(user.getLogin());
			u.setPassword(user.getPassword());

		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.IUserService#validateLogin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean validateLogin(String login, String password) {
		System.out.println("test premat");
		UserDO databaseUser = userDao.checkLogin(login, password);
		if (databaseUser != null) {
			return true;
		}
		return false;
	}

}
