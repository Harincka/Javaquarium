package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;

/**
 * Interface of PoissonService.
 * Classic Service
 * @author Aurelien
 */
public interface IUserService {

	/**
	 * @return List<UserDO>
	 */
	List<UserVO> getAllUser();

	/**
	 * @param user
	 * @return UserDO
	 */
	UserDO map(final UserVO user);

	/**
	 * @param user
	 * @return UserVO
	 */
	UserVO map(final UserDO user);

	/**
	 * @param user
	 */
	void addUser(final UserVO user);

	/**
	 * @param login
	 * @param password
	 * @return boolean
	 */
	boolean validateLogin(final String login, final String password);
}
