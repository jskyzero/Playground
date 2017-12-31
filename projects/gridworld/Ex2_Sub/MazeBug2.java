package info.gridworld.maze;

import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.spi.LocaleServiceProvider;
import java.util.Set;

import javax.swing.JOptionPane;


/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug2 extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Stack<Location> haveTravel = new Stack<Location>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown
	
	int w[] = {0, 0, 0, 0 };
	
	// direction 
	// private int direction[] = {Location.EAST, Location.SOUTH, Location.WEST, Location.NORTH};
	

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug2() {
		setColor(Color.GREEN);
		last = new Location(0, 0);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		// initial 
		if (stepCount == 0)
		{
			crossLocation.push(getValid(getLocation()));
		}
		
		boolean willMove = canMove();
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
			//increase step count when move 
			stepCount++;
		} else {
			back();
			stepCount++;
		}
	}
	
	public void back()
	{
		crossLocation.pop();
		haveTravel.pop();
		Location loc = getLocation();
		Grid<Actor> gr = getGrid();
		
		Location to = haveTravel.peek();
		int direction = loc.getDirectionToward(to);
		int tdire = to.getDirectionToward(loc);
		w[tdire/90]--;
		
		setDirection(direction);
		moveTo(to);
		
		Flower flwer = new Flower(getColor());
		flwer.putSelfInGrid(gr, loc);
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		
		ArrayList<Location> valid = new ArrayList<Location>();
		
		int dir[] = {0, 90, -90};
		for (int i = 0; i < 3; i++)
		{
			Location maybeNext = loc.getAdjacentLocation(dir[i] + getDirection());
			if (!gr.isValid(maybeNext)) 
				continue;
			
			Actor maybeNextActor = gr.get(maybeNext);
			if (maybeNextActor == null )
				valid.add(maybeNext);
			else 
			{
				if (maybeNextActor instanceof Rock && maybeNextActor.getColor().equals(new Color(255, 0, 0)))
				{
					isEnd = true;
					// valid.add(maybeNext);
					// moveTo(maybeNext);
				}				
			}
		}
		
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		// size > 0 
		return ((getValid(getLocation())).size() > 0);
	}
	
	
	
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {

		// update last 
		last = getLocation();
		
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		
		ArrayList<Location> locs = getValid(loc);
		if (crossLocation.size() == 0)
		{
			crossLocation.add(locs);
			haveTravel.add(loc);
		}
		
		Location to = locs.get(0);
		int dire = 0;
		int big = loc.getDirectionToward(locs.get(0));
		int choose = big / 90;
		for ( int i = 0; i < locs.size(); i++)
		{
			dire  = loc.getDirectionToward(locs.get(i));
			if (w[choose] < w[dire/90])
			{
				choose = dire / 90;
				to = locs.get(i);
			}
			
		}
				
		setDirection(choose * 90);
		w[choose]++;
		moveTo(to);
		crossLocation.add(getValid(to));	
		haveTravel.add(to);
	
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
