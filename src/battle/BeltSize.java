package battle;

/**
 * Ability is an enumeration which provides,
 * possible values for a player's belt size:
 * SMALL, MEDIUM, LARGE.
 * Each size is associated with number of units a player can
 * wear of that particular size.
 */
public enum BeltSize {
  SMALL(1),
  MEDIUM(2),
  LARGE(4);
  private final int value;

  BeltSize(final int newValue) {
    value = newValue;
  }

  /**
   * Gets the number of units of current
   * size that can be worn.
   *
   * @return Number of units corresponding to the belt size.
   */
  public int getValue() {
    return value;
  }
}
