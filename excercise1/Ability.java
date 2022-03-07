/*
* Date: 2021-09-21.
* File Name: Ability.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise1;

/**
* Class Description: This class gets name and ability type for the proficiency
* 
* @version 1.0 Sept 21
* @author Emelie Åslund
*/
public class Ability {
	private String name;
	private ProficiencyType prof;
	
	public Ability(String n, ProficiencyType p) {
		name = n;
		prof = p;
	}
	
	public String getName() {
		return name;
	}
	
	public ProficiencyType getProficiency() {
		return prof;
	}
}

/**
* Enum Description: ProficiencyTypes that can be used
*
* @author Emelie Åslund
*/
enum ProficiencyType {
	ATHLETICS,
	SURVIVAL,
	ACROBATICS,
	STEALTH
}