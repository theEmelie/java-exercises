/*
* Date: 2021-09-22.
* File Name: Battle.Java
* Author: Emelie 흒lund
*
*/

package ea224qb_assign2.excercise1;

/**
* Class Description: This class makes Character party/character battle one and another, 
* ie, comparing statistics from other classes
* 
* @version 1.0 Sept 22
* @author Emelie 흒lund
*/
public class Battle {
	/**
	* Method Description: This method prints statistics of a party from other methods.
	*
	* @author Emelie 흒lund
	* @param party array of characters
	*/
	public static void printStatistics(Character party[]) {
		int sum = 0;
		int mSpellCount = 0;
		int cSpellCount = 0;
		int spellCount = 0;
		int wAbilityCount = 0;
		int rAbilityCount = 0;
		int abilityCount = 0;
		
		for (int i = 0; i < party.length; i++) {
			sum += party[i].getLevel();
			
			// Count all spells that the Mages know in the party
			if (party[i] instanceof Mage) {
				Mage m = (Mage) party[i];
				mSpellCount += m.getKnownSpells().size();
			}
			
			// Count all spells that the Clerics know in the party
			if (party[i] instanceof Cleric) {
				Cleric c = (Cleric) party[i];
				cSpellCount += c.getKnownSpells().size();
			}
			
			// Count all abilities that the Warriors know in the party
			if (party[i] instanceof Warrior) {
				Warrior w = (Warrior) party[i];
				wAbilityCount += w.getKnownAbilities().size();
			}
			
			// Count all abilities that the Rogues know in the party
			if (party[i] instanceof Rogue) {
				Rogue r = (Rogue) party[i];
				rAbilityCount += r.getKnownAbilities().size();
			}
			
		}
		
		System.out.println("Average level of party: " + (sum / party.length));
		spellCount = mSpellCount + cSpellCount;
		System.out.println("Number of spells: " + spellCount);
		System.out.println("Mage Spells: " + mSpellCount);
		System.out.println("Cleric Spells: " + cSpellCount);
		abilityCount = wAbilityCount + rAbilityCount;
		System.out.println("Number of abilities: " + abilityCount);
		System.out.println("Warrior abilites: " + wAbilityCount);
		System.out.println("Rogue abilites: " + rAbilityCount);
		
	}
	
	/**
	* Method Description: This method compare two Character party with each other (average, length, level and attribute).
	*
	* @author Emelie 흒lund
	* @param party1 array of characters
	* @param party2 array of characters
	* @return enum winner or draw
	*/
	public static PartyFightResultType resolve(Character party1[], Character party2[]) {
		int party1Avg;
		int party2Avg;
		int sum = 0;
		int party1PaSum = 0;
		int party2PaSum = 0;
		
		// Party with the most characters win
		if (party1.length > party2.length) {
			return PartyFightResultType.PARTY1_WINS;
		} else if (party1.length < party2.length) {
			return PartyFightResultType.PARTY2_WINS;
		}
		
		// Both parties has the same amount of characters
		for (int i = 0; i < party1.length; i++) {
			sum += party1[i].getLevel();
		}
		
		// Get the average level of party1
		party1Avg = sum / party1.length;
		
		sum = 0;
		
		for (int i = 0; i < party2.length; i++) {
			sum += party2[i].getLevel();
		}
		
		// Get the average level of party1
		party2Avg = sum / party2.length;
		
		// Party with the highest average wins
		if (party1Avg > party2Avg) {
			return PartyFightResultType.PARTY1_WINS;
		} else if (party1Avg < party2Avg) {
			return PartyFightResultType.PARTY2_WINS; 
		}
		
		// Parties are the same size, get total sum of primary attributes for each character in the party
		for (int i = 0; i < party1.length; i++) {
			party1PaSum += party1[i].getPrimaryAttribute();
			party2PaSum += party2[i].getPrimaryAttribute();
		}
		
		// Party with the highest sum of primary attributes win, if same, draw
		if (party1PaSum > party2PaSum) {
			return PartyFightResultType.PARTY1_WINS;
		} else if (party1PaSum < party2PaSum) {
			return PartyFightResultType.PARTY2_WINS; 
		} else {
			return PartyFightResultType.DRAW;
		}
	}
	
	/**
	* Method Description: This method compare two Character character with each other (level, attribute, spells/ability).
	*
	* @author Emelie 흒lund
	* @param character1 a Character (mage, cleric, warrior, rogue)
	* @param character2 a Character (mage, cleric, warrior, rogue)
	* @return enum winner, draw or invalid
	*/
	public static SingleFightResultType singleCombat(Character character1, Character character2) {
		
		// Check that two characters are of the same instance
		if (character1 instanceof Mage && character2 instanceof Mage || 
			character1 instanceof Cleric && character2 instanceof Cleric ||
			character1 instanceof Warrior && character2 instanceof Warrior ||
			character1 instanceof Rogue && character2 instanceof Rogue) {
		
			// Character with highest level wins
			if (character1.getLevel() > character2.getLevel()) {
				return SingleFightResultType.CHARACTER1_WINS;
			} else if (character1.getLevel() < character2.getLevel()) {
				return SingleFightResultType.CHARACTER2_WINS;
			}
			
			// If same level, the one with the highest primary attribute wins
			if (character1.getPrimaryAttribute() > character2.getPrimaryAttribute()) {
				return SingleFightResultType.CHARACTER1_WINS;
			} else if (character1.getPrimaryAttribute() < character2.getPrimaryAttribute()) {
				return SingleFightResultType.CHARACTER2_WINS;
			}
			
			
			// Character 1 and 2 are Mages
			if (character1 instanceof Mage && character2 instanceof Mage) {
				Mage m1 = (Mage) character1;
				Mage m2 = (Mage) character2;
				
				int char1Spell = m1.getKnownSpells().size();
				int char2Spell = m2.getKnownSpells().size();
				
				// Character with most known spells win
				if (char1Spell > char2Spell) {
					return SingleFightResultType.CHARACTER1_WINS;
				} else  if (char1Spell < char2Spell) {
					return SingleFightResultType.CHARACTER2_WINS;
				} else {
					return SingleFightResultType.DRAW;
				}
			}
			
			// Character 1 and 2 are Clerics
			if (character1 instanceof Cleric && character2 instanceof Cleric) {
				Cleric c1 = (Cleric) character1;
				Cleric c2 = (Cleric) character2;
				
				int char1Spell = c1.getKnownSpells().size();
				int char2Spell = c2.getKnownSpells().size();
				
				// Character with most known spells win
				if (char1Spell > char2Spell) {
					return SingleFightResultType.CHARACTER1_WINS;
				} else  if (char1Spell < char2Spell) {
					return SingleFightResultType.CHARACTER2_WINS;
				} else {
					return SingleFightResultType.DRAW;
				}
			}
	
			// Character 1 and 2 are Warriors
			if (character1 instanceof Warrior && character2 instanceof Warrior) {
				Warrior w1 = (Warrior) character1;
				Warrior w2 = (Warrior) character2;
				
				int char1Ability = w1.getKnownAbilities().size();
				int char2Ability = w2.getKnownAbilities().size();
				
				// Character with most known abilities win
				if (char1Ability > char2Ability) {
					return SingleFightResultType.CHARACTER1_WINS;
				} else  if (char1Ability < char2Ability) {
					return SingleFightResultType.CHARACTER2_WINS;
				} else {
					return SingleFightResultType.DRAW;
				}
			}
			
			// Character 1 and 2 are Rogues
			if (character1 instanceof Rogue && character2 instanceof Rogue) {
				Rogue r1 = (Rogue) character1;
				Rogue r2 = (Rogue) character2;
				
				int char1Ability = r1.getKnownAbilities().size();
				int char2Ability = r2.getKnownAbilities().size();
				
				// Character with most known abilities win
				if (char1Ability > char2Ability) {
					return SingleFightResultType.CHARACTER1_WINS;
				} else  if (char1Ability < char2Ability) {
					return SingleFightResultType.CHARACTER2_WINS;
				} else {
					return SingleFightResultType.DRAW;
				}
			}
		}
		// If two characters meet that are different characters, it is an invalid fight
		return SingleFightResultType.INVALID_FIGHT;
	}
	
	/**
	* Class Description: This is a main class that creates new characters and tries out different methods.
	* 
	* @author Emelie 흒lund
	*/
	public static void main(String[] args) {
		Character[] party1 = new Character[4];
		party1[0] = new Mage("Gandalf", CharacterClassType.MAGE, 12, 5, 6, 15, 12);
		party1[1] = new Cleric("Father Ted", CharacterClassType.CLERIC, 13, 6, 7, 10, 17);
		party1[2] = new Warrior("Conan", CharacterClassType.WARRIOR, 8, 17, 12, 5, 4);
		party1[3] = new Rogue("Clyde", CharacterClassType.ROGUE, 15, 7, 17, 12, 3);
		
		Character[] party2 = new Character[4];
		party2[0] = new Mage("Harry", CharacterClassType.MAGE, 12, 5, 6, 15, 12);
		party2[1] = new Cleric("Father Martin", CharacterClassType.CLERIC, 13, 6, 7, 10, 17);
		party2[2] = new Warrior("Spartacus", CharacterClassType.WARRIOR, 8, 17, 15, 5, 4);
		party2[3] = new Rogue("Bonnie", CharacterClassType.ROGUE, 15, 7, 17, 12, 3);
		
		Character[] party3 = new Character[3];
		party3[0] = new Mage("Harry", CharacterClassType.MAGE, 12, 5, 6, 15, 12);
		party3[1] = new Cleric("Father Martin", CharacterClassType.CLERIC, 9, 6, 7, 10, 17);
		party3[2] = new Warrior("Spartacus", CharacterClassType.WARRIOR, 8, 18, 12, 5, 4);
		
		Character character1 = new Mage("Harry", CharacterClassType.MAGE, 12, 5, 6, 16, 12);
		Character character2 = new Mage("Gandalf", CharacterClassType.MAGE, 12, 5, 6, 15, 12);
		
		Character character3 = new Cleric("Father Martin", CharacterClassType.CLERIC, 13, 6, 7, 10, 19);
		Character character4 = new Cleric("Father Ted", CharacterClassType.CLERIC, 13, 6, 7, 10, 20);
		
		Character character5 = new Warrior("Spartacus", CharacterClassType.WARRIOR, 8, 18, 12, 5, 4);
		Character character6 = new Warrior("Conan", CharacterClassType.WARRIOR, 10, 17, 12, 5, 4);
		
		Character character7 = new Rogue("Clyde", CharacterClassType.ROGUE, 17, 7, 17, 12, 3);
		Character character8 = new Rogue("Bonnie", CharacterClassType.ROGUE, 15, 7, 17, 12, 3);
							
		((Mage) party1[0]).learnSpell(new Spell("Fireball", SpellType.EVOCATION));
		((Mage) party1[0]).learnSpell(new Spell("Invisibility", SpellType.ALTERATION));
		((Mage) party1[0]).learnSpell(new Spell("Lightning", SpellType.EVOCATION));
		
		((Cleric) party1[1]).learnSpell(new Spell("Heal", SpellType.RESTORATION));
		((Cleric) party1[1]).learnSpell(new Spell("Find Water", SpellType.DIVINATION));
		
		((Warrior) party1[2]).learnAbility(new Ability("Sprint", ProficiencyType.ATHLETICS));
		((Warrior) party1[2]).learnAbility(new Ability("Build Campsite", ProficiencyType.SURVIVAL));
		
		((Rogue) party1[3]).learnAbility(new Ability("Sneak", ProficiencyType.STEALTH));
		((Rogue) party1[3]).learnAbility(new Ability("Pickpocket", ProficiencyType.STEALTH));
		((Rogue) party1[3]).learnAbility(new Ability("Climb Wall", ProficiencyType.ACROBATICS));
		
		printStatistics(party1);
		System.out.println(resolve(party1, party2));
		System.out.println(resolve(party3, party2));
		
		System.out.println(singleCombat(character1, character2));
		System.out.println(singleCombat(character3, character4));
		System.out.println(singleCombat(character5, character6));
		System.out.println(singleCombat(character7, character8));
		System.out.println(singleCombat(character1, character8));
		
	}
}

enum PartyFightResultType {
	PARTY1_WINS,
	PARTY2_WINS,
	DRAW
}

enum SingleFightResultType {
	CHARACTER1_WINS,
	CHARACTER2_WINS,
	DRAW,
	INVALID_FIGHT
}

