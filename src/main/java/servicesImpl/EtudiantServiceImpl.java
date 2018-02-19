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
	public List<Etudiant> getAll() {
		// TODO Auto-generated method stub
		return this.etudiantDao.getAll();
	}

}
