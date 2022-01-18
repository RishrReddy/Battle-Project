![Jumptastic Game](https://cdn.mos.cms.futurecdn.net/yxzL239hqVPrBgEUyGrYEB.jpg)

  <p align="center">
    <strong>Welcome to Jumptastic Games!!!</strong>
</p>
<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#list-of-features">List Of Features</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#how-to-run">How to Run</a></li>
        <li><a href="#installation">How to Use Program</a></li>
      </ul>
    </li>
    <li><a href="#Description">Description of Examples</a></li>
    <li><a href="#assumptions">Assumptions</a></li>
    <li><a href="#limitations">Limitations</a></li>
     <li><a href="#design-and-model-changes">Design and Model Changes</a></li>
    <li><a href="#citations">Citations</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

**Jumpstastic Games** launches a new role playing game while relies a lot on your luck and ability
to withstand opponent player's abilities. The main motive of the project is providing you a whole
new experience of being in an arena battling with your opponent.Let's dive in.

The battle in the game happens as follows:

* First the game starts with initializing a new battle between two players.
* The two players are assigned names and personal abilities like charisma, dexterity, strength, and
  constitution. The abilities you get are completely random based on 4 dice rolls.
* Now each player is assiged with 20 gears consisting of Headgears, Belts, Potions and Footwear.

``` 
    Headgear is worn on the player's head and affects the player's constitution. Since a player has one head, they can only wear one piece of headgear.

    Potions are consumed by the player before entering the field of battle. They can temporarily affect any of the player's abilities. There is no limit to the number of these that the player can drink.

    Belts come in three sizes -- small, medium, and large -- and are worn around the player's torso affecting up to two of the player's abilities. Players have the ability to wear 10 "units" of belts where small belts count as 1 unit, medium as 2 units, and large as 4 units.

    Footwear is worn on the player's feet and affects the player's dexterity. Footwear always comes in pairs and a player can only wear one piece of footwear at a time.
```

* Once the gears are assigned player gets assigned with a weapon on request.
* There are three types of weapons - swords, axes and flails.

```
Swords come in three varieties:
    Katanas are lightweight curved swords that come in pairs. They can do a base of 4-6 points of damage when they hit. They are so light that a player can carry two of them (which attack separately).

    Broadswords are a good medium weapon that can do 6-10 points of damage when they hit.
    
    Two-handed swords are a heavy sword that can only be effectively wielded by players with strength greater than 14, but they can do 8-12 points of damage when they hit.
    If the player does not have the strength to wield a two-handed sword, the sword only does half damage.

Axes are great general weapons doing 6-10 points of damage when they hit.

Flails are also great general weapons but they can only be effectively wielded by players with a dexterity greater than 14. They do 8-12 points of damage when they hit. If the player does not have the dexterity to wield a flail, the flail only does half damage.
```

* After the weapons are assigned, a striking player is decided amongst both the players based on the
  value of the charisma, the player with maximum charisma gets to hit first.
* The game continue untill ome of the player's health goes below 0.
* User can opt for the rematch and start a new game again.

<!-- List of Features -->

## List of Features

The project Jumstastic Games provides following features/benefits to the user:

* It provides user ability to restart a game with the same opponent and also retains initial
  abilities.
* Gives status of the player after every strike with current abilities.
* Provides the list of gears a player is equipped with.
* Provides the information of weapon wielded by the player.
* Provides the list of gears in top to bottom order showing all the head gears, portions, belts and
  footwear in the same order.

<!-- Getting Started -->

## Getting Started

### How to Use

The folder structure of the project basically contains three directories.

* src directory contains all the interfaces and the classes.
* test directory contains all the test cases for every class's public methods.
* res directory contains docs, jar file, and manifests

User can <a href="#run-the-jar"> run the jar file </a> directly or use the driver class to execute
the project.

<!-- run-the-jar -->

### How to Run

<strong><u> Running Using A Jar File </u></strong>

To run the jar file use the following command in the terminal.

```
java -jar <jarName> 
```

The jar file added in the res folder is name Monkey_Project.jar .

<strong> <u> Running Driver Class </u> </strong>

Navigate to src/driver directory. You will find a **BattleDriver** class with main method in it.
Right click and Run the program.

<!-- Description of Examples-->

## Description of Examples

As a sample dry run, I have executed the program .

<b><i> Run 1 (Run_1.txt file can be found in res folder) </i></b>

In this run the following steps are executed:

1. Battle is initiated with two players (Player1, Player2) by calling battle.initializeBattle("Player1", "Player2").
2. Players are assigned with basic abilities in the initialization itself.
3. Players get equipped with the gears by calling battle.equipPlayersWithGear() method.
4. Players request for the weapons using battle.requestPlayerWeapons() method.
5. PLayer who would get the first strike is determined based on the charisma values.
6. Players now start the battle using battle.startBattle(strikingPlayer).
7. After the match the winner is printed.
8. Sorted listed of gears is also printed in top to bottom order by calling battle.getOrderedGearList().
9. Prompt for user input on rematch is asked after the battle ends and the loop continues.


<!-- Assumptions -->

## Assumptions

To successfully implement the project, the following assumptions have been made

1. Every gear updates the abilities by a random number in the range of 1-6.
2. The basic abilities of constitution, dexterity, strength and charisma remain same for a player in
   a rematch.
3. When 2 players have same charishma, player 2 will get to strike first.
4. For user input only when user enter a "yes" a rematch starts, for every other entry the program gterminates.
5. The program stops executing when the striked go over 1000 and the player with greater health value is declared as winner.
6. The different types of swords and gears are maintained as classes and not enums assuming the fact that there might be additions in future. In that case it is easier to add classes than edit the enums.
<!-- Limitations -->

## Limitations

1. There might be many strikes before a player is declared as winner.(Possible to be greater than
   1000 also).
2. Testing Randomness of the variables might not be very effective since it's not always easy to
   replicate the random variables generated while executing the program.

<!-- Design and Model Changes -->

## Design and Model Changes

* The design and UML diagram can be found in the res folder.
* Based on the discussions with instructor, few classes/ interfaces have been eliminated.
* Chose to use classes over enums for weapons as classes are easier to craete if there are new
  weapons to be added later.

<!-- Citations -->

## Citations

1. [Testing Random Generator numbers](https://softwareengineering.stackexchange.com/questions/356456/testing-a-function-that-uses-random-number-generator)
2. [JavaDoc for Using Randon Integer generator](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)

<!-- Contact -->

## Contact

```
Name : Rishita Reddy
Email : reddy.ri@northeatern.edu
Project Link: https://github.com/RishrReddy/Monkey-Project.git
```