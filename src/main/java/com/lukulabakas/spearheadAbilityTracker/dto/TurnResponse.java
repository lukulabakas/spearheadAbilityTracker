package com.lukulabakas.spearheadAbilityTracker.dto;

import com.lukulabakas.spearheadAbilityTracker.model.Phase;

public record TurnResponse(int currentTurn, int activeTeam, boolean lastTurn, boolean newBattleRound, Phase currentPhase, boolean gameEnd) {
	
}