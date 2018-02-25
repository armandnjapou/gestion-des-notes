package dao;

import java.util.List;

import entities.Cours;
import entities.Etudiant;

public interface CoursDao {
	void addCours(Cours cours);
	void updateCours(Cours cours);
	List<Cours> getAllCours();
	Cours getCoursByIntitule(String initule);
	Cours getCoursByID(int id);
	void removeCours(String intitule);
	void removeCours(int id);
}
