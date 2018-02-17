package dao;

import java.util.HashMap;
import java.util.List;

import entities.Cours;
import entities.Etudiant;
import entities.Suivre;

public interface NotesDao {
	void modifierNotesEtudiant(Etudiant etudiant, Cours cours, float note);
	void affecterNotesEtudiant(List<Etudiant> liste, Cours cours,float[] notes);
	HashMap<Etudiant, List<Suivre>> rechercher(String  nom);
}
