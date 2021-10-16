package BattleProject;

/**
 * Footwear class represents one of the gear with player.
 * It has attributes like name and power.
 */
public class Footwear extends Gear {
  /**
   * Constructs a new Footwear for the player.
   * @param name name of the footwear.
   * @param power power provided by the footwear.
   */
  public Footwear(String name, int power) {
    super(name, power);
  }

  @Override
  public GearType getType() {
    return GearType.FOOTWEAR;
  }

  @Override
  public void updateAbilityPlayer(RandomNumbersGenerator randomNumber) {
    setAffectedAbilities(Ability.DEXTERITY);
  }

  @Override
  public int compareTo(Object o) throws IllegalArgumentException {
    if (!(o instanceof Gear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    Gear Gears1 = (Gear) o;
    return Gears1.compareToFootwear(this);
  }

  @Override
  protected int compareToFootwear(Footwear o) {
    return o.getGearName().compareTo(this.getGearName());
  }

  @Override
  protected int compareToBelt(Belt o) {

    return o.getGearName().compareTo(this.getGearName());
  }
}
