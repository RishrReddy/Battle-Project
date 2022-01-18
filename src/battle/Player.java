package battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Player class represents a single player who will be participating in a battle.
 * PLayer has attributes like name, constitution, dexterity, strength, charisma,
 * health,striking power, avoidanceAbility, list of gears and list of weapons.
 */
public class Player implements BattlePlayers {

  private final String name;
  private final int constitution;
  private final int strength;
  private final int dexterity;
  private final int charisma;
  private int health;
  private int strikingPower;
  private int avoidanceAbility;
  private int tempConstitution;
  private int tempStrength;
  private int tempDexterity;
  private int tempCharisma;
  private List<Gear> playerGear;
  private List<Weapon> weapon;

  /**
   * Constructs a new player with given name and initializes all the attributes to a
   * default value.
   *
   * @param playerName     name of the player
   * @param randomVariable RandomNumbersGenerator object which will be used
   *                       to generate random integers and list as and when required
   *                       as per the business logic.
   */
  public Player(String playerName, RandomNumbersGenerator randomVariable) {
    if (playerName == null || playerName.equals("")) {
      throw new IllegalArgumentException("Player must have a name");
    }
    if (randomVariable == null) {
      throw new IllegalArgumentException("Random variable cant be null");
    }
    this.name = playerName;
    this.constitution = updateAbility(randomVariable);
    this.strength = updateAbility(randomVariable);
    this.dexterity = updateAbility(randomVariable);
    this.charisma = updateAbility(randomVariable);
    this.health = getPlayerConstitution() + getPlayerStrength()
            + getPlayerDexterity() + getPlayerCharisma();
    this.strikingPower = 0;
    this.avoidanceAbility = 0;
    this.playerGear = new ArrayList<>();
    this.weapon = new ArrayList<>();
    this.tempConstitution = 0;
    this.tempStrength = 0;
    this.tempDexterity = 0;
    this.tempCharisma = 0;
  }

  /**
   * Helper method to update the basic abilities like
   * constitution, dexterity, strength, charisma
   * based on the 3 maximum die rolls.
   *
   * @param randomVariable RandomNumbersGenerator object to generate random number representing a
   *                       die roll.
   * @return sum the sum of maximum 3 die rolls.
   */
  private int updateAbility(RandomNumbersGenerator randomVariable) {
    if (randomVariable == null) {
      throw new IllegalArgumentException("Random variable cant be null");
    }
    List<Integer> diceValues = new ArrayList<>();
    for (int i = 1; i <= 4; i++) {
      int temp = randomVariable.getRandomNumber(1, 6);
      while (temp == 1) {
        temp = randomVariable.getRandomNumber(1, 6);
      }
      diceValues.add(temp);
    }
    Collections.sort(diceValues);
    diceValues.remove(diceValues.get(0));
    int sum = 0;
    for (Integer i : diceValues) {
      sum += i;
    }
    return sum;
  }

  @Override
  public String getPlayerName() {
    return name;
  }

  @Override
  public int getPlayerConstitution() {
    return this.constitution;
  }

  @Override
  public int getPlayerDexterity() {
    return this.dexterity;
  }

  @Override
  public int getPlayerHealth() {
    return this.health;
  }

  @Override
  public int getPlayerCharisma() {
    return this.charisma;
  }

  @Override
  public int getPlayerStrength() {
    return this.strength;
  }

  @Override
  public int getPlayerAvoidanceAbility() {
    return this.avoidanceAbility;
  }


  /**
   * Setter method to update the player's avoidance ability.
   *
   * @param avoidanceAbility new avoidance ability of the player.
   */
  private void setAvoidanceAbility(int avoidanceAbility) {
    this.avoidanceAbility = avoidanceAbility;
  }

  /**
   * Setter method to update the player's striking Power.
   *
   * @param strikingPower new striking Power of the player.
   */
  private void setStrikingPower(int strikingPower) {
    this.strikingPower = strikingPower;
  }

  /**
   * Setter method to update the player's health.
   *
   * @param health new health of the player.
   */
  private void setHealth(int health) {
    this.health = health;
  }

  @Override
  public int getPlayerStrikingPower() {
    return this.strikingPower;
  }

  @Override
  public List<Gear> getPlayerGear() {
    return playerGear;
  }

  /**
   * Setter method to add a gear to the player's gear list.
   *
   * @param gear new gear to be added.
   */
  private void setPlayerGear(Gear gear) {
    this.playerGear.add(gear);
  }

  /**
   * Setter method to add a weapon to the player's weapon list.
   *
   * @param w new weapon to be added.
   */
  private void setPlayerWeapon(Weapon w) {
    weapon.add(w);
  }

  @Override
  public String toStringGear() {
    StringBuilder sb = new StringBuilder();
    for (Gear g : getPlayerGear()) {
      sb.append("Gear Name is : ").append(g.getGearName()).append(" Gear power is : ")
              .append(g.getPower()).append("\n");
    }
    return sb.toString();
  }

  @Override
  public void setBattleAbilities(int strikingPower, int avoidanceAbility) {
    setAvoidanceAbility(avoidanceAbility);
    setStrikingPower(strikingPower);
  }

  @Override
  public String toString() {
    return "Player Name is : " + this.getPlayerName() + " Constitution: "
            + this.getPlayerConstitution()
            + " Charisma: " + this.getPlayerCharisma() + " Strength: " + this.getPlayerStrength()
            + " Dexterity: " + this.getPlayerDexterity() + " Health: " + this.getPlayerHealth()
            + " Avoidance Ability: " + this.getPlayerAvoidanceAbility() + " Striking Power: "
            + this.getPlayerStrikingPower();
  }

  @Override
  public String toStringBasicAbilities() {
    return ("Player Name is : " + this.getPlayerName() + " Constitution: "
            + this.getPlayerConstitution()
            + " Charisma: " + this.getPlayerCharisma() + " Strength: " + this.getPlayerStrength()
            + " Dexterity: " + this.getPlayerDexterity() + "\n");
  }

  @Override
  public void updatePlayerGear(Gear gear) {
    setPlayerGear(gear);
  }

  @Override
  public void updatePlayerWeapon(Weapon w) {
    setPlayerWeapon(w);
  }

  @Override
  public List<Weapon> getWeapon() {
    return this.weapon;
  }

  @Override
  public void updatePlayerHealth(int health) {
    setHealth(health);
  }

  @Override
  public void refreshGears() {
    this.playerGear = new ArrayList<>();
  }

  @Override
  public void refreshWeapons() {
    this.weapon = new ArrayList<>();
  }

  @Override
  public void refreshHealth() {
    this.health = getPlayerConstitution() + getPlayerStrength()
            + getPlayerDexterity() + getPlayerCharisma();
    this.strikingPower = 0;
    this.avoidanceAbility = 0;
  }

  @Override
  public int getTempConstitution() {
    return tempConstitution;
  }

  @Override
  public void setTempConstitution(int tempConstitution) {
    this.tempConstitution = tempConstitution;
  }

  @Override
  public int getTempStrength() {
    return tempStrength;
  }

  @Override
  public void setTempStrength(int tempStrength) {
    this.tempStrength = tempStrength;
  }

  @Override
  public int getTempDexterity() {
    return tempDexterity;
  }

  @Override
  public void setTempDexterity(int tempDexterity) {
    this.tempDexterity = tempDexterity;
  }

  @Override
  public int getTempCharisma() {
    return tempCharisma;
  }

  @Override
  public void setTempCharisma(int tempCharisma) {
    this.tempCharisma = tempCharisma;
  }
}
