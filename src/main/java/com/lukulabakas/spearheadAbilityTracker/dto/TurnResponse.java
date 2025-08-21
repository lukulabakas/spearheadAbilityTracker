package com.lukulabakas.spearheadAbilityTracker.dto;

public class TurnResponse {

	private int currentTurn;
	private int activeTeam;
	private boolean lastTurn;
	
	public TurnResponse(int currentTurn, int activeTeam, boolean lastTurn) {
		this.currentTurn = currentTurn;
		this.activeTeam = activeTeam;
		this.lastTurn = lastTurn;
	}
	
	public int getCurrentTurn() {return this.currentTurn;}
	public void setCurrentTurn(int currentTurn) {this.currentTurn = currentTurn;}
	
	public int getActiveTeam() {return this.activeTeam;}
	public void setActiveTeam(int activeTeam) {this.activeTeam = activeTeam;}
	
	public boolean getLastTurn() {return this.lastTurn;}
	public void setLastTurn(boolean lastTurn) {this.lastTurn = lastTurn;}
}
