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

import entities.Etudiant;
import services.EtudiantService;

@Controller
public class EtudiantController {
	
	private EtudiantService etudiantService;
	
	@Autowired(required=true)
	@Qualifier(value="etudiantService")
	public void setEtudiantService(EtudiantService es) {
		this.etudiantService = es;
	}

	@RequestMapping(value="/etudiants", method=RequestMethod.GET)
	public String etudiants(Model model) {
		List<Etudiant> etudiants = etudiantService.getAllEtudiants();
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("etudiant", new Etudiant());
		return "etudiants";
	}
	
	@RequestMapping(value="/etudiants", method=RequestMethod.POST)
	public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, Model model) {
		
		etudiantService.addEtudiant(etudiant);
		System.out.println("Etudiant enregistré : "+etudiant.getNom());
		List<Etudiant> etudiants = etudiantService.getAllEtudiants();
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("etudiant", new Etudiant());
		return "etudiants";
	}
	
	@RequestMapping(value="/etudiants/{id}", method=RequestMethod.GET)
	public String editEtudiantForm(@PathVariable int id, Model model) {
		
		Etudiant etudiant = etudiantService.getEtudiantById(id);
		System.out.println(etudiant.getGenre());
		model.addAttribute("E", etudiant);
		model.addAttribute("etudiant", new Etudiant());
		
		return "etudiantEdit";
	}
	
	@RequestMapping(value="/etudiants/{id}", method=RequestMethod.POST)
	public String editEtudiant(@PathVariable int id, @ModelAttribute("etudiant") Etudiant etudiant,  Model model) {
		
		etudiant.setId_etudiant(id);
		etudiantService.updateEtudiant(etudiant);
		
		model.addAttribute("msg", "OK");
		model.addAttribute("E", etudiant);
		
		List<Etudiant> etudiants = etudiantService.getAllEtudiants();
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("etudiant", new Etudiant());
		return "etudiants";
	}
	
	@RequestMapping(value="/supprimerEtudiant/{id}", method=RequestMethod.GET)
	public @ResponseBody Etudiant supprimer(@PathVariable int id, Model model) {
		
		Etudiant E = etudiantService.getEtudiantById(id);
		System.out.println("Je fais de l'AJAX "+E.getAdresse());
		etudiantService.removeEtudiant(id);
		return E;
	}
}
