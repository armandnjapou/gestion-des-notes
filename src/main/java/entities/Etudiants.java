package entities;

public class Etudiants {
	private int id_etudiant;
	private String nom;
	private String genre;
	private String date_naissance;
	private String adresse;
	
	
	public Etudiants(String nom, String genre, String date_naissance, String adresse) {
		super();
		this.nom = nom;
		this.genre = genre;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
	}
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
	
	
}
