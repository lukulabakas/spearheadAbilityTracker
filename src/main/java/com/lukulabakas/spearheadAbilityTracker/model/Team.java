package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Team {

	private List<ArmyState> armies;
	private int id;
	
	public void setArmies(List<ArmyState> armies){this.armies = armies;}
	public List<ArmyState> getArmies() {return this.armies;}
	
	public int getId() {return this.id;}	
}
