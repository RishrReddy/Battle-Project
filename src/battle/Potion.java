package battle;

/**
 * Potion class represents one of the gear with player.
 * It has attributes like name power and size.
 */
public class Potion extends Gear {
  /**
   * Constructs a new potion for the player.
   *
   * @param name  name of the potion
   * @param power power provided by the potion
   */
  public Potion(String name, int power) {
    super(name, power);
  }

  @Override
  public GearType getType() {
    return GearType.POTION;
  }

  @Override
  public void updateAbilityPlayer(RandomNumbersGenerator randomNumber) {
    int abilityToBeUpdated = randomNumber.getRandomNumber(1, 4);
    helperUpdateAbility(abilityToBeUpdated);
  }

  @Override
  public int compareTo(Object o) throws IllegalArgumentException {
    if (!(o instanceof Gear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    Gear gears1 = (Gear) o;
    return gears1.compareToPotion(this);
  }

  @Override
  protected int compareToPotion(Potion o) {
    return o.getGearName().compareTo(this.getGearName());
  }

  @Override
  protected int compareToBelt(Belt o) {
    return 1;
  }
}
