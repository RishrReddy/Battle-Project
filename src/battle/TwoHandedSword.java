package battle;

/**
 * TwoHandedSword class represents a player's weapon of type Sword thus it extends Sword class
 * It has attributes like name , minimum damage, maximum damage and power.
 * A player can handle it one handed or two handed depending upon his strength.
 */
public class TwoHandedSword extends Weapon {
  /**
   * Constructs a new TwoHandedSword for the players' weaponry.
   */
  public TwoHandedSword() {
    super("TwoHandedSword", 8, 12);
  }

  @Override
  public String getType() {
    return "TwoHandedSword";
  }

}
