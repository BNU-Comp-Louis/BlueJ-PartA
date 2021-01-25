package loot;

/**
 * The Sword class with allow the player to equip and use the sword
 * The sword will increase attack points
 * 
 * @Author Louis Symons
 */

public class Sword {
    
    private String name; //Sword Item 
    private int dps; //Damage of sword
    

    /**
     * Constructor of Sword class 
     */

    public Sword(String name, int dps)
    {
        this.name = name;
        this.dps = dps;

    }

    public String getName()
    {
        return this.name;
    }

    public int getDps()
    {
        return this.dps;
    }

    // This overrides string method and returns value of Sword.
    @Override
    public String toString()
    {
        return name+": "+dps+"dps";
    }

}

