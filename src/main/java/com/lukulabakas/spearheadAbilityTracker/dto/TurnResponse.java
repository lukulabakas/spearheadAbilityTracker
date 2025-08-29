package com.lukulabakas.spearheadAbilityTracker.dto;

import com.lukulabakas.spearheadAbilityTracker.model.Phase;

public class TurnResponse {

	private int currentTurn;
	private int activeTeam;
	private boolean lastTurn;
	private boolean newBattleRound;
	private Phase currentPhase;
	private boolean gameEnd;
	
	public TurnResponse(int currentTurn, int activeTeam, boolean lastTurn, boolean newBattleRound, Phase currentPhase, boolean gameEnd) {
		this.currentTurn = currentTurn;
		this.activeTeam = activeTeam;
		this.lastTurn = lastTurn;
		this.newBattleRound = newBattleRound;
		this.currentPhase = currentPhase;
		this.gameEnd = gameEnd;
	}
	
	public int getCurrentTurn() {return this.currentTurn;}
	public void setCurrentTurn(int currentTurn) {this.currentTurn = currentTurn;}
	
	public int getActiveTeam() {return this.activeTeam;}
	public void setActiveTeam(int activeTeam) {this.activeTeam = activeTeam;}
	
	public boolean getLastTurn() {return this.lastTurn;}
	public void setLastTurn(boolean lastTurn) {this.lastTurn = lastTurn;}
	
	public boolean getNewBattleRound() {return this.newBattleRound;}
	public void setNewBattleRound(boolean newBattleRound) {this.newBattleRound = newBattleRound;}
	
	public Phase getCurrentPhase() {return this.currentPhase;}
	public void setCurrentPhase(Phase currentPhase) {this.currentPhase = currentPhase;}
	
	public boolean getGameEnd() {return this.gameEnd;}
	public void setGameEnd(boolean gameEnd) {this.gameEnd = gameEnd;}
}
