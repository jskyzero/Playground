/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>QuickCrab</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : get2LocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
            {
                // System.out.println(loc.toString());
                locs.add(loc);
            }
        if (locs.size() > 0)
        {
            return locs;
        }
        else
            return super.getMoveLocations();
    }

    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> get2LocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);

            if (gr.isValid(neighborLoc) && getGrid().get(neighborLoc) == null)
            {
                Location targetLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
                if (gr.isValid(targetLoc))
                {
                    // System.out.println(targetLoc.toString());
                    locs.add(targetLoc);
                }
                    
            }
        }
        return locs;
    } 
}
