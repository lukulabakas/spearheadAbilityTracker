package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.ArrayList;
import java.util.List;

//represents the dynamic data of an army that is currently active in a game
public class ArmyState {
	
	private int id;
	private String armyName;
	private String playerName;
	private Army army;
	private List<Unit> units;
	private Ability enhancement;
	private Ability regimentAbility;
	private List<Ability> battleTraits;
	
	public String getArmyName() {return armyName;}
	public void setArmyName(String armyName) {this.armyName = armyName;}
	
	public String getPlayerName() {return playerName;}
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	
	public Army getArmy() {return army;}
	public void setArmy(Army army) {this.army = army;}
	
	public List<Unit> getUnits() {return units;}
	public void setUnits(List<Unit> units) {this.units = units;}
	
	public Ability getEnhancement() {return enhancement;}
	public void setEnhancement(Ability enhancement) {this.enhancement = enhancement;}
	
	public Ability getRegimentAbility() {return regimentAbility;}
	public void setRegimentAbility(Ability regimentAbility) {this.regimentAbility = regimentAbility;}
	
	public List<Ability> getBattleTraits() {return battleTraits;}
	public void setBattleTraits(List<Ability> battleTraits) {this.battleTraits = battleTraits;}
	
	public int getId() {return id;}



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
