package Corso.Games.database;

import java.util.ArrayList;
import java.util.HashMap;

import Corso.Games.modelli.FactoryGame;
import Corso.Games.modelli.Team;

public class TeamsDAO {

	private static TeamsDAO instance;
	private TeamsDAO() {
		
	}
	public static TeamsDAO getInstance() {
		if(instance==null)
			instance= new TeamsDAO();
		return instance;
	}
	
	private HashMap<Integer,Team> readAll(String query,String... params){
	ArrayList<HashMap<String, Object>> listaMappe= Database.getInstance().eseguiQuery(query, params);
	Team t= null;
	HashMap<Integer,Team> ris= new HashMap<Integer,Team>();
	for(HashMap<String,Object> record:listaMappe) {
		t= FactoryGame.getInstance().getTeam(record);
		ris.put(t.getId(), t);
	}
	return ris;
	}
	public HashMap<Integer,Team>read(){
		String query="select nome,nazione,titolo from teams inner join games on teams.id=games.id";
		return readAll(query);
	}
	
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	public boolean update(HashMap<String,String>parametri) {
		String query="update teams set nome = ?,nazione = ? where id = ? ";
		return update(query,
				parametri.get("nome"),
				parametri.get("nazione"),
				parametri.get("id"));
	}
	
	public boolean create(HashMap<String,String>parametri) {
		String query="insert into team (nome,nazione,idGames) values (?,?,?)";
		return update(query,
				      parametri.get("nome"),
				      parametri.get("nazione"),
				      parametri.get("idGames"));
	}
	public boolean delete(HashMap<String,String>parametri) {
		String query="delete from teams where id=?";
		return update(query,parametri.get("id"));
	}
}
