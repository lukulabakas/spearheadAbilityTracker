package com.lukulabakas.spearheadAbilityTracker.dto;

public class TurnResponse {

	private int currentTurn;
	private int activeTeam;
	private boolean lastTurn;
	private boolean newBattleRound;
	
	public TurnResponse(int currentTurn, int activeTeam, boolean lastTurn, boolean newBattleRound) {
		this.currentTurn = currentTurn;
		this.activeTeam = activeTeam;
		this.lastTurn = lastTurn;
		this.newBattleRound = newBattleRound;
	}
	
	public int getCurrentTurn() {return this.currentTurn;}
	public void setCurrentTurn(int currentTurn) {this.currentTurn = currentTurn;}
	
	public int getActiveTeam() {return this.activeTeam;}
	public void setActiveTeam(int activeTeam) {this.activeTeam = activeTeam;}
	
	public boolean getLastTurn() {return this.lastTurn;}
	public void setLastTurn(boolean lastTurn) {this.lastTurn = lastTurn;}
	
	public boolean getNewBattleRound() {return this.newBattleRound;}
	public void setNewBattleRound(boolean newBattleRound) {this.newBattleRound = newBattleRound;}
}
