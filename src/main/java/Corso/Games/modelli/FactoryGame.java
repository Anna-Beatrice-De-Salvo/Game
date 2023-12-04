package Corso.Games.modelli;


import java.sql.Date;
import java.util.HashMap;

public class FactoryGame {
	private static FactoryGame instance;
	private FactoryGame() {
		
	}
	
	public static FactoryGame getInstance() {
		if(instance==null) {
			instance=new FactoryGame();
		}
		return instance;
	}
	
	
	public  Game getGame(HashMap<String, Object> params) {
		Game g=new Game();
		if(params != null) {
			g.setId(params.get("id") != null ? (int) params.get("id"):0);
			g.setTitolo((String)params.get("titolo"));
		}
		return g;
	}
	
	public Team getTeam(HashMap<String,Object> params) {
		Team t= new Team();
			if(params != null) {
				t.setId(params.get("id") != null ?(int) params.get("id"):0);
				t.setNome((String)params.get("nome"));
				t.setNazione((String)params.get("nazione"));
				t.setIdGames((int)params.get("idGames"));
			}
			return t;
		}
	
	public Player getPlayer(HashMap<String,Object> params) {
		Player p=new Player();
		if(params != null) {
			p.setId(params.get("id")!=null ?(int)params.get("id"):0);
			p.setNickname((String)params.get("nickname"));
			p.setNome((String)params.get("nome"));
			p.setCognome((String)params.get("cognome"));
			p.setDatanascita((Date)params.get("datanascita"));
			p.setRuolo((String)params.get("ruolo"));
			p.setIdTeam((int)params.get("idTeam"));
		}
		return p;
	}
	public Match getMatch(HashMap <String,Object>params) {
		Match m=new Match();
		if(params != null) {
			m.setId(params.get("id")!= null ?(int)params.get("id"):0);
			m.setDataMatcheses((Date)params.get("dataMatcheses"));
			m.setIdGame((int)params.get("idGame"));
			m.setIdTeamHome((int)params.get("idTeamHome"));
			m.setIdTeamAway((int)params.get("idTeamAway"));
			m.setPuntiHome((int)params.get("puntiHome"));
			m.setPuntiAway((int)params.get("puntiAway"));
			
		}
		return m;
	}
	
}
