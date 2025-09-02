package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Ability {

	private int id;
	private String name;
	private List<AbilityType> abilityTypes;
	private AbilitySource abilitySource;
	private Unit sourceUnit;
	private List<Phase> usableInPhases;
	private List<Integer> usableInBattleRounds;
	private AbilityScope abilityScope;
	private String effect;
	
	public int getId() {return this.id;}
	
	public void setName(String name) {this.name = name;}
	public String getName() {return this.name;}
	
	public void setAbilityType(List<AbilityType> abilityTypes) {this.abilityTypes = abilityTypes;}
	public List<AbilityType> getAbilityTypes(){return this.abilityTypes;}
	
	public void setAbilitySuperTypes(AbilitySource abilitySource) {this.abilitySource = abilitySource;}
	public AbilitySource getAbilitySuperTypes(){return this.abilitySource;}
	
	public void setSourceUnit(Unit sourceUnit) {this.sourceUnit = sourceUnit;}
	public Unit getSourceUnit() {return this.sourceUnit;}
	
	public void setPhases(List<Phase> phases) {this.usableInPhases = phases;}
	public List<Phase> getPhases(){return this.usableInPhases;}
	
	public void setBattleRounds(List<Integer> battleRounds) {this.usableInBattleRounds = battleRounds;}
	public List<Integer> getBattleRounds(){return this.usableInBattleRounds;}
	
	public void setAbilityScope(AbilityScope abilityScope) {this.abilityScope = abilityScope;}
	public AbilityScope getAbilityScope() {return this.abilityScope;}
	
	public void setEffect(String effect) {this.effect = effect;}
	public String getEffect() {return this.effect;}
}
