import java.util.ArrayList;
import loot.*;

/**
 * Class player in the game. This class will hold the attributes of player, Such
 * as health and gold levels.
 * 
 * @author Louis Symons
 * @version 19/01/2021
 */

public class Player {

    private int health; // Health for the player
    private ArrayList<Object> inventory; // Items in a players inventory
    private int gold; // currency for a player
    private int damage; // damage that a player inflicts
    private Sword sword;
    private Shield shield;

    /**
     * Constructor of the class
     */

    public Player() {
        this.health = 100;
        this.gold = 0;
        this.damage = 0;
    }

    // Get health
    public int getHealth() {
        return this.health;
    }

    // Add gold and print message for the user.
    public void addGold() {
        this.gold += 5;
        System.out.println("You have looted 5 Gold!");
        System.out.println("total:" + gold);
    }

    // Get gold
    public int getGold() {
        return this.gold;
    }

    // Get damage
    public int getDamage() {
        return this.damage;
    }

    // Method to check health again boss damage and will print lost message then
    // exit game.
    public void setHealth(int bossDamage) {
        this.health -= bossDamage;
        if (health <= 0) {
            System.out.println("You Have been defeated by the boss, You have lost!");
            System.exit(0);
        }
    }

    // Picking up sword gives user a message for the sword and damage value.
    public void setSword(Sword sword) {
        this.sword = sword;
        this.damage += this.sword.getDps();
        System.out.println("The Sword has been equipped!\nDamage: " + damage);
    }

    // Picking up shield gives user a message for the shield and stats value.
    public void setShield(Shield shield) {
        this.shield = shield;
        this.health += shield.getStats();
        System.out.println("The Shield has been equipped!\nHealth: " + health);
    }
}
