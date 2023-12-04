package Corso.Games.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Corso.Games.database.DaoFacade;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String Game(Model model) {
		model.addAttribute("listaGiochi",DaoFacade.getInstance().readGioco());
		return "game.html";
	}
	
	@PostMapping("/aggiungiGame")
	public String newGame(@RequestParam HashMap<String,String>parametri) {
		DaoFacade.getInstance().nuovoGioco(parametri);
		return "redirect:/";
	}
	
	@PostMapping("/eliminaGame")
	public String delGame(@RequestParam HashMap<String,String>parametri) {
		DaoFacade.getInstance().deleteGioco(parametri);
		return "redirect:/";
	}
	
	@PostMapping("/modificaGame")
	public String modGame(@RequestParam HashMap<String,String>parametri) {
		DaoFacade.getInstance().updateGioco(parametri);
		return "redirect:/";
	}
	
	
	
	
	

}
