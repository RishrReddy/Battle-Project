package battle;

/**
 * Belt class represents one of the gear with player.
 * It has attributes like name power and size.
 * Belts can come in 3 different sizes.
 */
public class Belt extends Gear {
  private final BeltSize beltSize;

  /**
   * Constructs a new belt for the player.
   *
   * @param name           name of the belt
   * @param power          power provided by the belt
   * @param randomBeltSize size of the belt.
   */
  public Belt(String name, int power, int randomBeltSize) {
    super(name, power);
    this.beltSize = randomBeltSize == 1 ? BeltSize.SMALL : randomBeltSize == 2 ? BeltSize.MEDIUM
            : BeltSize.LARGE;
  }

  @Override
  public GearType getType() {
    return GearType.BELT;
  }


  /**
   * Provides the size of the belt.
   *
   * @return size of the belt
   */
  public int getBeltSize() {
    return this.beltSize.getValue();
  }

  @Override
  public void updateAbilityPlayer(RandomNumbersGenerator randomNumber) {
    int totalAbilityUpdated = randomNumber.getRandomNumber(0, 2);
    if (totalAbilityUpdated != 0) {
      for (int i = 0; i < totalAbilityUpdated; i++) {
        int abilityToBeUpdated = getRandomVariable(1, 4);
        helperUpdateAbility(abilityToBeUpdated);
      }
    }
  }

  @Override
  public int compareTo(Object o) {
    if (!(o instanceof Gear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    Gear gears1 = (Gear) o;
    return gears1.compareToBelt(this);
  }

  @Override
  protected int compareToBelt(Belt o) {
    return o.getGearName().compareTo(this.getGearName());
  }
}
