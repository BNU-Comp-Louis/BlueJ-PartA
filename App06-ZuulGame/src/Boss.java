/**
 * Class for the boss that player will fight to win game
 * 
 * @author Louis Symons
 * @version 23/01/2021
 */
public class Boss {

    private int health;
    private int dps;

    /**
     * Constructor for the class boss Give the boss Health and a damage figure.
     * 
     * @param health
     * @param dps
     */
    public Boss(int health, int dps) {
        this.health = health;
        this.dps = dps;
    }

    // Get dps amount for the boss
    public int getDps() {
        return dps;
    }

    // Get health amount for the boss
    public int getHealth() {
        return health;
    }

    // Method to check the boss health and write a message for the user if the boss
    // health reaches 0.
    public void setHealth(int playerDamage) {
        this.health -= playerDamage;
        if (health <= 0) {
            System.out.println("You Have defeated the boss, You have won and completed your quest!");
            System.exit(0);

        }
    }

}
