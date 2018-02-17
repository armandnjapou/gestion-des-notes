package daoImpl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;

import dao.NotesDao;
import entities.Cours;
import entities.Etudiant;
import entities.Suivre;

public class NotesDaoImpl implements NotesDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void modifierNotesEtudiant(Etudiant etudiant, Cours cours, float note) {
		// TODO Auto-generated method stub

	}

	@Override
	public void affecterNotesEtudiant(List<Etudiant> liste, Cours cours, float[] notes) {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<Etudiant, List<Suivre>> rechercher(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
