import loot.*;

/**
 * Map class to create room and set a start point for the player.
 * 
 * @author Louis Symons
 * @version 22/01/2021
 */

public class Map {

    private final Room OUTSIDE_CASTLE = new Room("outside the entrance of a old castle", true, null, null);
    private final Room COURTYARD = new Room("in the main courtyard", true, null, null);
    private final Room TAVERN = new Room("in the castle's Tavern", false, null, null);
    private final Room KITCHEN = new Room("in the castle's kitchen", false, null, new Shield("Round Shield", 100));
    private final Room CELLAR = new Room("in the damp Cellar", true, null, null);
    private final Room PORTAL_ROOM = new Room("in the Portal Room where the boss can be spawned", false, null, null);
    private final Room ARMORY = new Room("in the Armory", false, new Sword("Long Sword", 100), null);
    private final Room BARRACKS = new Room("in the barracks", true, null, null);

    public Map() {
        setExits();
    }

    // Set the exits for the player in each room.
    private void setExits() {
        OUTSIDE_CASTLE.setExit("west", COURTYARD);

        COURTYARD.setExit("north", OUTSIDE_CASTLE);
        COURTYARD.setExit("east", KITCHEN);
        COURTYARD.setExit("south", TAVERN);
        COURTYARD.setExit("west", ARMORY);

        TAVERN.setExit("north", COURTYARD);

        KITCHEN.setExit("west", COURTYARD);
        KITCHEN.setExit("south", CELLAR);

        CELLAR.setExit("north", KITCHEN);
        CELLAR.setExit("south", PORTAL_ROOM);

        PORTAL_ROOM.setExit("east", CELLAR);
        PORTAL_ROOM.setExit("west", BARRACKS);

        BARRACKS.setExit("north", ARMORY);
        BARRACKS.setExit("west", PORTAL_ROOM);

        ARMORY.setExit("east", COURTYARD);
        ARMORY.setExit("south", BARRACKS);

    }

    public Room getOUTSIDE_CASTLE() {
        return OUTSIDE_CASTLE;
    }

    public Room getCOURTYARD() {
        return COURTYARD;
    }

    public Room getTAVERN() {
        return TAVERN;
    }

    public Room getKITCHEN() {
        return KITCHEN;
    }

    public Room getCELLAR() {
        return CELLAR;
    }

    public Room getPORTAL_ROOM() {
        return PORTAL_ROOM;
    }

    public Room getARMORY() {
        return ARMORY;
    }

    public Room getBARRACKS() {
        return BARRACKS;
    }

}
