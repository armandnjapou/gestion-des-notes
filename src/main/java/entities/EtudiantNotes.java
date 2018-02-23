package entities;

import java.util.List;

public class EtudiantNotes {
	
	private Etudiant etudiant;
	private List<String> notes;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public List<String> getNotes() {
		return notes;
	}
	public void setNotes(List<String> notes) {
		this.notes = notes;
	}
	
	

}
