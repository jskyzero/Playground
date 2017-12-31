/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
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
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * A <code>UnboundedGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class UnboundedGrid<E> extends AbstractGrid<E>
{
    private Object[][] occupantArray; // the array storing the grid elements
    private int length;

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in UnboundedGrid
     * @param cols number of columns in UnboundedGrid
     */
    public UnboundedGrid()
    {
        length = 16;
        occupantArray = new Object[length][length];
    }

    public int getNumRows()
    {
        // return occupantArray.length;
        return -1;
    }

    public int getNumCols()
    {
        // Note: according to the constructor precondition, numRows() > 0, so
        // theGrid[0] is non-null.
        // return occupantArray[0].length;
        return -1;
    }


    public boolean isValid(Location loc)
    {
        return  !(loc.getRow() < 0 || loc.getCol() < 0 );
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look at all grid locations.
        for (int r = 0; r < length; r++)
        {
            for (int c = 0; c < length; c++)
            {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, c);
                if (get(loc) != null)
                    theLocations.add(loc);
            }
        }
        return theLocations;
    }

    public E get(Location loc)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null");
        }
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        while (loc.getRow()>= length || loc.getCol() >= length)
        {
            doubleSize();
        }
        return (E) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

    public E put(Location loc, E obj)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null");
        }
        if (obj == null)
        {
            throw new NullPointerException("obj == null");
        }
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        while (loc.getRow()>= length || loc.getCol() >= length)
        {
            doubleSize();
        }

        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null");
        }
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        while (loc.getRow()>= length || loc.getCol() >= length)
        {
            doubleSize();
        }
        // Remove the object from the grid.
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }

    public void doubleSize()
    {
        Object[][] newArray = new Object[length* 2][length * 2];
        for (int r = 0; r < length; r++)
        {
            for (int c = 0; c < length; c++)
            {
                newArray[r][c] = occupantArray[r][c];
            }
        }
        occupantArray = newArray;
        length = 2 * length;
    }
}
