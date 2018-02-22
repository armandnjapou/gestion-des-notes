package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.EtudiantDao;
import entities.Cours;
import entities.Etudiant;
import entities.EtudiantNotes;

@Repository
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
	@Transactional
	public void addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.current_session().persist(etudiant);
	}

	@Override
	@Transactional
	public void updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.current_session().update(etudiant);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		List<Etudiant> AllEtudiants = (List<Etudiant>) this.current_session().createQuery("select etudiant FROM Etudiant etudiant ORDER BY etudiant.nom").list();
		return AllEtudiants;
	}

	@Override
	public Etudiant getEtudiantByNom(String nom) {
		// TODO Auto-generated method stub
		String requete = "SELECT * FROM etudiants WHERE nom=\'"+nom+"\'";
		return null;
	}

	@Override
	@Transactional
	public void removeEtudiant(int id_etudiant) {
		// TODO Auto-generated method stub
		Etudiant E = (Etudiant) this.current_session()
				.createQuery("from Etudiant where id_etudiant ="+id_etudiant)
				.uniqueResult();
		if(E != null)
			this.current_session().delete(E);

	}

	@Override
	@Transactional
	public Etudiant getEtudiantById(int ID) {
		// TODO Auto-generated method stub
		Etudiant E = (Etudiant) this.current_session()
				.createQuery("from Etudiant where id_etudiant ="+ID)
				.uniqueResult();
		return E;
	}

	@Override
	@Transactional
	public List<EtudiantNotes> getNotes(List<Etudiant> liste, List<Cours> listecours) {
		// TODO Auto-generated method stub
		Float[] tab;
		List<EtudiantNotes> retour = new ArrayList<EtudiantNotes>();
		Session session = this.current_session();
		for(Etudiant e: liste){
			EtudiantNotes etud = new EtudiantNotes();
			List<String> notes = new ArrayList<String>();
			for(Cours c : listecours){
				Object note =  session.createSQLQuery("select note from suivre where id_etudiant = "+e.getId_etudiant()+" and id_cours = "+c.getId_cours())
						.uniqueResult();
				if(note == null)
					note ="/";
				notes.add(note.toString());
			}
		    etud.setEtudiant(e); etud.setNotes(notes);
		    retour.add(etud);
		}
		
		return retour;
	}

	

}
