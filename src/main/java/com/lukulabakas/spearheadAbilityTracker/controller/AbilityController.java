package com.lukulabakas.spearheadAbilityTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.persistence.AbilityRepository;
import com.lukulabakas.spearheadAbilityTracker.service.AbilityService;

@RestController
@RequestMapping("/api/abilities")
public class AbilityController {

	@Autowired
	AbilityService abilityService;
	@Autowired
	AbilityRepository abilityRepo;
	
	//Basic CRUD
	//addAbility, deleteAbility will not be relevant as for now
	@GetMapping("/{name]")
	public ResponseEntity<Ability> getAbilityByName(@PathVariable String name){
		Ability ability = abilityService.getAbility(name);
		return new ResponseEntity<>(ability, HttpStatus.OK);
	}
	
}
