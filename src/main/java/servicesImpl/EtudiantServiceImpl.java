package servicesImpl;

import java.util.List;

import dao.EtudiantDao;
import entities.Cours;
import entities.Etudiant;
import entities.EtudiantNotes;
import services.EtudiantService;

public class EtudiantServiceImpl implements EtudiantService {

	private EtudiantDao etudiantDao;
	
	public EtudiantDao getEtudiantDao() {
		return etudiantDao;
	}

	public void setEtudiantDao(EtudiantDao etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	@Override
	public void addEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiantDao.addEtudiant(etudiant);
	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		this.etudiantDao.updateEtudiant(etudiant);
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return this.etudiantDao.getAllEtudiants();
	}

	@Override
	public Etudiant getEtudiantByNom(String nom) {
		// TODO Auto-generated method stub
		return this.etudiantDao.getEtudiantByNom(nom);
	}

	@Override
	public void removeEtudiant(int id_etudiant) {
		// TODO Auto-generated method stub
		this.etudiantDao.removeEtudiant(id_etudiant);
	}

	@Override
	public Etudiant getEtudiantById(int ID) {
		// TODO Auto-generated method stub
		return this.etudiantDao.getEtudiantById(ID);
	}

	@Override
	public List<EtudiantNotes> getNotes(List<Etudiant> liste, List<Cours> listecours) {
		// TODO Auto-generated method stub
		return this.etudiantDao.getNotes(liste,listecours);
	}

	@Override
	public EtudiantNotes getNotes(Etudiant E, List<Cours> listeCours) {
		// TODO Auto-generated method stub
		return this.etudiantDao.getNotes(E, listeCours);
	}

	@Override
	public void saveNotes(int id_etudiant,List<Cours> cours, List<String> notes) {
		// TODO Auto-generated method stub
		this.etudiantDao.saveNotes(id_etudiant,cours, notes);
	}

	@Override
	public List<EtudiantNotes> getNotes(List<Etudiant> liste, Cours cours) {
		// TODO Auto-generated method stub
		return this.etudiantDao.getNotes(liste, cours);
	}

	@Override
	public void saveNotes(List<Etudiant> etudiants, List<String> notes, int id_cours) {
		// TODO Auto-generated method stub
		this.etudiantDao.saveNotes(etudiants, notes, id_cours);
	}

	@Override
	public List<Etudiant> getEtudiantByKey(String key) {
		// TODO Auto-generated method stub
		return this.etudiantDao.getEtudiantByKey(key);
	}
}
