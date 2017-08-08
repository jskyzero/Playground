import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public final class SpiralBugRunner
{
    private SpiralBugRunner() {}
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        SpiralBug alice = new SpiralBug(2);
        SpiralBug bob = new SpiralBug(1);
  
        alice.setColor(Color.ORANGE);

        world.add(new Location(9, 9), alice);
        world.add(new Location(0, 0), bob);

        world.show();
    }
}