package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.SuivreDao;
import entities.Cours;
import entities.Etudiant;
import entities.Suivre;
import entities.Users;

@Repository
public class SuivreDaoImpl implements SuivreDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void affecterNoteToEtudiant(Etudiant etudiant, Cours cours, float note) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Suivre S = new Suivre();
		S.setId_cours(cours.getId_cours());
		S.setId_etudiant(etudiant.getId_etudiant());
		S.setNote(note);
		
		session.persist(S);
		
	}

	@Override
	@Transactional
	public void affecterNotesToEtudiants(List<Etudiant> liste, Cours cours, float[] notes) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		int i=0;
		for(Etudiant E : liste) {
			affecterNoteToEtudiant(E, cours, notes[i]);
			i++;
		}
		
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Suivre> getNotesOfEtudiant(Etudiant etudiant, List<Cours> cours) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Suivre> liste = session.createSQLQuery("select * from suivre WHERE suivre.id_etudiant = :id")
				.setParameter(":id", etudiant.getId_etudiant())
				.list();
		
		return liste;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<List<Suivre>> getNotesOfEtudiants(List<Etudiant> liste, List<Cours> cours) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<List<Suivre>> list = new ArrayList<List<Suivre>>();
		
		for(Etudiant E : liste) {
			List<Suivre> listEtudiant = session.createSQLQuery("select * from suivre where suivre.id_etudiant = :id")
					.setParameter(":id", E.getId_etudiant())
					.list();
			list.add(listEtudiant);
		}
		
		return list;
	}

	@Override
	@Transactional
	public float moyenne(List<Suivre> liste) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		float total = 1;
		
		for(Suivre S : liste) {
			Cours C = (Cours) session.load(Cours.class, new Integer(S.getId_cours()));
			total = total + S.getNote()*C.getCoefficient();
		}
		float moyenne = total/liste.size();
		
		return moyenne;
	}

	@Override
	@Transactional
	public List<Cours> getCoursOfEtudiant(List<Suivre> liste, Etudiant E) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Cours> list = new ArrayList<Cours>();
		
		for(Suivre S : liste) {
			Cours cours = (Cours) session.createSQLQuery("select cours.* from suivre,cours where cours.id_cours = "+S.getId_cours()+" and suivre.id_etudiant = "+E.getId_etudiant())
					.uniqueResult();
			list.add(cours);
		}
		return list;
	}

}
