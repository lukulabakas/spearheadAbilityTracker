package com.lukulabakas.spearheadAbilityTracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.model.AbilityScope;
import com.lukulabakas.spearheadAbilityTracker.model.Game;

@Service
public class AbilityService {

	//filter a list of abilities to only return abilities that can be activated in games current battleRound, currentPhase
	//also include the abilityScope as a parameter for filtering
	public List<Ability> filterActiveAbilities(List<Ability> abilities, Game game, List<AbilityScope> abilityScope){
		return abilities.stream()
				.filter(a -> a.getBattleRounds().contains(game.getCurrentBattleRound()))
				.filter(a -> a.getPhases().contains(game.getCurrentPhase()))
				.filter(a -> abilityScope.contains(a.getAbilityScope()))
				.collect(Collectors.toList());
	}
}
