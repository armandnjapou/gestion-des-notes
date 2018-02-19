package dao;

import java.util.List;

import entities.Etudiant;

public interface EtudiantDao {
	
	void addEtudiant (Etudiant etudiant);
	void updateEtudiant(Etudiant etudiant);
	List<Etudiant> getAllEtudiants();
	Etudiant getEtudiantByNom(String nom);
	void removeEtudiant(int id_etudiant);
}
