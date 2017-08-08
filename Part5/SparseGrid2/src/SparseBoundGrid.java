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

import java.util.*;

/**
 * A <code>SparseBoundGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundGrid<E> extends AbstractGrid<E>
{
    // the array storing the grid elements
    // store max column 
    private int maxRow;
    private int maxColumn;
    private Map<Location, E> occupantMap;

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in SparseBoundGrid
     * @param cols number of columns in SparseBoundGrid
     */
    public SparseBoundGrid(int rows, int cols)
    {
        if (rows <= 0)
        {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0)
        {
            throw new IllegalArgumentException("cols <= 0");
        }
        maxColumn = cols;
        maxRow = rows;
        occupantMap = new HashMap<Location, E>();
    }

    public int getNumRows()
    {
        return maxRow;
    }

    public int getNumCols()
    {
        // Note: according to the constructor precondition, numRows() > 0, so
        // theGrid[0] is non-null.
        return maxColumn;
    }

    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
            && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet())
            a.add(loc);
        return a;
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

        return occupantMap.get(loc);
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
        return occupantMap.put(loc, obj);
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
        return occupantMap.remove(loc);
    }
}
