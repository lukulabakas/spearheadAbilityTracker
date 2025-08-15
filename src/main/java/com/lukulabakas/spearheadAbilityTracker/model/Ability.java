package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.Set;

public class Ability {

	private String name;
	private Set<AbilityType> abilityType;
	private Set<AbilitySuperType> abilitySuperType;
	private Set<Phase> phase;
	private String effect;
	
	private void useAbility() {};
}
