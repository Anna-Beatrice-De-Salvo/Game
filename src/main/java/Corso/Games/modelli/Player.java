package Corso.Games.modelli;

import java.sql.Date;

public class Player extends Entity{
private String nickname;
private String nome;
private String cognome;
private Date datanascita;
private String ruolo;
private int idTeam;


public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public Date getDatanascita() {
	return datanascita;
}
public void setDatanascita(Date datanascita) {
	this.datanascita = datanascita;
}
public String getRuolo() {
	return ruolo;
}
public void setRuolo(String ruolo) {
	this.ruolo = ruolo;
}
public int getIdTeam() {
	return idTeam;
}
public void setIdTeam(int idTeam) {
	this.idTeam = idTeam;
}
@Override
public String toString() {
	return "Player [nickname=" + nickname + ", nome=" + nome + ", cognome=" + cognome + ", datanascita=" + datanascita
			+ ", ruolo=" + ruolo + ", team=" + idTeam + ", toString()=" + super.toString() + "]";
}




}
