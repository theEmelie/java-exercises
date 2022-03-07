/*
* Date: 2021-09-21.
* File Name: Cleric.Java
* Author: Emelie 흒lund
*
*/

package ea224qb_assign2.excercise1;

import java.util.ArrayList;

/**
* Class Description: This class adds and returns spells of the Cleric character
* 
* @version 1.0 Sept 21
* @author Emelie 흒lund
*/
public class Cleric extends Character {
	private ArrayList<Spell> spellList; 

	public Cleric(String n, CharacterClassType c, int l, int s, int a, int i, int w) {
		super(n, c, l, s, a, i, w);
		spellList = new ArrayList<Spell>();
	}
	
	/**
	* Method Description: This method adds number of spells if it exists (RESTORATION or DIVINATION) onto an ArrayList.
	*
	* @author Emelie 흒lund
	*/
	public void learnSpell(Spell s) {
		if (s.getSchool() == SpellType.RESTORATION || s.getSchool() == SpellType.DIVINATION ) {
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
