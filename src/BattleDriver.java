import java.util.Scanner;

import BattleProject.BattleGame;
import BattleProject.Game;
import BattleProject.RandomNumberGenerateSource;
import BattleProject.RandomNumbersGenerator;

/**
 * Driver class to implement the functionality of the Jumptastic Game's
 * new Battle game with default and user provided data.
 */
public class BattleDriver {

    /**
     * Main method to run the program with sample data.
     * @param args argument for main method.
     */
  public static void main(String[] args){
      RandomNumbersGenerator randomVariable = new RandomNumberGenerateSource();
      Game battle = new BattleGame(randomVariable);
      Scanner sc = new Scanner(System.in);
      boolean isGameOn = true;
      String rematch;
      System.out.println("---------------Welcome to the Battle Arena---------------------");
      System.out.println("-------------Waiting for the players to join in ---------------");
      System.out.println(battle.initializeBattle("Player1","Player2"));
      while(isGameOn){
          System.out.println("-------------Equipping players with Gears----------------------");
          System.out.println(battle.equipPlayersWithGear());
          System.out.println(battle.requestPlayerWeapons());
          System.out.println(battle.getOrderedGearList());
          System.out.println("-------------------- Starting the Battle------------------------");
          String strikingPlayer = battle.getStrikingPlayer();
          String result = battle.startRound(strikingPlayer);
          System.out.println(result);
          System.out.println("The Winner is ------------> "+ battle.getWinner());
          System.out.println("\n ------Do you want to play again? yes/no -----------");
          rematch = sc.nextLine();
          if(!rematch.equalsIgnoreCase("yes")){
              isGameOn = false;
          }else{
              System.out.println(" Starting a Rematch");
              battle.refreshArena();
          }
      }
  }
}
