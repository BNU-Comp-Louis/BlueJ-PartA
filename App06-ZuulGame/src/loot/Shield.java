package loot;

/**
 * The Shield Item that can be picked up by a player This will increase the
 * health of the player when equipped
 * 
 * @author Louis Symons
 * @version 20/01/2021
 */

public class Shield {

    private String name; // Name of shield
    private int stats; // stat points of sheild

    /**
     * Constructor of shield class Name and Stats of shield.
     * 
     */

    public Shield(String name, int stats) {
        this.name = name;
        this.stats = stats;
    }

    // Get name of shield
    public String getName() {
        return this.name;
    }

    // Get stats for shield
    public int getStats() {
        return this.stats;
    }

    // This overrides string method and returns value of Shield.
    @Override
    public String toString() {
        return name + ": " + stats + "stats";
    }
}