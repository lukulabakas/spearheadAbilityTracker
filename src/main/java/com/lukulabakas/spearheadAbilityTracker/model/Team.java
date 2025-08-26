package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Team {

	private int id;
	private List<ArmyState> armies;

	public void setArmies(List<ArmyState> armies){this.armies = armies;}
	public List<ArmyState> getArmies() {return this.armies;}
	
	public int getId() {return this.id;}	
}
