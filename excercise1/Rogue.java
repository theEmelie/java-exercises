/*
* Date: 2021-09-21.
* File Name: Rogue.Java
* Author: Emelie 흒lund
*
*/

package ea224qb_assign2.excercise1;

import java.util.ArrayList;

/**
* Class Description: This class adds and returns abilities of the Rogue character
* 
* @version 1.0 Sept 21
* @author Emelie 흒lund
*/
public class Rogue extends Character {
	private ArrayList<Ability> abilityList; 

	public Rogue(String n, CharacterClassType c, int l, int s, int a, int i, int w) {
		super(n, c, l, s, a, i, w);
		abilityList = new ArrayList<Ability>();
	}
	
	/**
	* Method Description: This method adds number of abilities if it exists (ACROBATICS or STEALTH) onto an ArrayList.
	*
	* @author Emelie 흒lund
	*/
	public void learnAbility(Ability a) {
		if (a.getProficiency() == ProficiencyType.ACROBATICS || a.getProficiency() == ProficiencyType.STEALTH ) {
			abilityList.add(a);
		}
	}
	
	/**
	* Method Description: This method returns the ArrayList holding number of abilities.
	*
	* @author Emelie 흒lund
	* @return ArrayList of abilities
	*/
	public ArrayList<Ability> getKnownAbilities() {
		return abilityList;
	}
}