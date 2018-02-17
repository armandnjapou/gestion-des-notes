package services;

import java.util.List;

import entities.Etudiant;

public interface EtudiantService {
	void addEtudiant (Etudiant etudiant);
	void updateEtudiant(Etudiant etudiant);
	List<Etudiant> getAllEtudiants();
	Etudiant getEtudiantByNom(String nom);
	void removeEtudiant(int id_etudiant);
}
