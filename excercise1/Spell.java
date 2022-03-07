/*
* Date: 2021-09-21.
* File Name: Spell.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise1;

/**
* Class Description: This class gets name and spell type for the school
* 
* @version 1.0 Sept 21
* @author Emelie Åslund
*/
public class Spell {
	private String name;
	private SpellType school;
	
	public Spell(String n, SpellType s) {
		name = n;
		school = s;
	}
	
	public String getName() {
		return name;
	}
	
	public SpellType getSchool() {
		return school;
	}
	
}

/**
* Enum Description: SpellTypes that can be used
*
* @author Emelie Åslund
*/
enum SpellType {
	EVOCATION,
	ALTERATION,
	RESTORATION,
	DIVINATION
}
