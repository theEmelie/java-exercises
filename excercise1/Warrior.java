/*
* Date: 2021-09-21.
* File Name: Warrior.Java
* Author: Emelie �slund
*
*/

package ea224qb_assign2.excercise1;

import java.util.ArrayList;

/**
* Class Description: This class adds and returns abilities of the Warrior character
* 
* @version 1.0 Sept 21
* @author Emelie �slund
*/
public class Warrior extends Character {
	private ArrayList<Ability> abilityList; 

	public Warrior(String n, CharacterClassType c, int l, int s, int a, int i, int w) {
		super(n, c, l, s, a, i, w);
		abilityList = new ArrayList<Ability>();
	}
	
	/**
	* Method Description: This method adds number of abilities if it exists (ATHLETICS or SURVIVAL) onto an ArrayList.
	*
	* @author Emelie �slund
	*/
	public void learnAbility(Ability a) {
		if (a.getProficiency() == ProficiencyType.ATHLETICS || a.getProficiency() == ProficiencyType.SURVIVAL ) {
			abilityList.add(a);
		}
	}
	
	/**
	* Method Description: This method returns the ArrayList holding number of abilities.
	*
	* @author Emelie �slund
	* @return ArrayList of abilities
	*/
	public ArrayList<Ability> getKnownAbilities() {
		return abilityList;
	}
}
