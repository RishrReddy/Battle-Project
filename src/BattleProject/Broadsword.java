package BattleProject;

/**
 * Broadsword class represents a player's weapon of type Sword thus it extends Sword class
 * It has attributes like name , minimum damage, maximum damage and power.
 */
public class Broadsword extends Weapon {
  /**
   * Constructs a new Broadsword for the players' weaponry.
   */
  public Broadsword() {
    super("Broadsword", 6, 10);
  }

  @Override
  public String getType() {
    return "Broadsword";
  }
}
