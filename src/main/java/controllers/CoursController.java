package controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Cours;
import entities.Etudiant;
import services.CoursService;
import services.EtudiantService;

@Controller

public class CoursController {
	private CoursService coursService;


    @Autowired
    @Qualifier(value="coursService")
	public void setCoursService(CoursService cs) {
		this.coursService = cs;
	}
    
  /*  @RequestMapping(value="/cours", method=RequestMethod.GET)
	public String cours(Model model) {
		List<Cours> cours = coursService.getAllCours();
		model.addAttribute("cours", cours);
		model.addAttribute("cour", new Cours());
		return "cours";
	}*/
    
	@RequestMapping(value="/cours", method = RequestMethod.GET)
	public String notes(Model model) {//model nous permet de passer des variables � la jsp
		List<Cours> listeCours = coursService.getAllCours();
		model.addAttribute("listeCours", listeCours);
		model.addAttribute("cours", new Cours());
				
		return "cours";
	}
	@RequestMapping(value="/cours", method=RequestMethod.POST)
	public String saveEtudiant(@ModelAttribute("cours") Cours cours, Model model) {
		
		coursService.addCours(cours);
		System.out.println("Cours enregistr� : "+cours.getIntitule());
		List<Cours> listeCours = coursService.getAllCours();
		model.addAttribute("listeCours", listeCours);
		model.addAttribute("cours", new Cours());
		return "cours";
   
    
	}
    
	@RequestMapping(value="/cours/{id}", method=RequestMethod.GET)
	public String editCoursForm(@PathVariable int id, Model model) {

		Cours cours= coursService.getCoursByID(id);
		System.out.println(cours.getCoefficient());
		model.addAttribute("C", cours);
		model.addAttribute("cours", new Cours());
		
		return "coursEdit";
      
	
	}
	
	@RequestMapping(value="/cours/{id}", method=RequestMethod.POST)
	public String editCours(@PathVariable int id, @ModelAttribute("cours") Cours cours,  Model model) {
		
		cours.setId_cours(id);
		coursService.updateCours(cours);
		
		model.addAttribute("msg", "OK");
		model.addAttribute("C", cours);
		
		List<Cours> listeCours = coursService.getAllCours();
		model.addAttribute("listeCours", listeCours);
		model.addAttribute("cours", new Cours());
		return "cours";
	
}
	
	@RequestMapping(value="/supprimerCours/{id}", method=RequestMethod.GET)
	public @ResponseBody Cours supprimer(@PathVariable int id, Model model) {
		Cours C = coursService.getCoursByID(id);
		
		System.out.println("Je fais de l'AJAX "+C.getId_cours());
		coursService.removeCours(id);
		return C;
	}
	
}
