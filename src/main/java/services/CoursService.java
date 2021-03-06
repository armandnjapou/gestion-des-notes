package services;

import java.util.List;

import entities.Cours;
import entities.Etudiant;

public interface CoursService {
	void addCours(Cours cours);
	void updateCours(Cours cours);
	List<Cours> getAllCours();
	Cours getCoursByIntitule(String initutle);
	Cours getCoursByID(int id);
	void removeCours(String intitule);
	void removeCours(int id);
	List<Cours> getCoursByKey(String key);
}
