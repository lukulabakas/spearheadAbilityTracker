package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Game {

	private int id;
	//list of the armies participing in this game
	private List<List<ArmyState>> teams;
	//saves the current turn the game is in
	private int battleRound;
	//saves the reference to the team whose turn it is
	private int activeTeam;
	
	public Game(int id) {
		this.id = id;
		this.battleRound = 1;
		//reference to an object in the teams List, thus starting at 0
		this.activeTeam = 0;
	}
	
	public int getId() {return this.id;}
	
	public List<List<ArmyState>> getTeams(){return this.teams;}
	public void setTeams(List<List<ArmyState>> teams) {this.teams = teams;}
	
	public void setBattleRound(int turn) {this.battleRound = turn;}
	public int getBattleRound() {return this.battleRound;}
	
	public int getActiveTeam() {return this.activeTeam;}
	public void setActiveTeam(int activeTeam) {this.activeTeam = activeTeam;}
}
