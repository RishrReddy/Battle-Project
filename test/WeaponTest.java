import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battle.Axe;
import battle.BattleGame;
import battle.BattleInventory;
import battle.BattlePlayers;
import battle.Broadsword;
import battle.Flail;
import battle.Game;
import battle.Katana;
import battle.Player;
import battle.RandomNumberGenerateTest;
import battle.RandomNumbersGenerator;
import battle.Sword;
import battle.TwoHandedSword;
import battle.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * WeaponTest class represents all the test cases related ta a weapon object,
 * its subclasses and other methods implemented from the BattleInventory class.
 */
public class WeaponTest {

  BattleInventory w1;
  Weapon w2;
  Weapon w3;
  Weapon w4;
  Weapon w5;
  Weapon w6;
  RandomNumbersGenerator r1 = new RandomNumberGenerateTest(2);

  @Before
  public void setup() {
    w1 = new Weapon(r1);
    w2 = new Axe();
    w3 = new Flail();
    w4 = new Katana();
    w5 = new Broadsword();
    w6 = new TwoHandedSword();
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorTestNullName() {
    new Weapon(null, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorTestNullRandomVariable() {
    new Weapon(null);
  }

  @Test
  public void initializeInventory() {
    Game battle = new BattleGame(r1);
    battle.initializeBattle("Player1", "Player2");
    //  w1.initializeInventory();
    assertTrue(battle.requestPlayerWeapons().contains("Player1 has wielded Axe \n"
            + "Player2 has wielded Axe "));
  }

  @Test
  public void assignEquipment() {
    BattlePlayers p1 = new Player("player1", new RandomNumberGenerateTest(2));
    BattlePlayers p2 = new Player("player2", new RandomNumberGenerateTest(3));
    List<BattlePlayers> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);
    BattleInventory weapon = new Weapon(new RandomNumberGenerateTest(2));
    assertEquals(0, p1.getWeapon().size());
    assertEquals(0, p2.getWeapon().size());
    weapon.assignEquipment(playerList);
    assertTrue(p1.getWeapon().size() > 0);
    assertEquals("Axe", p1.getWeapon().get(0).getWeaponName());
    assertTrue(p2.getWeapon().size() > 0);
    assertEquals("Axe", p2.getWeapon().get(0).getWeaponName());
  }

  @Test
  public void getWeaponName() {
    assertEquals("Axe", w2.getWeaponName());
    assertEquals("Flail", w3.getWeaponName());
    assertEquals("Katana", w4.getWeaponName());
    assertEquals("Broadsword", w5.getWeaponName());
    assertEquals("TwoHandedSword", w6.getWeaponName());
  }

  @Test
  public void getType() {
    assertEquals("Axe", w2.getType());
    assertEquals("Flail", w3.getType());
    assertEquals("Katana", w4.getType());
    assertEquals("Broadsword", w5.getType());
    assertEquals("TwoHandedSword", w6.getType());
  }

  @Test
  public void getMinimumDamage() {
    assertEquals(6, w2.getMinimumDamage());
    assertEquals(8, w3.getMinimumDamage());
    assertEquals(4, w4.getMinimumDamage());
    assertEquals(6, w5.getMinimumDamage());
    assertEquals(8, w6.getMinimumDamage());
  }

  @Test
  public void getMaximumDamage() {
    assertEquals(10, w2.getMaximumDamage());
    assertEquals(12, w3.getMaximumDamage());
    assertEquals(6, w4.getMaximumDamage());
    assertEquals(10, w5.getMaximumDamage());
    assertEquals(12, w6.getMaximumDamage());
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidSword() {
    new Sword(null, 1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidSwordMin() {
    new Sword("anc", 10, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createInvalidSwordMax() {
    new Sword(null, 1, 0);
  }
}