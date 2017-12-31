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
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>BlusterCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{

    private int courage;
    private final double DARKENING_FACTOR = 0.05;

    public BlusterCritter(int courage)
    {
        this.courage = courage;
    }


    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        
        ArrayList<Actor> Ans = new ArrayList<Actor>();
        int row = getLocation().getRow();
        int column = getLocation().getCol();

        for (int i = row - 2; i <= row + 2; i ++)
        {
            for (int j = row - 2; j <= column + 2; j++)
            {
                if (i == row && j == column)
                {
                    continue;
                }

                Location tempLoc = new Location(i, j);
                if (getGrid().isValid(tempLoc))
                {
                    Actor tempActor = getGrid().get(tempLoc);
                    if (tempActor != null)
                    {
                        Ans.add(tempActor); 
                    }
                }
                
            }
        }
        return Ans;
    }



    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {

        int size = 0;
        for (Actor a : actors)
        {
            if ((a instanceof Critter))
                size++;
        }

        Color c = getColor();
        int red = c.getRed();
        int green = c.getGreen();
        int blue =c.getBlue();
        if (courage <= size) 
        {
            red = (int) (red * (1 - DARKENING_FACTOR));
            green = (int) (green * (1 - DARKENING_FACTOR ));
            blue = (int) (blue * (1 - DARKENING_FACTOR ));
        } 
        else 
        {
            red = red < 255 ? red+1 : 255;
            green = green < 255 ? green+1 : 255;
            blue = blue < 255 ? blue+1 : 255;
        }
        setColor(new Color(red, green, blue));
    }
}
