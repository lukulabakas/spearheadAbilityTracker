package com.lukulabakas.spearheadAbilityTracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.model.Phase;

@Service
public class AbilityService {

	
	//Basic CRUD
	//addAbility, deleteAbility will not be relevant as for now
	public Ability getAbility(String name) {
		Ability ability = new Ability();
		return ability;
	}
	public List<Ability> filterActiveAbilities(List<Ability> abilities, int battleRound, Phase currentPhase, boolean activeTeam){
		return abilities.stream()
				.filter(a -> a.getBattleRounds().contains(battleRound))
				.filter(a -> a.getPhases().contains(currentPhase))
				.collect(Collectors.toList());
	}
}
