package services;

import java.util.List;

import entities.Users;

public interface UserService {
	void addUser(Users user);
	void updateUser(Users user);
	List<Users> getAllUsers();
	Users getUserById(int UID);
	Users checkUser(Users user);
	void removeUser(int UID);
}
