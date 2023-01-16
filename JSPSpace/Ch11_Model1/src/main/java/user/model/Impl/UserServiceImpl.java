package user.model.Impl;

import user.model.UserService;
import user.model.UserVO;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO = new UserDAO();
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return null;
	}
}
