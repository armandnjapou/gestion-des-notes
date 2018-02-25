package services;

import java.util.List;

import entities.Cours;
import entities.Etudiant;
import entities.EtudiantNotes;

public interface EtudiantService {
	void addEtudiant (Etudiant etudiant);
	void updateEtudiant(Etudiant etudiant);
	List<Etudiant> getAllEtudiants();
	Etudiant getEtudiantByNom(String nom);
	Etudiant getEtudiantById(int ID);
	void removeEtudiant(int id_etudiant);
	List<EtudiantNotes> getNotes(List<Etudiant> liste, List<Cours> listecours);
	EtudiantNotes getNotes(Etudiant E, List<Cours> listeCours);
	void saveNotes(int id_etudiant, List<Cours> cours, List<String> notes);
	List<EtudiantNotes> getNotes(List<Etudiant> liste, Cours cours);
	void saveNotes(List<Etudiant> etudiants, List<String> notes, int id_cours);
}
