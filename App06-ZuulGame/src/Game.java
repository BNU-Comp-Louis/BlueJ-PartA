import java.util.Scanner;
import loot.*;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 *          Modified and extended by Derek and Andrei
 *          Modified by Louis Symons
 *          By 20/01/2021
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Map map;
    private Player player;
    private Scanner reader;
    private final Boss BOSS = new Boss(100, 10);

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        reader = new Scanner(System.in);
        map = new Map();
        parser = new Parser();
        currentRoom = map.getOUTSIDE_CASTLE();
        player = new Player();
        play();

    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printDescription();
        printWelcome();
        

        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case PICKUP:
                pickup(command);
                break;

            case BUY:
                wantToQuit = quit(command);
                break;

            case ATTACK:
                attack();
                break;

        }
        return wantToQuit;
    }

    // implementations of user commands:

    private void attack() {
        if (currentRoom.getIsBossLocated()) {
            while (true) {
                BOSS.setHealth(player.getDamage());
                player.setHealth(BOSS.getDps());
            }
        } else {
            System.out.println("The boss has to be spawned!");
        }
    }

    private void pickup(Command command) {
        if (command.getSecondWord() == null) {
            System.out.println("The Item cannot be found");
        } else if (command.getSecondWord().toLowerCase().equals("gold")) {

            if (currentRoom.getIsThereGold()) {
                player.addGold();
                currentRoom.setGoldLooted();
            } else {
                System.out.println("Nothing to pick up in this Area!");
            }
        } else if (command.getSecondWord().toLowerCase().equals("sword")) {
            Sword sword = currentRoom.getSword();
            player.setSword(sword);
            currentRoom.removeSword();
        } else if (command.getSecondWord().toLowerCase().equals("shield")) {
            Shield shield = currentRoom.getShield();
            player.setShield(shield);
            currentRoom.removeShield();
        } else {
            System.out.println("The Item cannot be found");
        }
    }

    /**
     * Print out some help information. Here we print some stupid, cryptic message
     * and a list of the command words.
     */
    private void printHelp() {
        System.out.println("You are in a Castle, find the Gold, Kill the Boss!");
        System.out.println("around at Castle.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        /**
         * This method checks the players gold amount in order to spawn the boss. 
         * It also will ask the user input if they wish to start the boss encounter.
         */
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if (nextRoom.equals(map.getPORTAL_ROOM())) {
            int playerGoldAmount = player.getGold();
            if (playerGoldAmount < 20) {
                System.out.println("20 gold must be collected to spawn boss");
            } else {
                currentRoom = nextRoom;

                if (!currentRoom.getIsBossLocated()) {

                    System.out.println("Offer your gold to spawn boss? (y/n)");
                    while (true) {
                        System.out.print("> ");
                        String answer = reader.nextLine();
                        if (answer.toLowerCase().equals("y")) {
                            currentRoom.locateBoss();
                            System.out.println("The boss has been spawned!");
                            break;
                        } else if (answer.toLowerCase().equals("n")) {
                            System.out.println(currentRoom.getLongDescription());
                            break;
                        }
                    }
                } else {
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println("Kill the Boss to win the game!");
                }
            }
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we really
     * quit the game.
     * 
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true; // signal that we want to quit
        }
    }

    /**
     * Description of the game for the user.
     */
    private void printDescription() {

        System.out.println("Hello Adventurer, the castle you have approached needs help!");
        System.out.println("Your quest should you wish to accept it");
        System.out.println("Explore the Castle to find the treasures within");
        System.out.println("You must then summon and defeat the Boss to complete your quest");
        System.out.println("The boss requires a gold offering to be spawned so check every room");
        System.out.println("Good luck adventurer...");

    }
}