package com.lukulabakas.spearheadAbilityTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lukulabakas.spearheadAbilityTracker.model.Ability;
import com.lukulabakas.spearheadAbilityTracker.model.Army;
import com.lukulabakas.spearheadAbilityTracker.model.ArmyState;

@Service
public class ArmyService {

	
	//Basic CRUD
	public Army getArmyByName(String name) {
		//TODO load all army info from JSON and save into ArmyState object
		return null;
	}
	public List<Army> getAllArmyNames(){
		//TODO load all army names from JSON
		return null;
	}
	public List<Ability> getAllEnhancementsByArmy(String name){
		//TODO load all enhancement by army from JSON
		return null;
	}
	public List<Ability> getAllRegimentAbilitiesByArmy(String name){
		//TODO load all Regiment Abilities by army from JSON
		return null;
	}
	public List<Ability> getAllBattleTraitsByArmy(String name){
		//TODO load all Battle Traits by army from JSON
		return null;
	}
}
