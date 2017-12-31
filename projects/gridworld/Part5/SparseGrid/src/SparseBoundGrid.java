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
 * A <code>SparseBoundGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundGrid<E> extends AbstractGrid<E>
{
    // the array storing the grid elements
    private SparseBoundGridNode[] nodeArray;
    // store max column 
    private int maxColumn;

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
        nodeArray = new SparseBoundGridNode[rows];
    }

    public int getNumRows()
    {
        return nodeArray.length;
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
        ArrayList<Location> theLocations = new ArrayList<Location>();

        for (int i = 0; i < getNumRows(); i++)
        {
            SparseBoundGridNode begin = nodeArray[i];
            while (begin != null)
            {
                theLocations.add(new Location(i, begin.getCol()));
                begin = begin.getNext();
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

        SparseBoundGridNode begin = nodeArray[loc.getRow()];
        while (begin != null)
        {
            if (begin.getCol() == loc.getCol())
            {
                return (E) begin.getOccupant();
            }
            begin = begin.getNext();
        }
        return null;
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

        E oldOccupant = remove(loc);
        // Add the object to the grid.
        SparseBoundGridNode begin = nodeArray[loc.getRow()];
        nodeArray[loc.getRow()] = new SparseBoundGridNode(obj, loc.getCol(), begin);
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc))
        {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        
        // Remove the object from the grid.
        E r = null;
        SparseBoundGridNode begin = nodeArray[loc.getRow()];

        if (begin != null)
        {
            if (begin.getCol() == loc.getCol())
            {
                r = (E) begin.getOccupant();
                nodeArray[loc.getRow()] = begin.getNext();
                return r;
            }

            while (begin.getNext() != null)
            {
                if (begin.getNext().getCol() == loc.getCol())
                {
                    r = (E) begin.getNext().getOccupant();
                    begin.setNext(begin.getNext().getNext());
                    return r;
                }
                begin = begin.getNext();
            }
        }
        return r;
    }
}
