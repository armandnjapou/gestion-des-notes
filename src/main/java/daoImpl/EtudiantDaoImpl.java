package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.EtudiantDao;
import entities.Etudiant;

public class EtudiantDaoImpl implements EtudiantDao {

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
	public void addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.current_session().persist(etudiant);
	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.current_session().update(etudiant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		List<Etudiant> AllEtudiants = this.current_session().createSQLQuery("SELECT * FROM etudiants;").list();
		return AllEtudiants;
	}

	@Override
	public Etudiant getEtudiantByNom(String nom) {
		// TODO Auto-generated method stub
		String requete = "SELECT * FROM etudiants WHERE nom=\'"+nom+"\'";
		return null;
	}

	@Override
	public void removeEtudiant(int id_etudiant) {
		// TODO Auto-generated method stub

	}

}
