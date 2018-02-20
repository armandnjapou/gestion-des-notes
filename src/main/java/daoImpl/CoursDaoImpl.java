package daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.CoursDao;
import entities.Cours;

public class CoursDaoImpl implements CoursDao {

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCours(Cours cours) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCours(Cours cours) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cours getCoursByIntitule(String initutle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCours(String intitule) {
		// TODO Auto-generated method stub
		
	}
}
