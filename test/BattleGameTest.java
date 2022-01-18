import org.junit.Before;
import org.junit.Test;

import battle.BattleGame;
import battle.Game;
import battle.Gear;
import battle.RandomNumberGenerateSource;
import battle.RandomNumberGenerateTest;
import battle.RandomNumbersGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * PLayerTest class represents all the test cases related ta a battle between 2 players
 * other methods implemented from the Game interface.
 */
public class BattleGameTest {
  Game b;
  Game b2;
  RandomNumbersGenerator r1 = new RandomNumberGenerateTest(2);
  RandomNumbersGenerator r2 = new RandomNumberGenerateTest(27, 30, 1, 2, 3, 4, 5, 6, 7, 8,
          9, 11, 12, 13, 23, 14, 21, 22, 24, 16);

  @Before
  public void setUp() throws Exception {
    b = new BattleGame(r2);
  }

  @Test
  public void initializeBattleTest() {
    String actual = b.initializeBattle("Player1", "Player2");
    assertEquals("Player Name is : Player1 Constitution: 6 Charisma: 6 Strength: 6 Dexterity: 6\n"
            + "Player Name is : Player2 Constitution:"
            + " 6 Charisma: 6 Strength: 6 Dexterity: 6\n", actual);
  }

  @Test
  public void equipPlayersWithGear() {
    Game b2 = new BattleGame(r2);
    b2.initializeBattle("Player1", "Player2");
    assertEquals("\nPlayer1 Gears Equipped \n" + "Gear Name is : Potion9 Gear power is : 2\n"
            + "Gear Name is : Potion1 Gear power is : -2\n"
            + "Gear Name is : Potion2 Gear power is : 2\n"
            + "Gear Name is : Potion7 Gear power is : -2\n"
            + "Gear Name is : Potion6 Gear power is : 2\n"
            + "Gear Name is : Headgear4 Gear power is : -2\n"
            + "Gear Name is : Footwear3 Gear power is : 2\n"
            + "Gear Name is : Belt11 Gear power is : 2\n"
            + "Gear Name is : Belt2 Gear power is : 2\n"
            + "Gear Name is : Belt3 Gear power is : 2\n"
            + "Gear Name is : Belt7 Gear power is : 2\n"
            + "Gear Name is : Belt8 Gear power is : 2\n"
            + "\n" + "**************************\n" + "\n"
            + "Player2 Gears Equipped \n"
            + "Gear Name is : Potion3 Gear power is : -2\n"
            + "Gear Name is : Potion4 Gear power is : 2\n"
            + "Gear Name is : Potion5 Gear power is : 2\n"
            + "Gear Name is : Potion8 Gear power is : 2\n"
            + "Gear Name is : Potion10 Gear power is : 2\n"
            + "Gear Name is : Potion11 Gear power is : 2\n"
            + "Gear Name is : Potion12 Gear power is : 2\n"
            + "Gear Name is : Potion13 Gear power is : 2\n"
            + "Gear Name is : Potion14 Gear power is : 2\n"
            + "Gear Name is : Potion15 Gear power is : -2\n"
            + "Gear Name is : Headgear1 Gear power is : 2\n"
            + "Gear Name is : Belt1 Gear power is : 2\n"
            + "Gear Name is : Belt5 Gear power is : -2\n"
            + "Gear Name is : Belt6 Gear power is : -2\n"
            + "Gear Name is : Belt9 Gear power is : 2\n"
            + "Gear Name is : Belt10 Gear power is : 2\n"
            + "\n" + "**************************\n", b2.equipPlayersWithGear());
  }

  @Test
  public void requestPlayerWeapons() {
    Game b3 = new BattleGame(r2);
    b3.initializeBattle("Player1", "Player2");
    assertTrue(b3.requestPlayerWeapons().contains("Player1 has wielded Axe \n" +
            "Player2 has wielded Axe \n"));
  }

  @Test
  public void getStrikingPlayer() {
    Game b4 = new BattleGame(r2);
    b4.initializeBattle("Player1", "Player2");
    assertEquals("Player2", b4.getStrikingPlayer());
  }

  @Test
  public void getRandomVariable() {
    Game b5 = new BattleGame(r2);
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
  public void startRound() {
    RandomNumbersGenerator r = new RandomNumberGenerateTest(1, 2, 3, 4, 5, 6, 7, 8,
            9, 10, 12, 13, 23, 14, 21, 22, 24, 30);
    Game battle = new BattleGame(r);
    battle.initializeBattle("rish", "brown");
    battle.equipPlayersWithGear();
    battle.requestPlayerWeapons();
    assertTrue(battle.startBattle(battle.getStrikingPlayer()).contains("Winner is brown")
            || battle.startBattle(battle.getStrikingPlayer()).contains("Winner is rish")
            || battle.startBattle(battle.getStrikingPlayer()).contains(" Its A Draw "));
  }

  @Test
  public void getOrderedGearList() {
    b.initializeBattle("Rishita", "Bharath");
    b.equipPlayersWithGear();
    assertEquals("Player Name : Rishita \n"
            + "Gear Name : Headgear4 Gear Power : -2 \n"
            + "Gear Name : Potion1 Gear Power : -2 \n"
            + "Gear Name : Potion2 Gear Power : 2 \n"
            + "Gear Name : Potion6 Gear Power : 2 \n" + "Gear Name : Potion7 Gear Power : -2 \n"
            + "Gear Name : Potion9 Gear Power : 2 \n" + "Gear Name : Belt11 Gear Power : 2 \n"
            + "Gear Name : Belt2 Gear Power : 2 \n" + "Gear Name : Belt3 Gear Power : 2 \n"
            + "Gear Name : Belt7 Gear Power : 2 \n" + "Gear Name : Belt8 Gear Power : 2 \n"
            + "Gear Name : Footwear3 Gear Power : 2 \n" + "Player Name : Bharath \n"
            + "Gear Name : Headgear1 Gear Power : 2 \n" + "Gear Name : Potion10 Gear Power : 2 \n"
            + "Gear Name : Potion11 Gear Power : 2 \n" + "Gear Name : Potion12 Gear Power : 2 \n"
            + "Gear Name : Potion13 Gear Power : 2 \n" + "Gear Name : Potion14 Gear Power : 2 \n"
            + "Gear Name : Potion15 Gear Power : -2 \n" + "Gear Name : Potion3 Gear Power : -2 \n"
            + "Gear Name : Potion4 Gear Power : 2 \n" + "Gear Name : Potion5 Gear Power : 2 \n"
            + "Gear Name : Potion8 Gear Power : 2 \n" + "Gear Name : Belt1 Gear Power : 2 \n"
            + "Gear Name : Belt10 Gear Power : 2 \n" + "Gear Name : Belt5 Gear Power : -2 \n"
            + "Gear Name : Belt6 Gear Power : -2 \n"
            + "Gear Name : Belt9 Gear Power : 2 \n", b.getOrderedGearList());
  }
}