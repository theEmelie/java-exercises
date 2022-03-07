/*
* Date: 2021-09-21.
* File Name: Attributes.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise1;

/**
* Class Description: This class gets four attributes
* 
* @version 1.0 Sept 21
* @author Emelie Åslund
*/
public class Attributes {
	int intelligance;
	int strength;
	int wisdom;
	int agility;
	
	public Attributes(int s, int a, int i, int w) {
		strength = s;
		agility = a;
		intelligance = i;
		wisdom = w;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getAgility() {
		return agility;
	}
	
	public int getIntelligence() {
		return intelligance;
	}
	
	public int getWisdom() {
		return wisdom;
	}
}
