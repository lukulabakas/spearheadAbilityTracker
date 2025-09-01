package com.lukulabakas.spearheadAbilityTracker.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukulabakas.spearheadAbilityTracker.dto.TurnResponse;
import com.lukulabakas.spearheadAbilityTracker.exception.GameNotFoundException;
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
	
	@PutMapping("/{id}/nextTurn")
	public ResponseEntity<TurnResponse> nextTurn(@PathVariable int gameId){
		try {
			return ResponseEntity.ok(gameService.finishPhase(gameId));
		}catch (GameNotFoundException e){
			return ResponseEntity.notFound().build();
		}
	}
}
