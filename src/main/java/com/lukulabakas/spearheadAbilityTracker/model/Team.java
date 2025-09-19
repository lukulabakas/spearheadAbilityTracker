package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Team {

	private int id;
	private List<ArmyState> armies;
	private int points;

	public void setArmies(List<ArmyState> armies){this.armies = armies;}
	public List<ArmyState> getArmies() {return this.armies;}
	
	public int getId() {return this.id;}	
	
	public void setPoints(int points) {this.points = points;}
	public int getPoints() {return this.points;}
	
	public void addPoints(int points) {
		this.points += points;
	}
}
