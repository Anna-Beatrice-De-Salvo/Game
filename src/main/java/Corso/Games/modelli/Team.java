package Corso.Games.modelli;

public class Team extends Entity{

	private String nome;
	private String nazione;
	private int idGames;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public int getGames() {
		return idGames;
	}
	public void setIdGames(int idGames) {
		this.idGames = idGames;
	}
	@Override
	public String toString() {
		return "Team [nome=" + nome + ", nazione=" + nazione + ", game=" + idGames + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
