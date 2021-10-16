package BattleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BattleGame class implements the methods in interface Game.
 * All the functionality to be performed in a battle arena is
 * present in the BattleGame class.
 */
public class BattleGame implements Game {
  private List<BattlePlayers> playerList;
  private final RandomNumbersGenerator randomVariable;
  BattleInventory gears;
  int round = 1;
  StringBuilder roundStatus = new StringBuilder();


  /**
   * Constructor to initialize a new battle. Initializes empty list
   * for new players to be added.
   *
   * @param randomVariable Random variable to be used for assigning
   *                       weapons, gears and abilities to the players.
   *
   * @throws IllegalArgumentException Throws the exception
   *         when provided random variable is null.
   */
  public BattleGame(RandomNumbersGenerator randomVariable) {
    if(randomVariable==null){
      throw new IllegalArgumentException("Random Variable can not be null");
    }
    if (playerList == null) {
      playerList = new ArrayList<>();
    }
    this.randomVariable = randomVariable;
  }

  @Override
  public String initializeBattle(String player1, String player2) {
    if(player1.equals(null) || player2.equals(null)){
      throw new IllegalArgumentException("2 players are needed to start the game");
    }
    BattlePlayers p1 = new Player(player1, randomVariable);
    playerList.add(p1);
    BattlePlayers p2 = new Player(player2, randomVariable);
    playerList.add(p2);
    gears = new Gear(randomVariable);
    gears.initializeInventory(playerList);
    return printPlayerWithBasicAbilities().toString();
  }

  @Override
  public String equipPlayersWithGear() {
    gears.assignEquipment(playerList);
    updatePlayersHealthParameters();
    StringBuilder sb = new StringBuilder();
    for (BattlePlayers player : playerList) {
      sb.append("\n" + player.getPlayerName() + " Gears Equipped \n"
              + player.toStringGear() + "\n**************************\n");
      System.out.println(player);
    }
    return sb.toString();
  }

  /**
   * Helper method to calculate and update the striking power
   * and avoidance ability of player.
   */
  private void updatePlayersHealthParameters() {
    for (BattlePlayers p : playerList) {
      int avoidanceAbility = updateHealth(Ability.DEXTERITY, p) + p.getPlayerDexterity();
      int strikingPower = updateHealth(Ability.CONSTITUTION, p) + p.getPlayerConstitution();
      p.setBattleAbilities(strikingPower, avoidanceAbility);
    }
  }

  /**
   * Helper method to calculate the total abilities that can be
   * affected by a gear.
   *
   * @return sum total power of all the gears providing
   *         certain ability.
   */
  private int updateHealth(Ability ability, BattlePlayers p) {
    int sum = 0;
    for (Gear g : p.getPlayerGear()) {
      for (Ability a : g.getAffectedAbilities()) {
        if (a == ability) {
          sum = sum + g.getPower();
        }
      }
    }
    return sum;
  }


  @Override
  public String requestPlayerWeapons() {
    BattleInventory weapon = new Weapon(randomVariable);
    StringBuilder sb = new StringBuilder();
    weapon.initializeInventory(getPlayerList());
    for (BattlePlayers p : playerList) {
      for (Weapon w : p.getWeapon()) {
        sb.append(p.getPlayerName() + " has wielded " + w.getWeaponName() + " \n");
      }
    }
    return sb.toString();
  }

  @Override
  public String getStrikingPlayer() {
    if (playerList.get(0).getPlayerCharisma() > playerList.get(1).getPlayerCharisma()) {
      return playerList.get(0).getPlayerName();
    } else {
      return playerList.get(1).getPlayerName();
    }
  }

  /**
   * Helper method to print player details with initial
   * 4 abilities of constitution, dexterity, strength
   * and charisma.
   *
   * @returns sb string with the details to be printed.
   */
  private StringBuilder printPlayerWithBasicAbilities() {
    StringBuilder sb = new StringBuilder();
    for (BattlePlayers p : playerList) {
      sb.append(p.toStringBasicAbilities());
    }
    return sb;
  }


  /**
   * Generated a random integer.
   *
   * @param min min random value possible
   * @param max max random value possible
   * @return random integer in the range of min and max.
   */
  public int getRandomVariable(int min, int max) {
    return randomVariable.getRandomNumber(min, max);
  }

  @Override
  public String startRound(String playerName) {
    BattlePlayers strikingPlayer;
    BattlePlayers opponentPlayer;
    int strikePower;
    int avoidanceAbility;
    if (playerList.get(0).getPlayerName().equals(playerName)) {
      strikingPlayer = playerList.get(0);
      opponentPlayer = playerList.get(1);
    } else {
      strikingPlayer = playerList.get(1);
      opponentPlayer = playerList.get(0);
    }
    strikePower = strikingPlayer.getPlayerStrikingPower() + getRandomVariable(1, 10);
    avoidanceAbility = opponentPlayer.getPlayerAvoidanceAbility() + getRandomVariable(1, 6);
    if ((strikingPlayer.getPlayerStrikingPower() == opponentPlayer.getPlayerAvoidanceAbility())) {
      roundStatus.append("Game draw as Striking player's StrikingPower is equal"
              + " to Opponent Player's AvoidanceAbility");
      return roundStatus.toString();
    } else if ((strikingPlayer.getPlayerHealth() > 0) && (opponentPlayer.getPlayerHealth() > 0)) {
      roundStatus.append(" ****************** Round ").append(round).append(" ********************** \n");
      roundStatus.append("Striking Player Name " + strikingPlayer.getPlayerName()
              + " Striking Power:" + strikePower + "\n"
              + "Opponent Player Name " + opponentPlayer.getPlayerName()
              + " Avoidance Power:" + avoidanceAbility
              + " Opponent Health: " + opponentPlayer.getPlayerHealth() + "\n");
      if (strikePower > avoidanceAbility) {
        for (Weapon w : strikingPlayer.getWeapon()) {
          int weaponDamage = getRandomVariable(w.getMinimumDamage(), w.getMaximumDamage());
          if ((w.getType().equals("Flail") && strikingPlayer.getPlayerDexterity() <= 14)
                  || (w.getType().equals("TwoHandedSword")
                  && strikingPlayer.getPlayerStrength() <= 14)) {
            weaponDamage = weaponDamage / 2;
          }
          int potentialStrikingDamage = strikingPlayer.getPlayerStrength() + weaponDamage;
          int actualDamage = potentialStrikingDamage - opponentPlayer.getPlayerConstitution();
          roundStatus.append("Striking Player Weapon Damage :  " + weaponDamage + "\n"
                  + " Striking Player potentialStrikingDamage: " + potentialStrikingDamage + "\n"
                  + " actualDamage: " + actualDamage + "\n");

          if (actualDamage > 0) {
            opponentPlayer.updatePlayerHealth(opponentPlayer.getPlayerHealth() - actualDamage);
          }
        }
      }
      roundStatus.append("After the strike : \n " + "opponentPlayer Player Name: " + opponentPlayer.getPlayerName()
              + " opponentPlayer Health: " + opponentPlayer.getPlayerHealth() + "\n\n\n");
      round = round + 1;
      startRound(opponentPlayer.getPlayerName());
      return roundStatus.toString();
    }
    return "";
  }

  @Override
  public String getWinner() {
    if (playerList.get(0).getPlayerHealth() <= 0 && playerList.get(1).getPlayerHealth() > 0) {
      return playerList.get(1).getPlayerName();
    } else if (playerList.get(1).getPlayerHealth() <= 0 && playerList.get(0).getPlayerHealth() > 0) {
      return playerList.get(0).getPlayerName();
    } else if (playerList.get(1).getPlayerHealth() == 0 && playerList.get(0).getPlayerHealth() == 0) {
      return "Its a draw";
    }
    return null;
  }

  @Override
  public void refreshArena() {
    round = 1;
    roundStatus = new StringBuilder();
    for (BattlePlayers p : playerList) {
      p.refreshGears();
      p.refreshWeapons();
      p.refreshHealth();
    }
  }

  @Override
  public String getOrderedGearList() {
    List<Gear> gearOrder;
    StringBuilder sb = new StringBuilder();
    for (BattlePlayers p : playerList) {
      gearOrder = p.getPlayerGear();
      sb.append("Player Name : " + p.getPlayerName() + " \n");
      Collections.sort(gearOrder);
      for (Gear g : gearOrder)
        sb.append("Gear Name : ").append(g.getGearName()).append(" Gear Power : ").append(g.getPower()).append(" \n");
    }
    return sb.toString();
  }

  public List<BattlePlayers> getPlayerList(){
    return playerList;
  }

}
