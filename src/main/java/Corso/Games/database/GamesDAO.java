package Corso.Games.database;

import java.util.ArrayList;
import java.util.HashMap;

import Corso.Games.modelli.FactoryGame;
import Corso.Games.modelli.Game;

public class GamesDAO {

	private static GamesDAO instance;
	private GamesDAO() {
		
	}
	public static GamesDAO getInstance() {
		if(instance==null)
			instance=new GamesDAO();
		return instance;
	}
	
	private HashMap<Integer, Game> readAll(String query, String... params){
	ArrayList<HashMap<String,Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
	Game g =null;
	HashMap<Integer,Game> ris=new HashMap<Integer,Game>();
	for(HashMap<String,Object> record:listaMappe) {
		g=FactoryGame.getInstance().getGame(record);
		ris.put(g.getId(), g);
	}
	return ris;
	}
	
	public HashMap<Integer,Game> readTitolo(){
		String query= "select* from games";
		return readAll(query);
	}
	
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	public boolean update(HashMap<String,String> parametri) {
		String query= "update games set titolo = ? where id = ?";
		return update(query,parametri.get("titolo"),parametri.get("id"));
	}
	public boolean create(HashMap<String,String> parametri) {
		String query="insert into games (titolo) values(?)";
		return update(query,parametri.get("titolo"));
	}
	public boolean delete(HashMap<String,String> parametri) {
		String query="delete from games where id=?";
		return update(query,parametri.get("id"));
	}
}
