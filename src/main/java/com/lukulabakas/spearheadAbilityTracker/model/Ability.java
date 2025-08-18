package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Ability {

	private String name;
	private List<AbilityType> abilityType;
	private List<AbilitySuperType> abilitySuperType;
	private List<Phase> phase;
	private String effect;
	private int uses;
	
	private void useAbility() {};
}
