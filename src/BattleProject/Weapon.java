package BattleProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Weapon class implements the methods in interface BattleInventory.
 * All the functionality related to weapon available to a player are
 * present in the Weapon class.
 * There are 3 types of weapons swords, axes and flails.
 * Every weapon has attributes like name, minimum and maximum damage it can inflict
 */
public class Weapon implements BattleInventory {
  private final String name;
  private final int minimumDamage;
  private final int maximumDamage;
  private RandomNumbersGenerator randomVariable;


  /**
   * Constructs a new weapon object and initializes the random variable,
   * name, minimumDamage, maximumDamage to default values.
   *
   * @param randomVariable RandomNumbersGenerator object for generating random integers.
   */
  public Weapon(RandomNumbersGenerator randomVariable) {
    if(randomVariable==null){
      throw new IllegalArgumentException("Invalid Arguments");
    }
    this.name = null;
    this.minimumDamage = 0;
    this.maximumDamage = 0;
    this.randomVariable = randomVariable;
  }

  /**
   * Constructs a new weapon object with the provided
   * name, minimumDamage, maximumDamage .
   * @param name name of the weapon.
   * @param minimumDamage minimum damage it can inflict.
   * @param maximumDamage maximum damage it can inflict.
   */
  public Weapon(String name, int minimumDamage, int maximumDamage) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Weapon should have a valid name");
    }
    if(minimumDamage < 0 || minimumDamage > maximumDamage || minimumDamage == maximumDamage){
      throw new IllegalArgumentException("Range specified is not correct");
    }
    this.name = name;
    this.minimumDamage = minimumDamage;
    this.maximumDamage = maximumDamage;
  }

  @Override
  public void initializeInventory(List<BattlePlayers> playerList ) {
    assignEquipment(playerList);
  }

  @Override
  public void assignEquipment(List<BattlePlayers> playerList) {
    for (BattlePlayers p : playerList) {
      int weaponTypeToReceive = randomVariable.getRandomNumber(1, 3);
      List<Weapon> playerWeapon = receiveWeapon(weaponTypeToReceive);
      for (Weapon w : playerWeapon) {
        p.updatePlayerWeapon(w);
      }
    }
  }

  /**
   * Helper method to generator a type of weapons to
   * be given to player based on the random number.
   *
   * @param weaponTypeToReceive Random integer representing sword type
   *                            1- sword
   *                            2- axe
   *                            3- flail
   * @return List of weapons with the player
   */
  private List<Weapon> receiveWeapon(int weaponTypeToReceive) {
    List<Weapon> playerWeapon = new ArrayList<>();
    if (weaponTypeToReceive == 1) {
      int swordTypeToReceive = randomVariable.getRandomNumber(1, 3);
      playerWeapon = receiveSword(swordTypeToReceive);
    } else if (weaponTypeToReceive == 2) {
      Weapon axe = new Axe();
      playerWeapon.add(axe);
    } else if (weaponTypeToReceive == 3) {
      Weapon flail = new Flail();
      playerWeapon.add(flail);
    }

    return playerWeapon;
  }

  /**
   * Helper method to generator a type of sword to
   * be given to player based on the random number, if he is to receive swords.
   *
   * @param swordTypeToReceive Random integer representing sword type
   *                            1- katana
   *                            2- broadsword
   *                            3- twohandedsword
   * @return List of swords with the player
   */
  private List<Weapon> receiveSword(int swordTypeToReceive) {
    List<Weapon> swords = new ArrayList<>();
    if (swordTypeToReceive == 1) {
      Weapon first_katana = new Katana();
      swords.add(first_katana);
      int swordDraw2 = randomVariable.getRandomNumber(1, 3);
      if (swordDraw2 == 1) {
        Weapon k2 = new Katana();
        swords.add(k2);
      }
    } else if (swordTypeToReceive == 2) {
      Weapon broadsword = new Broadsword();
      swords.add(broadsword);
    } else if (swordTypeToReceive == 3) {
      Weapon twoHandedSword = new TwoHandedSword();
      swords.add(twoHandedSword);
    }
    return swords;
  }


  /**
   * Gets the name of the current weapon.
   * @return name of the weapon.
   */
  public String getWeaponName() {
    return name;
  }

  /**
   * Gets the type of the current weapon.
   * @return type of the weapon
   */
  public String getType() {
    return this.getType();
  }

  /**
   * Gets the minimum damage inflicted by thw current weapon.
   * @return minimum damage inflicted
   */
  public int getMinimumDamage() {
    return minimumDamage;
  }

  /**
   * Gets the maximum damage inflicted by thw current weapon.
   * @return maximum damage inflicted
   */
  public int getMaximumDamage() {
    return maximumDamage;
  }
}
