package entity;

public class Cours {
	
	private int id_cours;
	private String intitule;
	private int nb_heure;
	private int coefficient;
	
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public int getNb_heure() {
		return nb_heure;
	}
	public void setNb_heure(int nb_heure) {
		this.nb_heure = nb_heure;
	}
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	
	

}
