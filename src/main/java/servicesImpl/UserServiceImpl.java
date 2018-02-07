package servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entities.Users;
import services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		this.userDao.addUser(user);
		
	}

	@Override
	@Transactional
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		this.userDao.updateUser(user);
	}

	@Override
	@Transactional
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userDao.getAllUsers();
	}

	@Override
	@Transactional
	public Users getUserById(int UID) {
		// TODO Auto-generated method stub
		return this.userDao.getUserById(UID);
	}

	@Override
	@Transactional
	public void removeUser(int UID) {
		// TODO Auto-generated method stub
		this.userDao.removeUser(UID);
	}

}
