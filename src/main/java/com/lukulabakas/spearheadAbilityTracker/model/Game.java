package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Game {

	private int id;
	//list of the teams in this game, order in the list is turn order; get(0) goes first
	private List<Team> teams;
	//1, 2, 3, 4
	int currentBattleRound;
	//reference to the team that is currently taking their turn
	Team activeTeam;
	
	public Game(int id) {
		this.id = id;
	}

	public List<Team> getTeams() {return teams;}
	public void setTeams(List<Team> teams) {this.teams = teams;}
	
	public int getCurrentBattleRound() {return currentBattleRound;}
	public void setCurrentBattleRound(int currentBattleRound) {this.currentBattleRound = currentBattleRound;}
	
	public Team getActiveTeam() {return activeTeam;}
	public void setActiveTeam(Team activeTeam) {this.activeTeam = activeTeam;}
	
	//id cannot be changed afterwards, only in constructor
	public int getId() {return id;}
}
