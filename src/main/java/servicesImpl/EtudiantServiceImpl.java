package servicesImpl;

import java.util.List;

import dao.EtudiantDao;
import entities.Etudiant;
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

}
