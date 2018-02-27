package daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.CoursDao;
import entities.Cours;
import entities.Etudiant;

@Repository
public class CoursDaoImpl implements CoursDao {

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	private Session current_session() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}


	@Override
	@Transactional
	public void addCours(Cours cours) {
		this.current_session().persist(cours);
		// TODO Auto-generated method stub
		
	}

	

	@Override
	@Transactional
	public void updateCours(Cours cours) {
		this.current_session().update(cours);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Cours> cours = (List<Cours>) this.current_session().createQuery("select cours from Cours cours").list();
		return cours;
	}

	@Override
	@Transactional
	public Cours getCoursByIntitule(String initule) {
		Cours C = (Cours) this.current_session()
				.createQuery("from Cours where initule ="+initule )
				.uniqueResult();
		return C;
		
		
	}

	@Override
	@Transactional
	public void removeCours(String initule) {
		
		Cours C = (Cours) this.current_session()
				.createQuery("from Cours where id_cours ="+initule)
				.uniqueResult();
		if(C != null)
			this.current_session().delete(C);
		
	}

	@Override
	@Transactional
	public Cours getCoursByID(int id) {
		Cours C = (Cours) this.current_session()
				.createQuery("from Cours where id_cours ="+id )
				.uniqueResult();
		return C;
		
		
	}

	@Override
	@Transactional
	public void removeCours(int id) {
		Cours C = (Cours) this.current_session()
				.createQuery("from Cours where id_cours ="+id)
				.uniqueResult();
		if(C != null)
			this.current_session().delete(C);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Cours> getCoursByKey(String key) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Cours> cours = (List<Cours>) session.createSQLQuery("select * from cours where intitule like '%"+key+"%'").list();
		
		return cours;
	}
}
