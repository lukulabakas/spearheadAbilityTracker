package com.lukulabakas.spearheadAbilityTracker.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukulabakas.spearheadAbilityTracker.dto.TurnResponse;
import com.lukulabakas.spearheadAbilityTracker.exception.GameNotFoundException;
import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.model.Game;
import com.lukulabakas.spearheadAbilityTracker.model.Phase;

@Service
public class GameService {
	
	@Autowired
	AbilityService abilityService;

	//HashMap of all currently active games
	private Map<Integer, Game> games = new HashMap<>();
	//counter for game ids; for current in memory saving it just always starts at 1 again
	private int nextId = 1;
	
	public int createNewGame(){
		int currentId = nextId;
		nextId++;
		Game game = new Game(currentId);
		games.put(currentId, game);
		return currentId;
	}
	public Game getGameById(int gameId) {
		return games.get(gameId);
	}
	//advance turn
	//return a TurnResponse with the new battleRound, activeTeam and a boolean to indicate if its the last Turn
	public TurnResponse nextTurn(int gameId) throws GameNotFoundException{
		Game game = games.get(gameId);
		if(game == null) {
			throw new GameNotFoundException("Game not found");
		}
		//cycle of every team having a turn is a battle round. A game consists of 4 battle rounds
		int maxBattleRounds = 4;
		//in each battle round each team gets a turn, so this is the amount of turns that have to be considered
		int numberOfTeams = game.getTeams().size();
		//++ the team turns, then check if each team already had a turn this battleround
		int nextActiveTeam = (game.getActiveTeam() + 1) % numberOfTeams;
		if(nextActiveTeam == 0) {
			//if each team had a turn this battle round ++ the battleround
			game.setBattleRound(game.getBattleRound() + 1);
		}
		game.setActiveTeam(nextActiveTeam);
		//if after proceeding to the next turn we would be in the last turn of the last battle round, this is saved into the lastTurn variable
		boolean lastTurn = (game.getBattleRound() == maxBattleRounds) && (nextActiveTeam == (numberOfTeams - 1));
		boolean newBattleRound = game.getActiveTeam() == 0;
		//return is current battle round, current activeTeam (or turn) and the info whether this turn will be the last of the game
		return new TurnResponse(
				game.getBattleRound(),
				game.getActiveTeam(),
				lastTurn,
				newBattleRound
		);
	}
	//returns all active abilities in the current turn of the current battleround
	public List<Ability> listActiveAbilitiesByBattleRoundByTeam(int gameId, int battleRound, int activeTeam, Phase currentPhase){
		Game game = getGameById(gameId);
		List<Ability> abilities = new ArrayList<>();
		for(int i = 0; game.getTeams().get(activeTeam).get(i) != null; i++) {
			abilities.addAll(game.getTeams().get(activeTeam).get(i).getAllAbilities());
		}
		return abilityService.filterActiveAbilities(abilities,battleRound, currentPhase, activeTeam);
	}
	
	public void updateTurnOrder() {
		
	}
}
