package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Game {

	private int id;
	//list of the armies participing in this game
	private List<ArmyState> armies;
	//saves the current turn the game is in
	private int turn;
	
	public Game(int id) {
		this.id = id;
		this.turn = 0;
	}
	
	public int getId() {return this.id;}
	
	public List<ArmyState> getArmies(){return this.armies;}
	public void setArmies(List<ArmyState> armies) {this.armies = armies;}
	
	public void setTurn(int turn) {this.turn = turn;}
	public int getTurn() {return this.turn;}
}
