/*
* Date: 2021-09-21.
* File Name: Mage.Java
* Author: Emelie 흒lund
*
*/

package ea224qb_assign2.excercise1;

import java.util.ArrayList;

/**
* Class Description: This class adds and returns spells of the Mage character
* 
* @version 1.0 Sept 21
* @author Emelie 흒lund
*/
public class Mage extends Character {
	private ArrayList<Spell> spellList; 

	public Mage(String n, CharacterClassType c, int l, int s, int a, int i, int w) {
		super(n, c, l, s, a, i, w);
		spellList = new ArrayList<Spell>();
	}
	
	/**
	* Method Description: This method adds number of spells if it exists (ALTERATION or EVOCATION) onto an ArrayList.
	*
	* @author Emelie 흒lund
	*/
	public void learnSpell(Spell s) {
		if (s.getSchool() == SpellType.ALTERATION || s.getSchool() == SpellType.EVOCATION ) {
			spellList.add(s);
		}
	}
	
	/**
	* Method Description: This method returns the ArrayList holding number of spells.
	*
	* @author Emelie 흒lund
	* @return ArrayList of spells
	*/
	public ArrayList<Spell> getKnownSpells() {
		return spellList;
	}

}
