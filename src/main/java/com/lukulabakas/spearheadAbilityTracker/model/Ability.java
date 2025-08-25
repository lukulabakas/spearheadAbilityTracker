package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Ability {

	private String name;
	private List<AbilityType> abilityTypes;
	//determines where the ability comes from (unit, battle trait etc.)
	private List<AbilitySuperType> abilitySuperTypes;
	//determines when the ability can be used
	private List<Phase> phases;
	private List<Integer> battleRounds;
	private String effect;
	//if the number of uses is limited the attribute "uses" detmerines the amount 
	//"limitedUses" is always to be checked before using "uses"
	private boolean limitedUses;
	private int uses;
	private boolean active;
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	public void setAbilityType(List<AbilityType> abilityTypes) {this.abilityTypes = abilityTypes;}
	public List<AbilityType> getAbilityTypes(){return this.abilityTypes;}
	
	public void setAbilitySuperTypes(List<AbilitySuperType> abilitySuperTypes) {this.abilitySuperTypes = abilitySuperTypes;}
	public List<AbilitySuperType> getAbilitySuperTypes(){return this.abilitySuperTypes;}
	
	public void setPhases(List<Phase> phases) {this.phases = phases;}
	public List<Phase> getPhases(){return this.phases;}
	
	public void setBattleRounds(List<Integer> battleRounds) {this.battleRounds = battleRounds;}
	public List<Integer> getBattleRounds(){return this.battleRounds;}
	
	public void setEffect(String effect) {this.effect = effect;}
	public String getEffect() {return this.effect;}
	
	public void setLimitedUses(boolean limitedUses) {this.limitedUses = limitedUses;}
	public boolean getLimitedUses() {return this.limitedUses;}
	
	public void setUses(int uses) {this.uses = uses;}
	public int getUses() {return this.uses;}
	
	public void setActive(boolean active) {this.active = active;}
	public boolean getActive() {return this.active;}
}
