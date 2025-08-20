package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

//represents the static ruleset for an army
public class Army {

	private String name;
	private List<Unit> units;
	private List<Ability> enhancements;
	private List<Ability> regimentAbilities;
	private List<Ability> battleTraits;

	//the attributes of an army can be retrieved but never changed 
	//always static info, e.g. game rules
	public String getName() {return this.name;}
	public List<Unit> getUnits(){return this.units;}
	public List<Ability> getEnhancements(){return this.enhancements;}
	public List<Ability> getRegimentAbilities(){return this.regimentAbilities;}
	public List<Ability> getBattleTraits(){return this.battleTraits;}
}
