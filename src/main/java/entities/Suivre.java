package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="suivre")
public class Suivre {

	@Column(name="note")
	private float note;
	
	@Column(name="id_etudiant")
	private int id_etudiant;
	
	@Column(name="id_cours")
	private int id_cours;
	
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public int getId_etudiant() {
		return id_etudiant;
	}
	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
}
