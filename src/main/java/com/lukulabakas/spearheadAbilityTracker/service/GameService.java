package com.lukulabakas.spearheadAbilityTracker.service;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lukulabakas.spearheadAbilityTracker.dto.TurnResponse;
import com.lukulabakas.spearheadAbilityTracker.exception.GameNotFoundException;
import com.lukulabakas.spearheadAbilityTracker.exception.TeamNotFoundException;
import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.model.ArmyState;
import com.lukulabakas.spearheadAbilityTracker.model.Game;
import com.lukulabakas.spearheadAbilityTracker.model.Phase;
import com.lukulabakas.spearheadAbilityTracker.model.Team;
import com.lukulabakas.spearheadAbilityTracker.model.Unit;


@Service
public class GameService {
	
	@Autowired
	AbilityService abilityService;

	//HashMap of all currently active games
	private Map<Integer, Game> games = new HashMap<>();
	//counter for game ids; for current in memory saving it just always starts at 1 again
	private int nextId = 1;
	//variables to track game state
	boolean lastPhase;
	boolean lastTurn;
	boolean lastBattleRound;
	boolean newTurn;
	boolean newBattleRound;
	boolean gameEnd;
	//cycle of every team having a turn is a battle round. A game consists of 4 battle rounds
	int maxBattleRounds = 4;
	//a turn consists of 7 phases
	List<Phase> phases = List.of(Phase.StartOfTurn, Phase.HeroPhase, Phase.MovementPhase, Phase.ShootingPhase, Phase.ChargePhase, Phase.CombatPhase, Phase.EndOfTurn);

	public int createNewGame(){
		int currentId = nextId;
		nextId++;
		Game game = new Game(currentId);
		games.put(currentId, game);
		return currentId;
	}
	public Game getGameById(int gameId) throws GameNotFoundException{
		Game game = games.get(gameId);
		if(game != null) {
			return game;
		}else {
			throw new GameNotFoundException("Game not found");
		}
	}
	//initialization of variables then trigger next phase by advancePhase() method
	//advancePhase(), advanceTurn() and advanceBattleRound() identify which has to be 
	public TurnResponse finishPhase(int gameId) {
		Game game = games.get(gameId);
		//Variables to keep track of turn progression
		int newActiveTeamIndex = game.getTeams().indexOf(game.getActiveTeam());
		lastPhase = false;
		lastTurn = false;
		lastBattleRound = false;
		newTurn = false;
		newBattleRound = false;
		gameEnd = false;
		//call method to advance the phase, if the end of a turn is reached, advanceTurn is called, same for advanceBattleRound
		advancePhase(game);
		//return the current turn progression
		return new TurnResponse(
				game.getCurrentBattleRound(),
				newActiveTeamIndex,
				lastTurn,
				newBattleRound,
				game.getCurrentPhase(),
				gameEnd
		);
	}
	public void advancePhase(Game game) {
		game.setCurrentPhase(phases.get(phases.indexOf(game.getCurrentPhase()) + 1 % 7));
		if(game.getCurrentPhase() == phases.get(0)) {
			newTurn = true;
			advanceTurn(game);
		}else if(game.getCurrentPhase() == phases.get(6)) {
			lastPhase = true;
		}
	}
	public void advanceTurn(Game game) {
		//index of the team that turn it was previously
		int oldTeamIndex = game.getTeams().indexOf(game.getActiveTeam());
		int newTeamIndex = (oldTeamIndex + 1) % game.getTeams().size();
		//game.setActiveTeam(game.getTeams().get(game.getTeams().indexOf(game.getActiveTeam()) + 1 % game.getTeams().size()));
		if(newTeamIndex == 0) {
			newBattleRound = true;
			advanceBattleRound(game);
		}else if(newTeamIndex == game.getTeams().size()-1) {
			lastTurn = true;
		}
	}
	public void advanceBattleRound(Game game) {
		if(game.getCurrentBattleRound() == 4) {
			gameEnd = true;
		}else {
			game.setCurrentBattleRound(game.getCurrentBattleRound() + 1);
			if(game.getCurrentBattleRound() == 4) {
				lastBattleRound = true;
			}
		}
	}
	//after each battleround the turn order may change
	//this order sets the turn order of the game with gameId to newTurnOrderTeamIds
	public void updateTurnOrder(int gameId, List<Integer> newTurnOrderTeamIds) {
		Game game = getGameById(gameId);
		List<Team> newTurnOrder = new ArrayList<>();
		for(int id : newTurnOrderTeamIds) {
			newTurnOrder.add(findTeamById(gameId, id));
		}
		game.setTeams(newTurnOrder);
		game.setActiveTeam(game.getTeams().get(0));
	}
	public Team findTeamById(int gameId, int teamId) {
		Game game = getGameById(gameId);
		for(Team team : game.getTeams()) {
			if(team.getId() == teamId) {
				return team;
			}
		}
		throw new TeamNotFoundException("Team not found");
	}
	//returns all abilities that are currently usable by the active Team in the game with gameId
	public List<Ability> getActiveTeamAbilities(int gameId){
		Game game = games.get(gameId);
		List<Ability> activeTeamAbilities = new ArrayList<>();
		for(ArmyState army : game.getActiveTeam().getArmies()) {
			activeTeamAbilities.addAll(army.getAllAbilities());	
			}
		return activeTeamAbilities;
	}
	//returns all abilities that are currently usable by all the inactive teams in the game with gameId
	public List<Ability> getInactiveTeamAbilities(int gameId){
		Game game = games.get(gameId);
		List<Ability> inActiveTeamAbilities = new ArrayList<>();
		List<Team> inactiveTeams = game.getTeams();
		inactiveTeams.remove(game.getActiveTeam());
		for(Team team : inactiveTeams) {
			for(ArmyState army : team.getArmies()) {
				inActiveTeamAbilities.addAll(army.getAllAbilities());
			}
		}
		return inActiveTeamAbilities;
	}
}
