package com.lukulabakas.spearheadAbilityTracker.service;


import java.util.Map;


import com.lukulabakas.spearheadAbilityTracker.model.Game;

public class GameService {

	//list of all currently active games
	private Map<Integer, Game> games;
	//counter for game ids; for current in memory saving it just always starts at 1 again
	private int nextId = 1;
	
	public int createNewGame(){
		int currentId = nextId;
		nextId++;
		Game game = new Game(currentId);
		games.put(currentId, game);
		return currentId;
	}
}
