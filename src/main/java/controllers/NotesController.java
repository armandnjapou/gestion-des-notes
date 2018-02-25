package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.Cours;
import entities.Etudiant;
import entities.EtudiantNotes;
import services.CoursService;
import services.EtudiantService;

@Controller
public class NotesController {

	private EtudiantService etudiantService;
	
	@Autowired(required=true)
	@Qualifier(value="etudiantService")
	public void setEtudiantService(EtudiantService es) {
		this.etudiantService = es;
	}
	
	private CoursService coursService;
	
	@Autowired(required=true)
	@Qualifier(value="coursService")
	public void setCoursService(CoursService cs) {
		this.coursService = cs;
	}
	
	@RequestMapping(value="/notes", method = RequestMethod.GET)
	public String notes(Model model) {//model nous permet de passer des variables à la jsp
		
		List<Etudiant> listeEtudiants = etudiantService.getAllEtudiants();
		List<Cours> listeCours = coursService.getAllCours();
		List<EtudiantNotes> listenotesParEtudiant = etudiantService.getNotes(listeEtudiants,listeCours);
		model.addAttribute("liste", listenotesParEtudiant);
		model.addAttribute("listeCours", listeCours);
				
		return "notes";
	}
	
	@RequestMapping(value="/editNotes/{id}", method = RequestMethod.GET)
	public String modifiernotes(@PathVariable int id, Model model){
		
		List<Cours> listeCours = coursService.getAllCours();
		Etudiant E = etudiantService.getEtudiantById(id);
				
		EtudiantNotes EN = etudiantService.getNotes(E, listeCours);
		
		model.addAttribute("EN", EN);
		model.addAttribute("cours", listeCours);
		
		return "editNotes";
	}
	
	@RequestMapping(value="/editNotes", method = RequestMethod.POST)
	public String modifiernotesPost(Model model, HttpServletRequest request){
		int taille = Integer.valueOf(request.getParameter("taille"));
		int id_etudiant = Integer.valueOf(request.getParameter("id_etudiant"));
		List<String> notes = new ArrayList<String>();
		for(int i=1; i<=taille; i++) {
			String note = request.getParameter("note"+i);
			notes.add(note);
		}
		etudiantService.saveNotes(id_etudiant, coursService.getAllCours(), notes);
		
		List<Etudiant> listeEtudiants = etudiantService.getAllEtudiants();
		List<Cours> listeCours = coursService.getAllCours();
		List<EtudiantNotes> listenotesParEtudiant = etudiantService.getNotes(listeEtudiants,listeCours);
		model.addAttribute("liste", listenotesParEtudiant);
		model.addAttribute("listeCours", listeCours);
		
		return "redirect:/notes";
	}
	
	@RequestMapping(value="/editNotesCours/{id}", method = RequestMethod.GET)
	public String modifiernotesCours(@PathVariable int id, Model model){
		Cours C = coursService.getCoursByID(id);
		List<EtudiantNotes> etudiants = etudiantService.getNotes(etudiantService.getAllEtudiants(), C);
		
		model.addAttribute("EN", etudiants);
		model.addAttribute("C", C);
		
		return "editNotesCours";
	}
	
	@RequestMapping(value="/editNotesCours", method = RequestMethod.POST)
	public String modifiernotesCoursPost(Model model, HttpServletRequest request){
		int taille = Integer.valueOf(request.getParameter("taille"));
		int id = Integer.valueOf(request.getParameter("id_cours"));
		List<String> notes = new ArrayList<String>();
		for(int i=1; i<=taille; i++) {
			String note = request.getParameter("note"+i);
			notes.add(note);
		}
		etudiantService.saveNotes(etudiantService.getAllEtudiants(), notes, id);
		
		List<Etudiant> listeEtudiants = etudiantService.getAllEtudiants();
		List<Cours> listeCours = coursService.getAllCours();
		List<EtudiantNotes> listenotesParEtudiant = etudiantService.getNotes(listeEtudiants,listeCours);
		model.addAttribute("liste", listenotesParEtudiant);
		model.addAttribute("listeCours", listeCours);
		
		return "redirect:/notes";
	}
}
