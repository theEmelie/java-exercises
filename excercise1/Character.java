/*
* Date: 2021-09-21.
* File Name: Character.Java
* Author: Emelie 흒lund
*
*/

package ea224qb_assign2.excercise1;

/**
* Class Description: This class gets a character name, class name, level and attribute.
* 
* @version 1.0 Sept 21
* @author Emelie 흒lund
*/
public class Character {
	private String name;
	private CharacterClassType characterClass;
	private int level;
	private Attributes att;
	
	
	public Character(String n, CharacterClassType c, int l, int s, int a, int i, int w) {
		name = n;
		characterClass = c;
		level = l;
		att = new Attributes(s, a, i, w);
	}
	
	public String getName() {
		return name;
	}
	
	public CharacterClassType getClassName() {
		return characterClass;
	}
	
	public int getLevel() {
		return level;
	}
	
	/**
	* Method Description: This method sets the characters primary attribute value depending on a characters class name.
	*
	* @author Emelie 흒lund
	* @return primary attribute value for each class
	*/
	public int getPrimaryAttribute() {
		int attValue;
		if (characterClass == CharacterClassType.MAGE) {
			attValue = att.getIntelligence();
		} else if (characterClass == CharacterClassType.CLERIC) {
			attValue =  att.getWisdom();
		} else if (characterClass == CharacterClassType.WARRIOR) {
			attValue = att.getStrength();
		} else {
			// CharacterClassType.ROGUE
			attValue = att.getAgility();
		}
		return attValue;
	}
}

/**
* Enum Description: CharacterClassTypes that can be used
*
* @author Emelie 흒lund
*/
enum CharacterClassType {
	MAGE,
	CLERIC,
	WARRIOR,
	ROGUE
}
