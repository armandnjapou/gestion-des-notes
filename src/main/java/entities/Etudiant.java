package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="etudiants")
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_etudiant;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="date_naissance")
	private String date_naissance;
	
	@Column(name="adresse")
	private String adresse;
	
	private List<Cours> cours = new ArrayList<Cours>();
	
	public Etudiant() {}
	
	public Etudiant(String nom, String genre, String date_naissance, String adresse) {
		super();
		this.nom = nom;
		this.genre = genre;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
	}
	
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
    @JoinTable(name = "suivre",
        joinColumns = @JoinColumn(name = "id_etudiant"),
        inverseJoinColumns = @JoinColumn(name = "id_cours")
    )
	
	
	public int getId_etudiant() {
		return id_etudiant;
	}
	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void addCours(Cours c) {
        cours.add(c);
        c.getEtudiants().add(this);
    }
 
    public void removeCours(Cours c) {
    	cours.remove(c);
    	c.getEtudiants().remove(this);
    }
}
