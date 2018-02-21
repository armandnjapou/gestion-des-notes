package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CoursDao;
import entities.Cours;

@Repository
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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Cours> cours = (List<Cours>) session.createQuery("select cours from Cours cours").list();
		return cours;
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
