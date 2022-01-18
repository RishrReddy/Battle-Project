package battle;

/**
 * Game interface represents the entire game.
 * A game starts with adding two players who are ready to battle
 * When a battle starts gears and weapons are randomly created and
 * assigned to both the players. Striking powers are calculated and the
 * players strike each other one after the other and finally one emerges as a winner.
 */
public interface Game {

  /**
   * Assigns gears to players from the gear bag.
   *
   * @return String of details of gears received by the players.
   */
  String equipPlayersWithGear();

  /**
   * Initializes a battle between 2 players. It creates two players
   * assigns them
   * and generates bag of gears of them.
   *
   * @param player1 name of the player 1.
   * @param player2 name of the player 2.
   * @return String of details of gears received by the players.
   */
  String initializeBattle(String player1, String player2);

  /**
   * Assigns both the players with random weapons.
   *
   * @return String of details of weapons received by the players.
   */
  String requestPlayerWeapons();

  /**
   * Decides the player who gets to strike first
   * based on the charisma of the player.
   *
   * @return String of details of the player who gets to strike first.
   */
  String getStrikingPlayer();

  /**
   * Starts the battle between 2 players.
   *
   * @param strikingPlayer name of the player who strikes first.
   * @return String of details of all the strikes.
   */
  String startBattle(String strikingPlayer);

  /**
   * Gets the winner of the battle.
   *
   * @return name of the battle winner.
   */
  String getWinner();

  /**
   * Resets all the gears, weapons and health properties
   * of the players for a rematch.
   */
  void refreshArena();

  /**
   * Prints the list of gears in top to bottom order.
   * headgears - potions - belts - footwear.
   *
   * @return String of list of gears in order specifies above.
   */
  String getOrderedGearList();
}
