package com.lukulabakas.spearheadAbilityTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukulabakas.spearheadAbilityTracker.model.Army;
import com.lukulabakas.spearheadAbilityTracker.service.ArmyService;

@RestController
@RequestMapping("/api/armies")
public class ArmyController {

	@Autowired
	ArmyService armyService;
	
	//Basic CRUD
	@GetMapping("/{name}")
	public ResponseEntity<Army> getArmyByName(@PathVariable String name) {
		return new ResponseEntity<>(armyService.getArmyByName(name), HttpStatus.OK);
	}
	//returns NAMES of all armies
	@GetMapping
	public ResponseEntity<List<Army>> getAllArmieNames(){
		return new ResponseEntity<>(armyService.getAllArmyNames(), HttpStatus.OK);
	}
}
