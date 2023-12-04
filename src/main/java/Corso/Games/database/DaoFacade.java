package Corso.Games.database;

import java.util.HashMap;

import Corso.Games.modelli.FactoryGame;
import Corso.Games.modelli.Game;
import Corso.Games.modelli.Match;
import Corso.Games.modelli.Player;
import Corso.Games.modelli.Team;

public class DaoFacade {
	private static DaoFacade instance;

	public DaoFacade() {
	}

	public static DaoFacade getInstance() {
		if(instance == null) 
			instance = new DaoFacade();
		return instance;
	}
	
	public HashMap<Integer,Game> readGioco(){
		return GamesDAO.getInstance().readTitolo();
	}
	public HashMap<Integer,Team> readTeam(){
		return TeamsDAO.getInstance().read();
	}
	
	public HashMap<Integer,Player> readGiocatori(){
		return PlayersDAO.getInstance().read();
	}
	public HashMap<Integer,Match> readMatch(){
		return MatchesDAO.getInstance().read();
	}
	
	public boolean updateGioco(HashMap<String, String> parametri){
		return GamesDAO.getInstance().update(parametri);
	}
	public boolean updateTeam(HashMap<String, String> parametri) {
		return TeamsDAO.getInstance().update(parametri);
	}
	public boolean updateGiocatore(HashMap<String, String> parametri) {
		return PlayersDAO.getInstance().update(parametri);
	}
	public boolean updateMatch(HashMap<String, String> parametri) {
	return MatchesDAO.getInstance().update(parametri);
	}
	public boolean nuovoGioco(HashMap<String, String> parametri) {
		return GamesDAO.getInstance().create(parametri);
	}
	public boolean nuovoTeam(HashMap<String, String> parametri) {
		return TeamsDAO.getInstance().create(parametri);
	}
	public boolean nuovoGiocatore(HashMap<String, String> parametri) {
		return PlayersDAO.getInstance().create(parametri);
	}
	public boolean nuovoMatch(HashMap<String, String> parametri) {
		return MatchesDAO.getInstance().create(parametri);
	}
	
	
	public boolean deleteGioco(HashMap<String, String> parametri) {
		return GamesDAO.getInstance().delete(parametri);
	}
	
	public boolean deleteTeam(HashMap<String, String> parametri) {
		return TeamsDAO.getInstance().delete(parametri);
	}
	public boolean deleteGiocatore(HashMap<String, String> parametri) {
		return PlayersDAO.getInstance().delete(parametri);
	}
	public boolean deleteMatch(HashMap<String, String> parametri) {
		return MatchesDAO.getInstance().delete(parametri);
	}
}
