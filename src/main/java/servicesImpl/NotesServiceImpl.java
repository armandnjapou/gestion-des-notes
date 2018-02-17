package servicesImpl;

import java.util.HashMap;
import java.util.List;

import dao.NotesDao;
import entities.Cours;
import entities.Etudiant;
import entities.Suivre;
import services.NotesService;

public class NotesServiceImpl implements NotesService {

	private NotesDao notesDao;
	
	public NotesDao getNotesDao() {
		return notesDao;
	}

	public void setNotesDao(NotesDao notesDao) {
		this.notesDao = notesDao;
	}

	@Override
	public void modifierNotesEtudiant(Etudiant etudiant, Cours cours, float note) {
		// TODO Auto-generated method stub
		this.notesDao.modifierNotesEtudiant(etudiant, cours, note);
	}

	@Override
	public void affecterNotesEtudiant(List<Etudiant> liste, Cours cours, float[] notes) {
		// TODO Auto-generated method stub
		this.notesDao.affecterNotesEtudiant(liste, cours, notes);
	}

	@Override
	public HashMap<Etudiant, List<Suivre>> rechercher(String nom) {
		// TODO Auto-generated method stub
		return this.notesDao.rechercher(nom);
	}

}
