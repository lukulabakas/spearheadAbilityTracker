package com.lukulabakas.spearheadAbilityTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.persistence.AbilityRepository;

@Service
public class AbilityService {

	@Autowired
	private AbilityRepository abilityRepo;
	
	//Basic CRUD
	//addAbility, deleteAbility will not be relevant as for now
	public Ability getAbility(String name) {
		Ability ability = new Ability();
		return ability;
	}
}
