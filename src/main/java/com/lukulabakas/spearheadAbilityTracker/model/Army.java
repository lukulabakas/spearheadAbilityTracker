package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Army {
	
	private String name;
	private List<Unit> units;
	private Ability enhancement;
	private Ability regimentAbility;
	private List<Ability> battleTraits;
	
	
	public void setEnhancement(Ability enhancement) {this.enhancement = enhancement;}
	public Ability getEnhancement(){return this.enhancement;}
	
	public void setUnits(List<Unit> units) {this.units = units;}
	public List<Unit> getUnits(){return this.units;}
	
	public void setRegimentAbility(Ability regimentAbility) {this.regimentAbility = regimentAbility;}
	public Ability getRegimentAbility() {return this.regimentAbility;}
	
	public String getName() {return this.name;}
	
	public List<Ability> getBattleTraits(){return this.battleTraits;}
	public void setBattleTraits(List<Ability> battleTraits) {this.battleTraits = battleTraits;}
}
