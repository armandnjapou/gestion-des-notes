package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.Cours;
import entities.Etudiant;
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
		
		model.addAttribute("liste", listeEtudiants);
		model.addAttribute("listeCours", listeCours);
				
		return "notes";
	}
}
