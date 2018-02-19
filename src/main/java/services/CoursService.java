package services;

import java.util.List;

import entities.Cours;

public interface CoursService {
	void addCours(Cours cours);
	void updateCours(Cours cours);
	List<Cours> getAllCours();
	Cours getCoursByIntitule(String initutle);
	void removeCours(String intitule);
}
