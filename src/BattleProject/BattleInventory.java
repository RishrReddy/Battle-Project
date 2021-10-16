package BattleProject;

import java.util.List;

/**
 * BattleInventory interface represents the inventory available to the players.
 * Inventory consists of multiple gears and weapons.
 * When a battle starts gears and weapons are randomly created and assigned to
 * both the players.
 */
public interface BattleInventory {

  /**
   * Method to initialize new gears and weapons.
   * This method in gears class creates a bag of 40 new gears
   * and in weapons it initializes the armoury.
   */
  void initializeInventory(List<BattlePlayers> playersList);

  /**
   * Assigns play with gears and weapons when requested.
   *
   * @param playerList List of both the players.
   */
  void assignEquipment(List<BattlePlayers> playerList);
}
