package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

public class Ability {

	private String name;
	private List<AbilityType> abilityType;
	//determines where the ability comes from (unit, battle trait etc.)
	private List<AbilitySuperType> abilitySuperType;
	//determines when the ability can be used
	private List<Phase> phase;
	private String effect;
	//if the number of uses is limited the attribute "uses" detmerines the amount 
	//"limitedUses" is always to be checked before using "uses"
	private boolean limitedUses;
	private int uses;
	
}
