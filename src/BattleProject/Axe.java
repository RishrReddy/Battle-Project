package BattleProject;

/**
 * Axe class represents a player's weapon of type Axe,
 * It has attributes like name , minimum damage, maximum damage and power.
 */
public class Axe extends Weapon {

  /**
   * Constructs a new Axe for the players' weaponry.
   */
  public Axe() {
    super("Axe", 6, 10);
  }

  @Override
  public String getType() {
    return "Axe";
  }
}
