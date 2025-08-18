package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.Set;

public class Army {
	
	private String name;
	private Set<Unit> units;
	private Set<Ability> abilities;
	
	
	public void setAbilities(Set<Ability> abilities) {this.abilities = abilities;}
	public Set<Ability> getAbilities(){return this.abilities;}
	
	public void setUnits(Set<Unit> units) {this.units = units;}
	public Set<Unit> getUnits(){return this.units;}

}
