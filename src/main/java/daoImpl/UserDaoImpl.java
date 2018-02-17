package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import dao.UserDao;
import entities.Users;

@Repository
public class UserDaoImpl implements UserDao {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory session) {
		this.sessionFactory = session;
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User added succesfully. User details : "+user);
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated succesfully. User details : "+user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> allUsers = session.createQuery("from Users").list();
		
		for(Users u : allUsers) {
			logger.info("Users list :: "+u);
		}
		
		return allUsers;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Users getUserById(int UID) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Users us = (Users) session.load(Users.class, new Integer(UID));
		logger.info("User loaded successfully, User details : "+us);
		
		return us;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void removeUser(int UID) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Users us = (Users) session.load(Users.class, new Integer(UID));
		if(us != null)
			session.delete(us);
		logger.info("User deleted successfully, User details : "+us);
	}

	@Override
	public Users checkUser(Users user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Users us = (Users) session
				.createQuery("from Users where login='"+user.getLogin()+"' and password='"+user.getPassword()+"'")
				.uniqueResult();
		return us;
	}

}
