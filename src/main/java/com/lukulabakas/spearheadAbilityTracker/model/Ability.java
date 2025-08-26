package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Ability {

	private int id;
	private String name;
	private List<AbilityType> abilityTypes;
	private List<AbilitySource> abilitySource;
	private List<Phase> usableInPhases;
	private List<Integer> usableInBattleRounds;
	private String effect;
	
	public int getId() {return this.id;}
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	public void setAbilityType(List<AbilityType> abilityTypes) {this.abilityTypes = abilityTypes;}
	public List<AbilityType> getAbilityTypes(){return this.abilityTypes;}
	
	public void setAbilitySuperTypes(List<AbilitySource> abilitySuperTypes) {this.abilitySource = abilitySuperTypes;}
	public List<AbilitySource> getAbilitySuperTypes(){return this.abilitySource;}
	
	public void setPhases(List<Phase> phases) {this.usableInPhases = phases;}
	public List<Phase> getPhases(){return this.usableInPhases;}
	
	public void setBattleRounds(List<Integer> battleRounds) {this.usableInBattleRounds = battleRounds;}
	public List<Integer> getBattleRounds(){return this.usableInBattleRounds;}
	
	public void setEffect(String effect) {this.effect = effect;}
	public String getEffect() {return this.effect;}
}
