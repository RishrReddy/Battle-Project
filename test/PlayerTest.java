import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import BattleProject.Axe;
import BattleProject.BattlePlayers;
import BattleProject.Belt;
import BattleProject.Footwear;
import BattleProject.Gear;
import BattleProject.HeadGear;
import BattleProject.Player;
import BattleProject.Potion;
import BattleProject.RandomNumberGenerateTest;
import BattleProject.RandomNumbersGenerator;
import BattleProject.Weapon;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

  BattlePlayers player1;
  RandomNumbersGenerator r1 = new RandomNumberGenerateTest(2);
  BattlePlayers pForGearList = new Player("xyz", new RandomNumberGenerateTest(3));

  @Before
  public void setup() {
    player1 = new Player("Player1", r1);
  }

  /**
   * Unit test for checking if player name Null throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constructorTestNullName() {
    new Player(null, r1);
  }

  /**
   * Unit test for checking if player name is empty, throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constructorTestEmptyName() {
    new Player("", r1);
  }

  /**
   * Unit test for checking if randomVariable null, throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void constructorTestNullRandomVariable() {
    new Player("PLayer1", null);
  }

  /**
   * Unit test for checking if getPlayerName returns accurate playerName
   */
  @Test
  public void getPlayerNameTest() {
    assertEquals("Player1", player1.getPlayerName());
  }

  /**
   * Unit test for checking if getPlayerConstitution returns accurate constitution value
   * when random integer is 2/3/4
   * when 2 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the constitution should be 6
   * when 3 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the constitution should be 9
   * when 4 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the constitution should be 12
   */
  @Test
  public void getPlayerConstitutionTest() {
    assertEquals(6, player1.getPlayerConstitution());
    BattlePlayers p2 = new Player("xyz", new RandomNumberGenerateTest(3));
    assertEquals(9, p2.getPlayerConstitution());
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    assertEquals(12, p3.getPlayerConstitution());
  }

  /**
   * Unit test for checking if getPlayerDexterity() returns accurate dexterity value
   * when random integer is 2/3/4
   * when 2 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the dexterity should be 6
   * when 3 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the dexterity should be 9
   * when 4 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the dexterity should be 12
   */
  @Test
  public void getPlayerDexterityTest() {
    assertEquals(6, player1.getPlayerDexterity());
    BattlePlayers p2 = new Player("xyz", new RandomNumberGenerateTest(3));
    assertEquals(9, p2.getPlayerDexterity());
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    assertEquals(12, p3.getPlayerDexterity());
  }

  /**
   * Unit test for checking if getPlayerHealth() returns accurate health value
   * when random integer is 2/3/4
   * when 2 is passed as the random value to RandomNumberGenerateTest object the
   * constitution = 6, dexterity = 6, strength = 6 , charisma = 6 so health = 24
   * when 3 is passed as the random value to RandomNumberGenerateTest object the
   * constitution = 9, dexterity = 9, strength = 9 , charisma = 9 so health = 36
   * when 4 is passed as the random value to RandomNumberGenerateTest object the
   * constitution = 12, dexterity = 12, strength = 12, charisma = 6 so health = 48
   */
  @Test
  public void getPlayerHealth() {
    assertEquals(24, player1.getPlayerHealth());
    BattlePlayers p2 = new Player("xyz", new RandomNumberGenerateTest(3));
    assertEquals(36, p2.getPlayerHealth());
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    assertEquals(48, p3.getPlayerHealth());
  }

  /**
   * Unit test for checking if getPlayerCharisma() returns accurate Charisma value
   * when random integer is 2/3/4
   * when 2 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the Charisma should be 6
   * when 3 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the Charisma should be 9
   * when 4 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the Charisma should be 12
   */
  @Test
  public void getPlayerCharismaTest() {
    assertEquals(6, player1.getPlayerCharisma());
    BattlePlayers p2 = new Player("xyz", new RandomNumberGenerateTest(3));
    assertEquals(9, p2.getPlayerCharisma());
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    assertEquals(12, p3.getPlayerCharisma());
  }

  /**
   * Unit test for checking if getPlayerStrength() returns accurate Strength value
   * when random integer is 2/3/4
   * when 2 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the Strength should be 6
   * when 3 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the Strength should be 9
   * when 4 is passed as the random value to RandomNumberGenerateTest object the
   * dice roll would give 2,2,2,2 so the Strength should be 12
   */
  @Test
  public void getPlayerStrengthTest() {
    assertEquals(6, player1.getPlayerStrength());
    BattlePlayers p2 = new Player("xyz", new RandomNumberGenerateTest(3));
    assertEquals(9, p2.getPlayerStrength());
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    assertEquals(12, p3.getPlayerStrength());
  }


  /**
   * Unit test for getPlayerAvoidanceAbility() when the battle didnt start and player is not
   * equipped with any gear or weapon. It is initialized to 0.
   */
  @Test
  public void getPlayerAvoidanceAbilityInitiallyWithoutGears() {
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    assertEquals(0, p3.getPlayerAvoidanceAbility());
  }

  /**
   * Unit test for getPlayerAvoidanceAbility() when the battle has started and the player
   * is equipped with gear and weapons. Calling a setBattleAbilities() for setting some
   * random values.
   */
  @Test
  public void getPlayerAvoidanceAbilityAfterSetting() {
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    //Assuming the setBattleAttributes method was called when battle started.
    p3.setBattleAbilities(10, 20);
    assertEquals(20, p3.getPlayerAvoidanceAbility());
  }

  /**
   * Unit test for getPlayerStrikingPower() when the battle has started and the player
   * is equipped with gear and weapons. Calling a setBattleAbilities() for setting some
   * random values.
   */
  @Test
  public void getPlayerStrikingPower() {
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    //Assuming the setBattleAttributes method was called when battle started.
    p3.setBattleAbilities(10, 20);
    assertEquals(10, p3.getPlayerStrikingPower());
  }

  /**
   * Unit test for getPlayerGear() if it returns the list of gears
   * when the player is equipped with gear. Comparing the list to added gears.
   */
  @Test
  public void getPlayerGear() {
    HeadGear headGear = new HeadGear("Headgear", new RandomNumberGenerateTest(4).getRandomNumber(1, 6));
    Footwear footwear = new Footwear("footwear", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    Belt belt = new Belt("Belt", new RandomNumberGenerateTest(3).getRandomNumber(1, 6), new RandomNumberGenerateTest(2).getRandomNumber(1, 3));
    Potion potion = new Potion("footwear", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    List<Gear> gearList = new ArrayList<>();
    gearList.add(headGear);
    gearList.add(footwear);
    gearList.add(belt);
    gearList.add(potion);
    for (Gear g : gearList) {
      pForGearList.updatePlayerGear(g);
    }
    assertEquals(gearList, pForGearList.getPlayerGear());
  }

  /**
   * Unit test for getPlayerGear() if it returns the string of gears name and power
   * when the player is equipped with gear.
   */
  @Test
  public void toStringGear() {
    HeadGear headGear = new HeadGear("Headgear",
            new RandomNumberGenerateTest(4).getRandomNumber(1, 6));
    Footwear footwear = new Footwear("footwear",
            new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    Belt belt = new Belt("Belt",
            new RandomNumberGenerateTest(3).getRandomNumber(1, 6),
            new RandomNumberGenerateTest(2).getRandomNumber(1, 3));
    Potion potion = new Potion("Potion", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    List<Gear> gearList = new ArrayList<>();
    gearList.add(headGear);
    gearList.add(footwear);
    gearList.add(belt);
    gearList.add(potion);
    for (Gear g : gearList) {
      pForGearList.updatePlayerGear(g);
    }
    assertEquals("Gear Name is : Headgear Gear power is : 4\n" +
            "Gear Name is : footwear Gear power is : 3\n" +
            "Gear Name is : Belt Gear power is : 3\n" +
            "Gear Name is : Potion Gear power is : 3\n", pForGearList.toStringGear());
  }

  /**
   * Unit test for setBattleAbilities() when the battle has started and the player
   * is equipped with gear and weapons. Calling a setBattleAbilities() for setting some
   * random values and asserting the values.
   */
  @Test
  public void setBattleAbilities() {
    BattlePlayers p3 = new Player("xyz", new RandomNumberGenerateTest(4));
    //Assuming the setBattleAttributes method was called when battle started.
    p3.setBattleAbilities(10, 20);
    assertEquals(10, p3.getPlayerStrikingPower());
    assertEquals(20, p3.getPlayerAvoidanceAbility());
  }

  /**
   * Unit test for toString() . Calling a setBattleAbilities() for setting some
   * random values and asserting the values.
   */
  @Test
  public void testToString() {
    assertEquals("Player Name is : xyz Constitution: 9 Charisma: 9 Strength: 9 Dexterity: 9 Health: 36 Avoidance Ability: 0 Striking Power: 0", pForGearList.toString());
    pForGearList.setBattleAbilities(10, 20);
    assertEquals("Player Name is : xyz Constitution: 9 Charisma: 9 Strength: 9 Dexterity: 9 Health: 36 Avoidance Ability: 20 Striking Power: 10", pForGearList.toString());
  }

  /**
   * Unit test for toStringBasicAbilities() for checking if it prints the player's name alone with basin 4 abilities.
   */
  @Test
  public void toStringBasicAbilities() {
    assertEquals("Player Name is : xyz Constitution: 9 Charisma: 9 Strength: 9 Dexterity: 9\n", pForGearList.toStringBasicAbilities());
  }

  /**
   * Unit test for updatePlayerGear() for checking if the new gear is added.
   * initially the gear list will be empty, asserted size 0. Then add new gear.
   * assert size of list to be 1. then asserted the name of gear added.
   */
  @Test
  public void updatePlayerGearTest() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    assertEquals(0, p1.getPlayerGear().size());
    Gear h = new HeadGear("Headgear", new RandomNumberGenerateTest(2).getRandomNumber(1, 6));
    p1.updatePlayerGear(h);
    assertEquals(1, p1.getPlayerGear().size());
    assertEquals("Headgear", p1.getPlayerGear().get(0).getGearName());
  }

  /**
   * Unit test for updatePlayerWeapon() for checking if the new weapon is added.
   * initially the weapon list will be empty, asserted size 0. Then add new weapon.
   * assert size of list to be 1. then asserted the name of weapon added.
   */
  @Test
  public void updatePlayerWeaponTest() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    assertEquals(0, p1.getWeapon().size());
    Weapon w = new Axe();
    p1.updatePlayerWeapon(w);
    assertEquals(1, p1.getWeapon().size());
    assertEquals("Axe", p1.getWeapon().get(0).getWeaponName());
  }

  /**
   * Unit test for getWeapon() for checking if the new weapon is added is returned.
   */
  @Test
  public void getWeapon() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    Weapon w = new Axe();
    p1.updatePlayerWeapon(w);
    assertEquals(w, p1.getWeapon().get(0));
  }

  /**
   * Unit test for updatePlayerHealth() to check if the health value is updated correctly
   * is equipped with gear and weapons.After a strike the health of the player is to be updated.
   */
  @Test
  public void updatePlayerHealth() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    p1.updatePlayerHealth(49);
    assertEquals(49, p1.getPlayerHealth());
  }

  @Test
  public void refreshGears() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    HeadGear headGear = new HeadGear("Headgear", new RandomNumberGenerateTest(4).getRandomNumber(1, 6));
    Footwear footwear = new Footwear("footwear", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    Belt belt = new Belt("Belt", new RandomNumberGenerateTest(3).getRandomNumber(1, 6), new RandomNumberGenerateTest(2).getRandomNumber(1, 3));
    Potion potion = new Potion("Potion", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    List<Gear> gearList = new ArrayList<>();
    gearList.add(headGear);
    gearList.add(footwear);
    gearList.add(belt);
    gearList.add(potion);
    for (Gear g : gearList) {
      p1.updatePlayerGear(g);
    }
    assertEquals(4, p1.getPlayerGear().size());
    p1.refreshGears();
    assertEquals(0, p1.getPlayerGear().size());
  }

  @Test
  public void refreshWeapons() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    Weapon w = new Axe();
    p1.updatePlayerWeapon(w);
    assertEquals(1, p1.getWeapon().size());
    p1.refreshWeapons();
    assertEquals(0, p1.getWeapon().size());
  }

  @Test
  public void refreshHealth() {
    assertEquals(24, player1.getPlayerHealth());
    player1.updatePlayerHealth(25);
    assertEquals(25, player1.getPlayerHealth());
  }
}