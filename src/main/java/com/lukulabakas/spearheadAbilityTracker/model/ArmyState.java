package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.ArrayList;
import java.util.List;

//represents the dynamic data of an army that is currently active in a game
public class ArmyState {
	
	//id in case 2 players choose the same army and name is not a unique identifier anymore
	private int id;
	private String name;
	//reference to the static army info 
	private Army army;
	private String playerName;
	private List<Unit> units;
	private Ability enhancement;
	private Ability regimentAbility;
	private List<Ability> battleTraits;
	
	public int getId() {return this.id;}
	
	public void setEnhancement(Ability enhancement) {this.enhancement = enhancement;}
	public Ability getEnhancement(){return this.enhancement;}
	
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	public String getPlayerName() {return this.playerName;}
	
	public void setUnits(List<Unit> units) {this.units = units;}
	public List<Unit> getUnits(){return this.units;}
	
	public void setRegimentAbility(Ability regimentAbility) {this.regimentAbility = regimentAbility;}
	public Ability getRegimentAbility() {return this.regimentAbility;}
	
	public String getName() {return this.name;}
	
	public List<Ability> getBattleTraits(){return this.battleTraits;}
	public void setBattleTraits(List<Ability> battleTraits) {this.battleTraits = battleTraits;}
	
	public Army getArmy() {return this.army;}
	public void setArmy(Army army) {this.army = army;}
	
	public List<Ability> getAllAbilities(){
		List<Ability> allAbilities = new ArrayList<>();
		allAbilities.add(this.enhancement);
		allAbilities.add(this.regimentAbility);
		allAbilities.addAll(battleTraits);
		for(Unit unit : this.units) {
			allAbilities.addAll(unit.getAbilities());
		}
		return allAbilities;
	}
}
