package service;

import com.dao.Dao;

import entity.Etudiants;



public class ServiceEtudiantsImpl implements ServiceEtudiants{

	private Dao dao_etudiants;

	
	public Dao getDao_etudiants() {
		return dao_etudiants;
	}


	public void setDao_etudiants(Dao dao_etudiants) {
		this.dao_etudiants = dao_etudiants;
	}


	@Override
	public void insert(Etudiants e) {
		// TODO Auto-generated method stub
		dao_etudiants.savePersonne(e);
	}
	

}
