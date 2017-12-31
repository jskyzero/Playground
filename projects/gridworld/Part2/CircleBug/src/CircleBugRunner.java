import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * THis class is CircleBugRunner
 */

// remember to add final
public final class CircleBugRunner
{ 
    private CircleBugRunner() {}

    // the magic number issue is not fixed
    // because the number can be changed any time
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug(2);
        alice.setColor(Color.ORANGE);
        CircleBug bob = new CircleBug(1);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}