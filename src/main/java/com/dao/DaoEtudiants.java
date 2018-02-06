package com.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Etudiants;

public class DaoEtudiants extends HibernateDaoSupport implements Dao{

	@Override
	public void savePersonne(Etudiants e) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(e);
		System.out.println("Insertion de l'etudiant "+e.getNom()+ "réussie!!!");
	}

}
