package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cours")
public class Cours {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_cours;
	
	@Column(name="intitule")
	private String intitule;
	
	@Column(name="nb_heure")
	private int nb_heure;
	
	@Column(name="coefficient")
	private int coefficient;
	
	@ManyToMany(mappedBy="cours")
	private List<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	public Cours() {}
	
	public Cours(int id, String intitule, int nb_heure, int coef) {
		this.id_cours = id;
		this.intitule = intitule;
		this.nb_heure = nb_heure;
		this.coefficient = coef;
	}
	
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

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}
