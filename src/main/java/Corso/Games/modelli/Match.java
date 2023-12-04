package Corso.Games.modelli;

import java.sql.Date;

public class Match extends Entity{
private Date dataMatcheses;
private int idGame;
private int idTeamHome;
private int idTeamAway;
private int puntiHome;
private int puntiAway;
public Date getDataMatcheses() {
	return dataMatcheses;
}
public void setDataMatcheses(Date dataMatcheses) {
	this.dataMatcheses = dataMatcheses;
}



public int getIdGame() {
	return idGame;
}
public void setIdGame(int idGame) {
	this.idGame = idGame;
}
public int getIdTeamHome() {
	return idTeamHome;
}
public void setIdTeamHome(int idTeamHome) {
	this.idTeamHome = idTeamHome;
}
public int getIdTeamAway() {
	return idTeamAway;
}
public void setIdTeamAway(int idTeamAway) {
	this.idTeamAway = idTeamAway;
}
public int getPuntiHome() {
	return puntiHome;
}
public void setPuntiHome(int puntiHome) {
	this.puntiHome = puntiHome;
}
public int getPuntiAway() {
	return puntiAway;
}
public void setPuntiAway(int puntiAway) {
	this.puntiAway = puntiAway;
}
@Override
public String toString() {
	return "Match [dataMatcheses=" + dataMatcheses + ", game=" + idGame + ", teamHome=" + idTeamHome + ", teamAway="
			+ idTeamAway + ", puntiHome=" + puntiHome + ", puntiAway=" + puntiAway + ", toString()=" + super.toString()
			+ "]";
}

	
	
}
