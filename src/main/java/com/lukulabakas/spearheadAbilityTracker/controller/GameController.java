package com.lukulabakas.spearheadAbilityTracker.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukulabakas.spearheadAbilityTracker.dto.TeamPoints;
import com.lukulabakas.spearheadAbilityTracker.dto.TurnResponse;
import com.lukulabakas.spearheadAbilityTracker.exception.GameNotFoundException;
import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.service.GameService;

@RestController
@RequestMapping("/api/games")
public class GameController {
	
	@Autowired
	GameService gameService;

	@PostMapping("/create")
	public ResponseEntity<Integer> createNewGame(){
		int id = gameService.createNewGame();
		return ResponseEntity.created(URI.create("/games/" + id)).body(id);
	}
	
	@PutMapping("/{id}/finishPhase")
	public ResponseEntity<TurnResponse> finishPhase(@PathVariable int gameId){
		try {
			return ResponseEntity.ok(gameService.finishPhase(gameId));
		}catch (GameNotFoundException e){
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/{id}/updateTurnOrder")
	public ResponseEntity<Void> updateTurnOrder(@PathVariable int gameiD, @RequestBody List<Integer> newTurnOrderTeamIds){
		gameService.updateTurnOrder(gameiD, newTurnOrderTeamIds);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/{id}/getActiveTeamAbilities")
	public ResponseEntity<List<Ability>> getActiveTeamAbilities(@PathVariable int gameId){
		List<Ability> activeTeamAbilities = gameService.getActiveTeamAbilities(gameId);
		return ResponseEntity.ok(activeTeamAbilities);
	}
	@GetMapping("/{id}/getInactiveTeamAbilities")
	public ResponseEntity<List<Ability>> getInactiveTeamAbilities(@PathVariable int gameId){
		List<Ability> inactiveTeamAbilities = gameService.getInactiveTeamAbilities(gameId);
		return ResponseEntity.ok(inactiveTeamAbilities);
	}
	@PutMapping("/{id}/addActiveTeamPoints")
	public ResponseEntity<Integer> addActiveTeamPoints(@PathVariable int gameId, @RequestBody int points){
		return ResponseEntity.ok(gameService.addActiveTeamPoints(gameId, points));
	}
	@GetMapping("/{id}/getCurrentPoints")
	public ResponseEntity<List<TeamPoints>> getCurrentPoints(@PathVariable int gameId){
		return ResponseEntity.ok(gameService.getCurrentPoints(gameId));
	}
}
