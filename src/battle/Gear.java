package battle;

import java.util.ArrayList;
import java.util.List;

/**
 * Gear class implements the methods in interface BattleInventory.
 * All the functionality related to gear available to a player are
 * present in the Gear class.
 */
public class Gear implements BattleInventory, Comparable {
  private static RandomNumbersGenerator randomVariable;
  private List<Gear> gearBag;
  private String gearName;
  private int power;
  private List<Ability> affectedAbilities;

  /**
   * Constructs a new gear object and initializes the random variable,
   * list of gears and list of affected abilities.
   *
   * @param randomVariable RandomNumbersGenerator object for generating random integers.
   */
  public Gear(RandomNumbersGenerator randomVariable) {
    if (gearBag == null) {
      gearBag = new ArrayList<>();
    }
    if (affectedAbilities == null) {
      this.affectedAbilities = new ArrayList<>();
    }
    this.randomVariable = randomVariable;
  }

  /**
   * Constructs a new gear with provided name and power.
   *
   * @param gearName name of the gear
   * @param power    power of the gear
   */
  public Gear(String gearName, int power) {
    if (gearName == null || gearName.equals("") || power < 0) {
      throw new IllegalArgumentException("Invalid Arguments provided");
    }
    if (gearBag == null) {
      gearBag = new ArrayList<>();
    }
    if (affectedAbilities == null) {
      this.affectedAbilities = new ArrayList<>();
    }
    this.gearName = gearName;
    this.power = power;
  }

  @Override
  public void initializeInventory(List<BattlePlayers> playersList) {
    generateInitialBag();
  }

  /**
   * Generates a bag full of 40 gears out of which 20 gears will be assigned to each player.
   */
  private void generateInitialBag() {
    for (int i = 1; i <= 5; i++) {
      Gear h = new HeadGear("Headgear" + i, getRandomVariable(1, 6));
      Gear f = new Footwear("Footwear" + i, getRandomVariable(1, 6));
      gearBag.add(h);
      gearBag.add(f);
    }
    for (int i = 1; i <= 15; i++) {
      Gear b = new Belt("Belt" + i, getRandomVariable(1, 6),
              getRandomVariable(1, 3));
      Gear p = new Potion("Potion" + i, getRandomVariable(1, 6));
      gearBag.add(b);
      gearBag.add(p);
    }
  }

  @Override
  public void assignEquipment(List<BattlePlayers> playerList) {

    updateDiminishingPowerInBag(randomVariable);
    List<Integer> index;
    List<Gear> player1GearBag = new ArrayList<>();
    List<Gear> player2GearBag = new ArrayList<>();
    index = randomVariable.getRandomList(20, gearBag.size() - 1);
    for (Integer i : index) {
      player1GearBag.add(gearBag.get(i));
    }
    for (int i = 0; i < gearBag.size(); i++) {
      if (!index.contains(i)) {
        player2GearBag.add(gearBag.get(i));
      }
    }
    //gearBag.clear();
    assignPlayerGear(playerList.get(0), player1GearBag);
    assignPlayerGear(playerList.get(1), player2GearBag);
    for (BattlePlayers p : playerList) {
      for (Gear g : p.getPlayerGear()) {
        g.updateAbilityPlayer(randomVariable);
      }
    }
  }

  /**
   * Method to update ability of the player with a random number.
   * This method is overridden in subclasses to produce different
   * values based on the gears.
   *
   * @param randomNumber Random Variable object.
   */
  protected void updateAbilityPlayer(RandomNumbersGenerator randomNumber) {
    if (randomNumber == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    this.updateAbilityPlayer(randomNumber);
  }

  /**
   * Method to assign gear to the players.
   *
   * @param player        Player of the battle
   * @param playerGearBag initial bag of 20 items with player
   */
  private void assignPlayerGear(BattlePlayers player, List<Gear> playerGearBag) {
    List<Gear> headGear = new ArrayList<>();
    List<Gear> footWear = new ArrayList<>();
    List<Gear> belt = new ArrayList<>();

    for (Gear g : playerGearBag) {
      if (g.getType() == GearType.HEADGEAR) {
        headGear.add(g);
      } else if (g.getType() == GearType.FOOTWEAR) {
        footWear.add(g);
      } else if (g.getType() == GearType.POTION) {
        player.updatePlayerGear(g);
      } else {
        belt.add(g);
      }
    }

    if (headGear.size() == 1) {
      player.updatePlayerGear(headGear.get(0));
    } else if (headGear.size() > 1) {
      player.updatePlayerGear(headGear.get(getRandomVariable(0, headGear.size() - 1)));
    }
    if (footWear.size() == 1) {
      player.updatePlayerGear(footWear.get(0));
    } else if (footWear.size() > 1) {
      player.updatePlayerGear(footWear.get(getRandomVariable(0, footWear.size() - 1)));
    }

    int sum = 0;
    for (Gear b : belt) {
      Belt b1 = (Belt) b;
      sum = sum + b1.getBeltSize();
      if (sum <= 10) {
        player.updatePlayerGear(b);
      }
    }
  }


  /**
   * Updated the power of 25% gears in the bag to diminishing power.
   *
   * @param randomVariable object of Random variable.
   */
  private void updateDiminishingPowerInBag(RandomNumbersGenerator randomVariable) {
    int value = (int) (0.25 * gearBag.size());
    List<Integer> index;
    index = randomVariable.getRandomList(value, gearBag.size() - 1);
    for (Integer i : index) {
      gearBag.get(i).setPower(-1 * gearBag.get(i).getPower());
    }
  }

  /**
   * Gets the type of the gear - Headgear, potion, belt, footwear.
   *
   * @return the gear type
   */
  public GearType getType() {
    if (!(this instanceof Gear)) {
      throw new IllegalArgumentException("Comparison is not possible");
    }
    return this.getType();
  }

  /**
   * Gets a List of abilities affected by the current gear.
   *
   * @return List of abilities that the gear can affect.
   */
  public List<Ability> getAffectedAbilities() {
    return this.affectedAbilities;
  }

  /**
   * Adds an ability to the list of abilities present with the gear.
   *
   * @param ability ability to be enhanced/diminished.
   */
  protected void setAffectedAbilities(Ability ability) {
    if (ability == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    this.affectedAbilities.add(ability);
  }

  /**
   * Adds a particular ability to be updated base on the
   * random number generated for a gear.
   *
   * @param abilityValue ability to be affected.
   */
  protected void helperUpdateAbility(int abilityValue) {
    if (abilityValue == 1) {
      setAffectedAbilities(Ability.CONSTITUTION);
    } else if (abilityValue == 2) {
      setAffectedAbilities(Ability.DEXTERITY);
    } else if (abilityValue == 3) {
      setAffectedAbilities(Ability.STRENGTH);
    } else if (abilityValue == 4) {
      setAffectedAbilities(Ability.CHARISMA);
    }
  }

  /**
   * Gets the power associated with gear.
   *
   * @return gear's power value.
   */
  public int getPower() {
    return this.power;
  }

  /**
   * Updates the power of the gear.
   *
   * @param power power to be updated.
   */
  private void setPower(int power) {
    this.power = power;
  }

  /**
   * Generated a random integer.
   *
   * @param min min random value possible
   * @param max max random value possible
   * @return random integer in the range of min and max.
   */
  public int getRandomVariable(int min, int max) {
    if (min < 0 || min > max || max < 0 || min == max) {
      throw new IllegalArgumentException("Range specified is not correct");
    }
    return randomVariable.getRandomNumber(min, max);
  }

  /**
   * Gets the name of the current gear.
   *
   * @return Name of the gear.
   */
  public String getGearName() {
    return gearName;
  }


  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * @param o the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object
   *          is less than, equal to, or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it
   *                              from being compared to this object.
   */
  @Override
  public int compareTo(Object o) {
    return 0;
  }

  /**
   * Method to compare given gear with a gear of type headgear.
   *
   * @param o Headgear object
   * @return -1 by default, overridden in child classes.
   */
  protected int compareToHeadgear(HeadGear o) {
    return -1;
  }

  /**
   * Method to compare given gear with a gear of type potion.
   *
   * @param o potion object
   * @return -1 by default, overridden in child classes.
   */
  protected int compareToPotion(Potion o) {
    return -1;
  }

  /**
   * Method to compare given gear with a gear of type Belt.
   *
   * @param o belt object
   * @return -1 by default, overridden in child classes.
   */
  protected int compareToBelt(Belt o) {
    return -1;
  }

  /**
   * Method to compare given gear with a gear of type footwear.
   *
   * @param o footwear object
   * @return -1 by default, overridden in child classes.
   */
  protected int compareToFootwear(Footwear o) {
    return 1;
  }

}
