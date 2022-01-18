package battle;

/**
 * Katana class represents a player's weapon of type Sword thus it extends Sword class
 * It has attributes like name , minimum damage, maximum damage and power.
 */
public class Katana extends Sword {
  /**
   * Constructs a new Katana for the players' weaponry.
   */
  public Katana() {
    super("Katana", 4, 6);
  }

  @Override
  public String getType() {
    return "Katana";
  }
}
