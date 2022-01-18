import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battle.Ability;
import battle.BattleInventory;
import battle.BattlePlayers;
import battle.Belt;
import battle.Footwear;
import battle.Gear;
import battle.GearType;
import battle.HeadGear;
import battle.Player;
import battle.Potion;
import battle.RandomNumberGenerateSource;
import battle.RandomNumberGenerateTest;
import battle.RandomNumbersGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * GearTest class represents all the test cases related ta a Gear object,
 * its subclasses and other methods implemented from the BattleInventory class.
 */
public class GearTest {

  BattleInventory g1;
  Gear g2;
  Gear g3;
  Gear g4;
  Gear g5;

  RandomNumbersGenerator r1 = new RandomNumberGenerateTest(2);

  @Before
  public void setup() {
    g1 = new Gear(r1);
    g2 = new HeadGear("Headgear", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    g3 = new Footwear("footwear",
            new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    g4 = new Belt("Belt",
            new RandomNumberGenerateTest(3).getRandomNumber(1, 6),
            new RandomNumberGenerateTest(2).getRandomNumber(1, 3));
    g5 = new Potion("Potion", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidHeadGear() {
    Gear g = new HeadGear(null, new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidPotion() {
    Gear g = new Potion(null, new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidFootwear() {
    Gear g = new Footwear(null, new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidBelt() {
    Gear g = new Belt(null, new RandomNumberGenerateTest(3).getRandomNumber(1, 6), 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidHeadGearName() {
    Gear g = new HeadGear("", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidPotionName() {
    Gear g = new Potion("", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidFootwearName() {
    new Footwear("", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidBeltName() {
    new Belt("", new RandomNumberGenerateTest(3).getRandomNumber(1, 6), 3);
  }

  @Test
  public void initializeInventory() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    assertEquals(0, p1.getPlayerGear().size());
    assertEquals(0, p2.getPlayerGear().size());
    Gear g = new Gear(new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6,
            7, 8, 9, 11, 12, 13, 23, 14, 21, 22, 24, 16));
    g.initializeInventory(playerList);
    g.assignEquipment(playerList);
    assertTrue(p1.getPlayerGear().size() > 0);
    assertTrue(p2.getPlayerGear().size() > 0);
  }

  @Test
  public void assignEquipment() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    assertEquals(0, p1.getPlayerGear().size());
    assertEquals(0, p2.getPlayerGear().size());
    Gear g = new Gear(new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 11, 12, 13, 23, 14, 21, 22, 24, 16));
    g.initializeInventory(playerList);
    g.assignEquipment(playerList);
    assertTrue(p1.getPlayerGear().size() > 0);
    assertTrue(p2.getPlayerGear().size() > 0);
  }

  @Test
  public void assignEquipmentOnlyZeroOneHeadgear() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    assertEquals(0, p1.getPlayerGear().size());
    assertEquals(0, p2.getPlayerGear().size());
    Gear g = new Gear(new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            11, 12, 13, 23, 14, 21, 22, 24, 16));
    g.initializeInventory(playerList);
    g.assignEquipment(playerList);
    assertTrue(p1.getPlayerGear().size() > 0);
    int count = 0;
    for (Gear gear : p1.getPlayerGear()) {
      if (gear.getType().equals(GearType.HEADGEAR)) {
        count = count + 1;
      }
    }
    assertTrue(count == 0 || count == 1);
    count = 0;
    for (Gear gear : p2.getPlayerGear()) {
      if (gear.getType().equals(GearType.HEADGEAR)) {
        count = count + 1;
      }
    }
    assertTrue(count == 0 || count == 1);
  }

  @Test
  public void assignEquipmentOnlyZeroOneFootwear() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    assertEquals(0, p1.getPlayerGear().size());
    assertEquals(0, p2.getPlayerGear().size());
    Gear g = new Gear(new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 11, 12, 13, 23, 14, 21, 22, 24, 16));
    g.initializeInventory(playerList);
    g.assignEquipment(playerList);
    assertTrue(p1.getPlayerGear().size() > 0);
    int count = 0;
    for (Gear gear : p1.getPlayerGear()) {
      if (gear.getType().equals(GearType.FOOTWEAR)) {
        count = count + 1;
      }
    }
    assertTrue(count == 0 || count == 1);
    count = 0;
    for (Gear gear : p2.getPlayerGear()) {
      if (gear.getType().equals(GearType.FOOTWEAR)) {
        count = count + 1;
      }
    }
    assertTrue(count == 0 || count == 1);
  }

  @Test
  public void assignEquipmentBeltUnits() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    Gear g = new Gear(new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6, 7,
            8, 9, 11, 12, 13, 23, 14, 21, 22, 24, 16));
    g.initializeInventory(playerList);
    g.assignEquipment(playerList);
    int count = 0;
    for (Gear gear : p1.getPlayerGear()) {
      if (gear.getType().equals(GearType.BELT)) {
        Belt b = (Belt) gear;
        count = count + b.getBeltSize();
      }
    }
    assertTrue(count <= 10);
    count = 0;
    for (Gear gear : p2.getPlayerGear()) {
      if (gear.getType().equals(GearType.BELT)) {
        Belt b = (Belt) gear;
        count = count + b.getBeltSize();
      }
    }
    assertTrue(count <= 10);
  }

  @Test
  public void getType() {
    assertEquals(GearType.FOOTWEAR, g3.getType());
    assertEquals(GearType.HEADGEAR, g2.getType());
    assertEquals(GearType.POTION, g5.getType());
    assertEquals(GearType.BELT, g4.getType());
  }

  @Test
  public void getAffectedAbilitiesType() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    assertEquals(0, p1.getPlayerGear().size());
    assertEquals(0, p2.getPlayerGear().size());
    Gear g = new Gear(new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 11, 12, 13, 23, 14, 21, 22, 24, 16));
    g.initializeInventory(playerList);
    g.assignEquipment(playerList);
    for (Gear gear : p1.getPlayerGear()) {
      if (gear.getType().equals(GearType.HEADGEAR)) {
        assertTrue(gear.getAffectedAbilities().size() == 1);
        assertEquals(Ability.CONSTITUTION, gear.getAffectedAbilities().get(0));
      }
      if (gear.getType().equals(GearType.FOOTWEAR)) {
        assertTrue(gear.getAffectedAbilities().size() == 1);
        assertEquals(Ability.DEXTERITY, gear.getAffectedAbilities().get(0));
      }
      if (gear.getType().equals(GearType.BELT)) {
        assertTrue(gear.getAffectedAbilities().size() <= 2);
      }
      if (gear.getType().equals(GearType.POTION)) {
        assertTrue(gear.getAffectedAbilities().size() == 1);
      }
    }
  }


  @Test
  public void getPower() {
    Gear g = new HeadGear("xyz", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    assertEquals(3, g.getPower());
  }

  @Test
  public void getRandomVariable() {
    Gear g = new Gear(new RandomNumberGenerateSource());
    int i;
    i = g.getRandomVariable(1, 6);
    assertTrue(i >= 1 && i <= 6);
    i = g.getRandomVariable(3, 6);
    assertTrue(i >= 3 && i <= 6);
    i = g.getRandomVariable(2, 10);
    assertTrue(i >= 2 && i <= 10);
  }

  @Test
  public void getGearName() {
    Gear g = new HeadGear("abc", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    assertEquals("abc", g.getGearName());
  }

  @Test
  public void compareTo() {
    Gear g = new HeadGear("abc", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    Gear g1 = new HeadGear("xyz", new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    Potion p1 = new Potion("potion", new RandomNumberGenerateTest(5).getRandomNumber(1, 6));
    Footwear f1 = new Footwear("foot", new RandomNumberGenerateTest(5).getRandomNumber(1, 6));
    Belt b1 = new Belt("belt", new RandomNumberGenerateTest(5).getRandomNumber(1, 6),
            new RandomNumberGenerateTest(3).getRandomNumber(1, 6));
    assertEquals(23, g1.compareTo(g));
    assertEquals(1, p1.compareTo(g));
    assertEquals(1, f1.compareTo(g));
    assertEquals(1, f1.compareTo(p1));
    assertEquals(-1, p1.compareTo(f1));
    assertEquals(1, b1.compareTo(p1));
    assertEquals(1, b1.compareTo(g));
  }

}