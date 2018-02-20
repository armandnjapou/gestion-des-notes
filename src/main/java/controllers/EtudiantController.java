package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
