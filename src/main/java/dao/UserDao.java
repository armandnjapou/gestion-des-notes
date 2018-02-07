package dao;

import java.util.List;

import entities.Users;

public interface UserDao {
	void addUser(Users user);
	void updateUser(Users user);
	List<Users> getAllUsers();
	Users getUserById(int UID);
	void removeUser(int UID);
}
