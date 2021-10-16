package BattleProject;

/**
 * Sword class represents a player's weapon of type Sword,
 * It has attributes like name , minimum damage, maximum damage and power.
 * Further Sword class is inherited by Katana, Broadsword, and Twohanded
 */
public class Sword extends Weapon {

  /**
   * Constructs a new Sword for the players' weaponry.
   * @param name name of the sword
   * @param minimumDamage min damage inflicted.
   * @param maximumDamage max damage inflicted.
   */
  public Sword(String name, int minimumDamage, int maximumDamage) {
    super(name, minimumDamage, maximumDamage);
  }
}
