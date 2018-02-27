package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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

	@Override
	@Transactional
	public EtudiantNotes getNotes(Etudiant E, List<Cours> L) {
		// TODO Auto-generated method stub
		Session session = this.current_session();
		EtudiantNotes etud = new EtudiantNotes();
		etud.setEtudiant(E);
		List<String> notes = new ArrayList<String>();
		for(Cours c : L){
			Object note =  session.createSQLQuery("select note from suivre where id_etudiant = "+E.getId_etudiant()+" and id_cours = "+c.getId_cours())
					.uniqueResult();
			if(note == null)
				note ="/";
			notes.add(note.toString());
		}
	     
	    etud.setNotes(notes);
	    
		return etud;
	}

	@Override
	@Transactional
	public void saveNotes(int id_etudiant, List<Cours> cours, List<String> notes) {
		// TODO Auto-generated method stub
		Session session = this.current_session();
		System.out.println(notes.size()+" : "+cours.size());
		
		int i=0;
		for(Cours c : cours) {
			Query query = null;
			if(checkNotes(id_etudiant, c.getId_cours())) {
				query = session.createSQLQuery("UPDATE suivre set note = :note where id_etudiant = :id_etu and id_cours = :id_cours");
			}else {
				query = session.createSQLQuery("INSERT INTO suivre(note, id_etudiant, id_cours) VALUES(:note, :id_etu, :id_cours)");
			}
			query.setParameter("note", notes.get(i));
			query.setParameter("id_etu", id_etudiant);
			query.setParameter("id_cours", c.getId_cours());
			query.executeUpdate();
			i++;
		}
		
	}

	@Transactional
	public boolean checkNotes(int id_etudiant, int id_cours) {
		Session session = this.current_session();
		Object o = session.createSQLQuery("select note from suivre where id_etudiant = "+id_etudiant+" and id_cours ="+id_cours)
				.uniqueResult();
		if(o == null)
			return false;
		else return true;
	}

	@Override
	@Transactional
	public List<EtudiantNotes> getNotes(List<Etudiant> liste, Cours cours) {
		List<EtudiantNotes> retour = new ArrayList<EtudiantNotes>();
		Session session = this.current_session();
		for(Etudiant e: liste){
			EtudiantNotes etud = new EtudiantNotes();
			Object note =  session.createSQLQuery("select note from suivre where id_etudiant = "+e.getId_etudiant()+" and id_cours = "+cours.getId_cours())
						.uniqueResult();
			if(note == null)
				note ="/";
			etud.setNote(note.toString());
		    etud.setEtudiant(e);
		    retour.add(etud);
		}
		
		return retour;
	}

	@Override
	@Transactional
	public void saveNotes(List<Etudiant> etudiants, List<String> notes, int id_cours) {
		// TODO Auto-generated method stub
		Session session = this.current_session();
		int i=0;
		for(Etudiant E : etudiants) {
			Query query = null;
			if(checkNotes(E.getId_etudiant(), id_cours)) {
				query = session.createSQLQuery("UPDATE suivre set note = :note where id_etudiant = :id_etu and id_cours = :id_cours");
			}else {
				query = session.createSQLQuery("INSERT INTO suivre(note, id_etudiant, id_cours) VALUES(:note, :id_etu, :id_cours)");
			}
			query.setParameter("note", notes.get(i));
			query.setParameter("id_etu", E.getId_etudiant());
			query.setParameter("id_cours", id_cours);
			query.executeUpdate();
			i++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Etudiant> getEtudiantByKey(String key) {
		// TODO Auto-generated method stub
		List<Etudiant> AllEtudiants = (List<Etudiant>) this.current_session().createQuery("select etudiant FROM Etudiant etudiant where etudiant.nom like '%"+key+"%' or etudiant.adresse like '%"+key+"%'").list();
		return AllEtudiants;
	}
}
