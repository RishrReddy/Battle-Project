package BattleProject;
import java.util.List;

/**
 * BattlePlayers interface represents the players battling in game.
 * It stores a list of players and has methods
 * that can be performed on a Player object.
 */
public interface BattlePlayers {

  /**
   * Gets the name of the current player.
   * @return Name of the player.
   */
  String getPlayerName();

  /**
   * Gets the constitution ability value of the current player.
   * @return constitution ability value(integer).
   */
  int getPlayerConstitution();

  /**
   * Gets the dexterity ability value of the current player.
   * @return dexterity ability value(integer).
   */
  int getPlayerDexterity();

  /**
   * Gets the health value of the current player.
   * @return health value(integer).
   */
  int getPlayerHealth();

  /**
   * Gets the charisma ability value of the current player.
   * @return charisma ability value(integer).
   */
  int getPlayerCharisma();

  /**
   * Gets the strength ability value of the current player.
   * @return strength ability value(integer).
   */
  int getPlayerStrength();

  /**
   * Generates a string with player's name and characteristics
   * like constitution, dexterity, charisma, strength, health,
   * striking power and avoidance ability.
   * @return the string with players details and characteristics.
   */
  String toString();

  /**
   * Generates a string with player's name and initial four characteristics
   * like constitution, dexterity, charisma, strength,
   * @return the string with players details and basic characteristics.
   */
  String toStringBasicAbilities();

  /**
   * Gets the avoidance ability value of the current player.
   * @return avoidance ability value(integer).
   */
  int getPlayerAvoidanceAbility();

  /**
   * Gets the striking power value of the current player.
   * @return striking power ability value(integer).
   */
  int getPlayerStrikingPower();

  /**
   * Generates a string with player's name and the gears he is equipped with
   * along with the power of the gear.
   * @return the string with players details and basic characteristics.
   */
  String toStringGear();

  /**
   * Gets the list of gears a player is equipped with.
   * @return List of gears with a player.
   */
  List<Gear> getPlayerGear();

  /**
   * Updates the strikingPower and avoidanceAbility of the player based on the
   * weapon's damage, gear's power and basic abilities.
   */
  void setBattleAbilities(int strikingPower, int avoidanceAbility);

  /**
   * Updates the gear list of player with the
   * new gear he is assigned with.
   *
   * @param gear Gear to be added to the list.
   */
  void updatePlayerGear(Gear gear);

  /**
   * Updates the weapon list of player with the
   * new weapon/weapons he is assigned with.
   *
   * @param w Weapon to be added to the list.
   */
  void updatePlayerWeapon(Weapon w);

  /**
   * Gets the list of weapons a player is equipped with.
   * @return List of weapons with a player.
   */
  List<Weapon> getWeapon();

  /**
   * Updates the health of the player after each strike
   * if the player was hit.
   *
   * @param newHealth updated health value to be assigned to player.
   */
  void updatePlayerHealth(int newHealth);

  /**
   * Restores the list of gears with a player
   * with empty gear list before starting a rematch.
   */
  void refreshGears();

  /**
   * Restores the list of weapons with a player
   * with empty weapon list before starting a rematch.
   */
  void refreshWeapons();

  /**
   * Restores the health of a player
   * to sum of initial basic abilities (constitution,dexterity,charisma,strength)
   */
  void refreshHealth();
}
