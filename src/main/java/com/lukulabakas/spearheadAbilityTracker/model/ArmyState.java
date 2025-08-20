package com.lukulabakas.spearheadAbilityTracker.model;

import java.util.List;

//represents the dynamic data of an army that is currently active in a game
public class ArmyState {
	
	private String name;
	private String playerName;
	private List<Unit> units;
	private Ability enhancement;
	private Ability regimentAbility;
	private List<Ability> battleTraits;
	private boolean activeTurn;
	
	
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
	
	public boolean getActiveTurn() {return this.activeTurn;}
	public void setActiveTurn(boolean activeTurn) {this.activeTurn = activeTurn;}
}
