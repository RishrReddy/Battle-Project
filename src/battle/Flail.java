package battle;

/**
 * Flail class represents a player's weapon of type Flail,
 * It has attributes like name , minimum damage, maximum damage and power.
 */
public class Flail extends Weapon {
  /**
   * Constructs a new Flail for the players' weaponry.
   */
  public Flail() {
    super("Flail", 8, 12);
  }

  @Override
  public String getType() {
    return "Flail";
  }
}
