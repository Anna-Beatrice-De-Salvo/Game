package Corso.Games.database;

import java.util.ArrayList;
import java.util.HashMap;

import Corso.Games.modelli.FactoryGame;
import Corso.Games.modelli.Match;

public class MatchesDAO {

	private static MatchesDAO instance;
	private MatchesDAO() {
		
	}
	public static MatchesDAO getInstance() {
		if(instance==null)
			instance=new MatchesDAO();
		return instance;
	}
	
	private HashMap<Integer,Match> readAll(String query,String... params){
		ArrayList<HashMap<String,Object>>listaMappe=Database.getInstance().eseguiQuery(query, params);
		Match m=null;
		HashMap<Integer,Match> ris= new HashMap<Integer,Match>();
		for(HashMap<String,Object>record:listaMappe) {
			m=FactoryGame.getInstance().getMatch(record);
			ris.put(m.getId(), m);
		}
		return ris;
	}
	 public HashMap<Integer,Match> read(){
		 String query= "select games.titolo, matches.dataMatcheses, H.nome, puntiHome, puntiAway, A.nome"+
		 		       "from games join matches on games.id=matches.idGame join teams H on matches.idTeamHome= H.id"
		 		       +"join teams A on matches.idTeamAway=A.id";
		 return readAll(query);
		 		
	 }
	 private boolean update(String query, String... params) {
			return Database.getInstance().eseguiUpdate(query, params); 
		}
	 
	public boolean update(HashMap<String,String>parametri) {
		String query="update matches set dataMatcheses=?,idGame=?, idTeamHome=?, idTeamAway=?, puntiHome=?, puntiAway=? where id = ?";
		return update(query,
				parametri.get("dataMatcheses"),
				parametri.get("idGame"),
				parametri.get("idTeamHome"),
				parametri.get("idTeamAway"),
				parametri.get("puntiHome"),
				parametri.get("puntiAway"),
				parametri.get("id"));
		
	}
	
	public boolean create(HashMap<String,String>parametri) {
		String query="insert into matches (dataMatcheses, idGame, idTeamHome, idTeamAway, puntiHome, puntiAway) values (?,?,?,?,?,?)";
		return update(query,
				parametri.get("dataMatcheses"),
				parametri.get("idGame"),
				parametri.get("idTeamHome"),
				parametri.get("idTeamAway"),
				parametri.get("puntiHome"),
				parametri.get("puntiAway"));
	}
	
	public boolean delete(HashMap<String,String>parametri) {
		String query="delete from matches where id=?";
		return update(query,parametri.get("id"));
	}
}
