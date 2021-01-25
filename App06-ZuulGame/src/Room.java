import java.util.Set;
import loot.*;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via exits. For each existing exit, the room stores a reference
 * to the neighboring room.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 *          Modified by Louis Symons 19/01/2021
 */

public class Room {
    private String description;
    // String is the key to a room in that direction
    // east would be an exit that goes to the Room
    private boolean isGoldLooted;
    private boolean isThereGold;
    private HashMap<String, Room> exits;
    private boolean isBossLocated;
    private Sword sword;
    private Shield shield;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description, boolean isThereGold, Sword sword, Shield shield) {
        this.description = description;
        exits = new HashMap<>();
        isGoldLooted = false;
        this.isThereGold = isThereGold;
        isBossLocated = false;
        this.sword = sword;
        this.shield = shield;
    }

    // Method to check is the boss located and return boolean.
    public void locateBoss() {
        isBossLocated = true;
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room (the one that was defined in the
     *         constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form: You are in the kitchen. Exits:
     * north west
     * 
     * @return A long description of this room
     */
    public String getLongDescription() {
        if (isThereGold) {

            description = "You are " + description + ".\n" + getExitString() + "\n5 Gold in this room";
        } else {
            description = "You are " + description + ".\n" + getExitString();

        }
        if (sword != null) {
            description += "\n" + sword;
        } else if (shield != null) {
            description += "\n" + shield;
        }
        return description;
    }

    /**
     * Return a string describing the room's exits, for example "Exits: north west".
     * 
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();

        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    // Check if the player has looted gold.
    public boolean isGoldLooted() {
        return isGoldLooted;
    }

    // Check if the gold has been looted by the player and if the gold has been
    // looted make it unable to be looted again.
    public void setGoldLooted() {
        if (isThereGold) {
            this.isGoldLooted = true;
            isThereGold = false;
        }
    }

    // Is there gold
    public boolean getIsThereGold() {
        return isThereGold;
    }

    // Check if boss is located
    public boolean getIsBossLocated() {
        return isBossLocated;
    }

    // Remove sword
    public void removeSword() {
        sword = null;
    }

    // Remove shield
    public void removeShield() {
        shield = null;
    }

    // Get sword
    public Sword getSword() {
        return sword;
    }

    // Get shield
    public Shield getShield() {
        return shield;
    }

}
