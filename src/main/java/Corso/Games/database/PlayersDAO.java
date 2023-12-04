package Corso.Games.database;

import java.util.ArrayList;
import java.util.HashMap;

import Corso.Games.modelli.FactoryGame;
import Corso.Games.modelli.Player;

public class PlayersDAO {

	private static PlayersDAO instance;
	private PlayersDAO() {
		
	}
	public static PlayersDAO getInstance() {
		if(instance==null)
			instance=new PlayersDAO();
		return instance;
	}
	
	private HashMap<Integer,Player> readAll(String query,String...params){
		ArrayList<HashMap<String,Object>> listaMappe= Database.getInstance().eseguiQuery(query, params);
		Player p= null;
		HashMap<Integer,Player> ris= new HashMap<Integer,Player>();
		for(HashMap<String,Object>record:listaMappe) {
			p=FactoryGame.getInstance().getPlayer(record);
			ris.put(p.getId(),p);
		}
		return ris;
	}
	public HashMap<Integer,Player> read(){
		String query="select nickname,giocatori.nome,cognome,datanascita,ruolo,teams.nome, titolo from giocatori inner join teams on teams.id=giocatori.idTeam inner join games on games.id=teams.idGames";
		return readAll(query);
	}
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	public boolean update(HashMap<String,String>parametri) {
		String query="update giocatori set nickname=?,nome=?,cognome=?,datanascita=?,ruolo=?,idTeam=? where id=?";
		return update(query,parametri.get("nickname"),
				       parametri.get("nome"),
				       parametri.get("cognome"),
				       parametri.get("datanascita"),
				       parametri.get("ruolo"),
				       parametri.get("idTeam"),
				       parametri.get("id"));
	}
	public boolean create(HashMap<String,String>parametri) {
		String query="insert into giocatori(nickname,nome,cognome,datanascita,ruolo,idTeam)values(?,?,?,?,?,?)";
		return update(query,parametri.get("nickname"),
				parametri.get("nome"),
				parametri.get("cognome"),
				parametri.get("datanascita"),
				parametri.get("ruolo"),
				parametri.get("idTeam"));	
	}
	
	public boolean delete(HashMap<String,String>parametri) {
		String query="delete from giocatori where id=?";
		return update(query,parametri.get("id"));
	}
	
}
