package battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BattleGame class implements the methods in interface Game.
 * All the functionality to be performed in a battle arena is
 * present in the BattleGame class.
 */
public class BattleGame implements Game {
  private final RandomNumbersGenerator randomVariable;
  BattleInventory gears;
  int round = 1;
  StringBuilder roundStatus = new StringBuilder();
  private List<BattlePlayers> playerList;


  /**
   * Constructor to initialize a new battle. Initializes empty list
   * for new players to be added.
   *
   * @param randomVariable Random variable to be used for assigning
   *                       weapons, gears and abilities to the players.
   * @throws IllegalArgumentException Throws the exception
   *                                  when provided random variable is null.
   */
  public BattleGame(RandomNumbersGenerator randomVariable) {
    if (randomVariable == null) {
      throw new IllegalArgumentException("Random Variable can not be null");
    }
    if (playerList == null) {
      playerList = new ArrayList<>();
    }
    this.randomVariable = randomVariable;
  }

  @Override
  public String initializeBattle(String player1, String player2) {
    if (player1 == (null) || player2 == (null)) {
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
      p.setTempStrength(p.getPlayerStrength() + updateHealth(Ability.STRENGTH, p));
      p.setTempCharisma(p.getPlayerCharisma() + updateHealth(Ability.CHARISMA, p));
      p.setTempConstitution(p.getTempConstitution() + updateHealth(Ability.CONSTITUTION, p));
      p.setTempDexterity(p.getPlayerDexterity() + updateHealth(Ability.DEXTERITY, p));
      p.updatePlayerHealth(p.getTempCharisma() + p.getPlayerDexterity()
              + p.getTempConstitution() + p.getTempStrength());
      int avoidanceAbility = p.getTempDexterity() + p.getPlayerDexterity();
      int strikingPower = p.getTempConstitution() + p.getPlayerConstitution();
      p.setBattleAbilities(strikingPower, avoidanceAbility);
    }
  }

  /**
   * Helper method to calculate the total abilities that can be
   * affected by a gear.
   *
   * @return sum total power of all the gears providing
   *          certain ability.
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

  /**
   * Starts the battle.
   * It sets up the striking and opponent player and calls helper method start round
   * for starting the rounds.
   * It makes a recursive call until the game finds a winner or there is a draw.
   * It returns the game round details to the driver class.
   *
   * @param playerName Player Name
   * @return String of result output ot print
   * @throws IllegalArgumentException If player name is invalid.
   */
  @Override
  public String startBattle(String playerName) {
    if ((playerName == null) || (playerName.equals(""))) {
      throw new IllegalArgumentException("Invalid playerName");
    }
    BattlePlayers strikingPlayer;
    BattlePlayers opponentPlayer;

    if (playerList.get(0).getPlayerName().equals(playerName)) {
      strikingPlayer = playerList.get(0);
      opponentPlayer = playerList.get(1);
    } else {
      strikingPlayer = playerList.get(1);
      opponentPlayer = playerList.get(0);
    }

    if ((strikingPlayer.getPlayerHealth() > 0) && (opponentPlayer.getPlayerHealth() > 0)) {
      roundStatus.append("-------------------------------\n Round ")
              .append(round).append(" \n-------------------------------\n");
      roundStatus.append("Striking Player: ").append(strikingPlayer.getPlayerName())
              .append(" \nOpponent Player: ").append(opponentPlayer.getPlayerName()).append("\n");
      startRound(strikingPlayer, opponentPlayer);
      if (round > 1000) {
        if (strikingPlayer.getPlayerHealth() > opponentPlayer.getPlayerHealth()) {
          roundStatus.append("******\n Winner is ")
                  .append(strikingPlayer.getPlayerName()).append("\n********\n");
        } else if (strikingPlayer.getPlayerHealth() < opponentPlayer.getPlayerHealth()) {
          roundStatus.append("******\n Winner is ")
                  .append(opponentPlayer.getPlayerName()).append("\n********\n");
        } else {
          roundStatus.append("******\n Its A Draw \n********\n");
        }
        return roundStatus.toString();

      }
      startBattle(opponentPlayer.getPlayerName());

    } else {
      String winner;
      if (strikingPlayer.getPlayerHealth() <= 0) {
        winner = opponentPlayer.getPlayerName();
      } else {
        winner = strikingPlayer.getPlayerName();
      }
      roundStatus.append("******\n Winner is ")
              .append(winner).append("\n********\n");
    }

    return roundStatus.toString();
  }


  /**
   * Start round represents the one round between players.
   * It calculates the striking power and avoidance ability and checks if the player can strike,
   * it then calculates potential striking damage and actual damage. If actual damage is greater
   * than 0 then the opponent takes damage and its health is updated.
   * If the striking power and avoidance abilities are equal the match is a draw and boolean
   * value is returned indicating the same.
   *
   * @param strikingPlayer Striking player
   * @param opponentPlayer Opponent Player
   * @return Boolean for Draw
   */
  private void startRound(BattlePlayers strikingPlayer, BattlePlayers opponentPlayer)
          throws IllegalArgumentException {
    if (strikingPlayer == null || opponentPlayer == null) {
      throw new IllegalArgumentException("Player name is null");
    }
    if (strikingPlayer.getPlayerName() == opponentPlayer.getPlayerName()) {
      throw new IllegalArgumentException("Both strike and oponent player can't be equal");
    }

    //set strike power and avoidance ability.
    int strikePower = strikingPlayer.getPlayerStrikingPower() + getRandomVariable(1, 10);
    int avoidanceAbility = opponentPlayer.getPlayerAvoidanceAbility() + getRandomVariable(1, 6);
    // player info
    roundStatus.append("Striking Player: ").append(strikingPlayer.getPlayerName())
            .append(" Striking Power: ").append(strikePower)
            .append(" Striking Player Health: ").append(strikingPlayer.getPlayerHealth())
            .append("\n");
    roundStatus.append("Opponent Player: ").append(opponentPlayer.getPlayerName())
            .append(" Avoidance Power: ").append(avoidanceAbility).append(" Opponent Health: ")
            .append(opponentPlayer.getPlayerHealth()).append("\n");
    // checks if player can strike
    if (strikePower > avoidanceAbility) {
      //Strike for each weapon
      for (Weapon w : strikingPlayer.getWeapon()) {
        roundStatus.append("* ").append(strikingPlayer.getPlayerName())
                .append(" strikes ").append(opponentPlayer.getPlayerName()).append("*\n");
        //calculate weaponDamage
        int weaponDamage = getRandomVariable(w.getMinimumDamage(), w.getMaximumDamage());
        if ((w.getType().equals("Flail") && strikingPlayer.getPlayerDexterity() <= 14)
                || (w.getType().equals("TwoHandedSword")
                && strikingPlayer.getPlayerStrength() <= 14)) {
          weaponDamage = weaponDamage / 2;
        }
        roundStatus.append(" Weapon Damage").append(weaponDamage).append("\n");
        int potentialStrikingDamage = strikingPlayer.getTempStrength() + (int) weaponDamage;
        roundStatus.append(" PotentialStrikingDamage ").append(potentialStrikingDamage)
                .append("\n");
        int actualDamage = potentialStrikingDamage - opponentPlayer.getTempConstitution();
        roundStatus.append(" ActualDamage ").append(actualDamage).append("\n");
        //if actual damage is greater that 0 than opponent takes damage
        if (actualDamage > 0) {
          opponentPlayer.updatePlayerHealth(opponentPlayer.getPlayerHealth() - actualDamage);
        }
      }
    }

    round = round + 1;

  }


  @Override
  public String getWinner() {
    if (playerList.get(0).getPlayerHealth() <= 0 && playerList.get(1).getPlayerHealth() > 0) {
      return playerList.get(1).getPlayerName();
    } else if (playerList.get(1).getPlayerHealth() <= 0
            && playerList.get(0).getPlayerHealth() > 0) {
      return playerList.get(0).getPlayerName();
    } else if (playerList.get(1).getPlayerHealth() == 0
            && playerList.get(0).getPlayerHealth() == 0) {
      return "Its a draw";
    } else {
      if (playerList.get(0).getPlayerHealth() > playerList.get(1).getPlayerHealth()) {
        return playerList.get(0).getPlayerName();
      } else {
        return playerList.get(1).getPlayerName();
      }

    }
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
      for (Gear g : gearOrder) {
        sb.append("Gear Name : ").append(g.getGearName())
                .append(" Gear Power : ").append(g.getPower()).append(" \n");
      }
    }
    return sb.toString();
  }

  public List<BattlePlayers> getPlayerList() {
    return playerList;
  }

}
