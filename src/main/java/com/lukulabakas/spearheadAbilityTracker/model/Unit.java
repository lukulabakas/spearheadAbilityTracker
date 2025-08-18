package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Unit {
	
	private String name;
	//private int modelCount;
	private boolean destroyed;
	private List<Ability> abilities;
	
	
	public void destroyUnit() {destroyed = true;}
	public void reviveUnit() {destroyed = false;}
	public boolean getDestroyed() {return this.destroyed;}
	
	public List<Ability> getAbilities(){return this.abilities;}
	public void setAbilities(List<Ability> abilities) {this.abilities = abilities;}
	
	public String getName() {return this.name;}

}
