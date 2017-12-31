import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class DancingBugRunner
{
    private DancingBugRunner() {}

    public static void main(String[] args)
    {
        // the magic number issue is not fixed
        // because the number can be changed any time
        ActorWorld world = new ActorWorld();

        int []aliceArray = {1, 2, 3, 4, 5};
        int []bobArray = {5, 4, 3, 2, 1};
        DancingBug alice = new DancingBug(aliceArray);
        DancingBug bob = new DancingBug(bobArray);
        alice.setColor(Color.ORANGE);

        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}