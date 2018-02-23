package dao;

import java.util.List;

import entities.Cours;
import entities.Etudiant;
import entities.EtudiantNotes;

public interface EtudiantDao {
	
	void addEtudiant (Etudiant etudiant);
	void updateEtudiant(Etudiant etudiant);
	List<Etudiant> getAllEtudiants();
	Etudiant getEtudiantByNom(String nom);
	Etudiant getEtudiantById(int ID);
	void removeEtudiant(int id_etudiant);
	List<EtudiantNotes> getNotes(List<Etudiant> liste, List<Cours> listecours);
}
