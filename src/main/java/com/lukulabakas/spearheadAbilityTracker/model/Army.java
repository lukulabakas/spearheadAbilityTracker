package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Army {
	
	private String name;
	private List<Unit> units;
	private List<Ability> abilities;
	
	
	public void setAbilities(List<Ability> abilities) {this.abilities = abilities;}
	public List<Ability> getAbilities(){return this.abilities;}
	
	public void setUnits(List<Unit> units) {this.units = units;}
	public List<Unit> getUnits(){return this.units;}

}
