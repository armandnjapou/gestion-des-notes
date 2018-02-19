package dao;

import java.util.List;

import entities.Cours;
import entities.Etudiant;
import entities.Suivre;

public interface SuivreDao {
	void affecterNoteToEtudiant(Etudiant etudiant, Cours cours, float note);
	void affecterNotesToEtudiants(List<Etudiant> liste, Cours cours, float[] notes);
	List<Suivre> getNotesOfEtudiant(Etudiant etudiant, List<Cours> cours);
	List<List<Suivre>> getNotesOfEtudiants(List<Etudiant> liste, List<Cours> cours);
	float moyenne(List<Suivre> liste);
	List<Cours> getCoursOfEtudiant(List<Suivre> liste, Etudiant E);
}
