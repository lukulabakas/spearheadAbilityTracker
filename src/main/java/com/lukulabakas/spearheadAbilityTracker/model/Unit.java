package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.Set;

public class Unit {
	
	private String name;
	//private int modelCount;
	private boolean destroyed;
	private Set<Ability> abilities;
	
	
	public void destroyUnit() {destroyed = true;}
	public void reviveUnit() {destroyed = false;}
	public boolean getDestroyed() {return this.destroyed;}
	
	public Set<Ability> getAbilities(){return this.abilities;}
	public void setAbilities(Set<Ability> abilities) {this.abilities = abilities;}
	
	public String getName() {return this.name;}

}
