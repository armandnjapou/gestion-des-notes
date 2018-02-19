package controllers;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entities.Etudiant;
import entities.Users;
import services.EtudiantService;
import services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private EtudiantService etudiantService;
	
	@Autowired(required=true)
	@Qualifier(value="etudiantService")
	public void setEtudiantService(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("user", new Users());
		/*Etudiant et = new Etudiant();
		et.setNom("Moussa");
		et.setGenre("Masculin");
		et.setDate_naissance("21/05/1993");
		et.setAdresse("8 rue du Salop");*/
		List<Etudiant> L =  etudiantService.getAllEtudiants();
		for(Etudiant e : L)
			System.out.println(e.getNom()+" "+e.getAdresse()+" "+e.toString());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String getConnection(@ModelAttribute("user") Users user, Model model, HttpServletRequest request) {
		
		
		System.out.println("Je suis dans le POST : "+user.toString());
		Users u = userService.checkUser(user);
		if(u == null) {
			model.addAttribute("msg", "Error");
			return "home";
		}
		else {
			model.addAttribute("user", user);
			HttpSession session = request.getSession();
			session.setAttribute("userSession", user);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		return "dashboard";
	}
	
	@RequestMapping(value="/disconnect", method = RequestMethod.GET)
	public String disconnect(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("user", new Users());
		return "redirect:/";
	}
	
}
