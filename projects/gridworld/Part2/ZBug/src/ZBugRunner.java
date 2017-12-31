import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class ZBugRunner
{
    private ZBugRunner() {}
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        ZBug alice = new ZBug(2);
        alice.setColor(Color.ORANGE);
        ZBug bob = new ZBug(3);
        world.add(new Location(0, 0), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}