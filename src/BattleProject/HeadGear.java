package BattleProject;

/**
 * HeadGear class represents one of the gear with player.
 * It has attributes like name and power.
 */
public class HeadGear extends Gear {
  /**
   * Constructs a new HeadGear for the player.
   * @param name name of the HeadGear.
   * @param power power provided by the HeadGear.
   */
  public HeadGear(String name, int power) {
    super(name, power);
  }

  @Override
  public GearType getType() {
    return GearType.HEADGEAR;
  }

  @Override
  protected void updateAbilityPlayer(RandomNumbersGenerator randomNumber) {
    setAffectedAbilities(Ability.CONSTITUTION);
  }


  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * @param o the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object
   * is less than, equal to, or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it
   *                              from being compared to this object.
   */
  @Override
  public int compareTo(Object o) throws IllegalArgumentException {
    if (!(o instanceof Gear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    Gear gear = (Gear) o;
    return gear.compareToHeadgear(this);
  }

  @Override
  protected int compareToHeadgear(HeadGear o) {
    return o.getGearName().compareTo(this.getGearName());
  }

  @Override
  protected int compareToPotion(Potion o) {
    return 1;
  }

  @Override
  protected int compareToBelt(Belt o) {
    return 1;
  }
}
