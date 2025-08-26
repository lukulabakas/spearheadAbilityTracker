package com.lukulabakas.spearheadAbilityTracker.service;



import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lukulabakas.spearheadAbilityTracker.dto.TurnResponse;
import com.lukulabakas.spearheadAbilityTracker.exception.GameNotFoundException;
import com.lukulabakas.spearheadAbilityTracker.model.Game;


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
		int currentActiveTeamIndex = game.getTeams().indexOf(game.getActiveTeam());
		//++ the active index, then check if each team already had a turn this battleround
		int newActiveTeamIndex = (currentActiveTeamIndex + 1) % numberOfTeams;
		if(newActiveTeamIndex == 0) {
			//if each team had a turn this battle round ++ the battleround
			game.setCurrentBattleRound(game.getCurrentBattleRound() + 1);
		}
		game.setActiveTeam(game.getTeams().get(newActiveTeamIndex));
		//if after proceeding to the next turn we would be in the last turn of the last battle round, this is saved into the lastTurn variable
		boolean lastTurn = (game.getCurrentBattleRound() == maxBattleRounds) && (newActiveTeamIndex == (numberOfTeams - 1));
		boolean newBattleRound = game.getTeams().indexOf(game.getActiveTeam()) == 0;
		//return is current battle round, current activeTeam (or turn) and the info whether this turn will be the last of the game
		return new TurnResponse(
				game.getCurrentBattleRound(),
				newActiveTeamIndex,
				lastTurn,
				newBattleRound
		);
	}
	
	public void updateTurnOrder() {
		
	}
}
