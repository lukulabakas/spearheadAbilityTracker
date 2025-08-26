package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Unit {
	
	private int id;
	private String name;
	private List<Ability> abilities;
	
	public List<Ability> getAbilities(){return this.abilities;}
	public void setAbilities(List<Ability> abilities) {this.abilities = abilities;}
	
	public String getName() {return this.name;}
	
	public int getId() {return this.id;}

}
