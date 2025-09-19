package com.lukulabakas.spearheadAbilityTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lukulabakas.spearheadAbilityTracker.persistence.AbilityRepository;
import com.lukulabakas.spearheadAbilityTracker.service.AbilityService;

@RestController
@RequestMapping("/api/abilities")
public class AbilityController {

	@Autowired
	AbilityService abilityService;
	@Autowired
	AbilityRepository abilityRepo;
	

	
}
