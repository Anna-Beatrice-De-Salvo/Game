package Corso.Games.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Corso.Games.database.DaoFacade;

@Controller
@RequestMapping("/gioco")
public class GameController {

	// Apriamo la pagina del gioco scelto, avendo quindi un parametro in
	// input che dalla pagina home che ci dice quale gioco aprire e con quali
	@GetMapping("/")
	public String openGame(@RequestParam("idGames") String idGames, Model model) {
		model.addAttribute("nomeGame", idGames);
		model.addAttribute("listaTeam",DaoFacade.getInstance().readTeam());
		return "gioco.html";
	}
	
	@PostMapping("/aggiungiTeam")
	public String newGame(@RequestParam HashMap<String,String>parametri) {
		DaoFacade.getInstance().nuovoTeam(parametri);
		return "redirect:/gioco/";
	}
	
	@PostMapping("/eliminaTeam")
	public String delGame(@RequestParam HashMap<String,String>parametri) {
		DaoFacade.getInstance().deleteTeam(parametri);
		return "redirect:/gioco/";
	}
	
	@PostMapping("/modificaTeam")
	public String modGame(@RequestParam HashMap<String,String>parametri) {
		DaoFacade.getInstance().updateTeam(parametri);
		return "redirect:/";
	}




}
