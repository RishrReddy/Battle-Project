package BattleProject;

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
