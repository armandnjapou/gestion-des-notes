package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SuivreController {

	@RequestMapping(value="/notes", method = RequestMethod.GET)
	public String notes(Model model) {
		
		List<String> cours = new ArrayList<String>();
		cours.add("Graphes");
		cours.add("Anglais");
		cours.add("Algorithmique");
		
		model.addAttribute("cours", cours);
		
		return "notes";
	}
}
