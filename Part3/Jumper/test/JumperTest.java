import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.ActorWorld;


public class JumperTest
{
	private static Bug bug = new Bug();
	private static Rock rock = new Rock();
	private static Flower flower = new Flower();
	private static Jumper jumper = new Jumper();
	private static ActorWorld world = new ActorWorld();

	@BeforeClass
	public static void initial() throws Exception {
		world.add(bug);
		world.add(rock);
		world.add(flower);
		world.add(jumper);
	}

	@Before
	public void resetPosition() throws Exception {
		Location loc = new Location(0, 0);
		jumper.moveTo(loc);
		jumper.setDirection(Location.NORTH);
		loc = new Location(9, 0);
		bug.moveTo(loc);
		bug.setDirection(Location.NORTH);
		loc = new Location(0, 9);
		flower.moveTo(loc);
		flower.setDirection(Location.NORTH);
		loc = new Location(9, 9);
		rock.moveTo(loc);
		rock.setDirection(Location.NORTH);
	}

	@Test 
	public void test0_0_W()
	{
		Location loc = new Location(0, 0);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
	}

	@Test 
	public void test0_1_W()
	{
		Location loc = new Location(1, 0);
		jumper.moveTo(loc);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
		jumper.act();
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTHEAST, jumper.getDirection());
	}

	@Test 
	public void test2_0_W()
	{
		Location loc = new Location(2, 0);
		jumper.moveTo(loc);
		assertEquals(true, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
		jumper.act();
		loc = new Location(0, 0);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
	}

	@Test
	public void test2_0_W_Rock()
	{
		Location loc = new Location(2, 0);
		jumper.moveTo(loc);
		loc = new Location(0, 0);
		rock.moveTo(loc);
		loc = new Location(2, 0);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
		jumper.act();
		loc = new Location(2, 0);
		assertEquals(true, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTHEAST, jumper.getDirection());
		jumper.act();
		loc = new Location(0, 2);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTHEAST, jumper.getDirection());
		loc = new Location(9, 9);
		rock.moveTo(loc);
	}

	@Test
	public void test2_0_W_Flower()
	{
		Location loc = new Location(2, 0);
		jumper.moveTo(loc);
		loc = new Location(0, 0);
		flower.moveTo(loc);
		loc = new Location(2, 0);
		assertEquals(true, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
		jumper.act();
		loc = new Location(0, 0);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTH, jumper.getDirection());
		jumper.act();
		loc = new Location(0, 0);
		assertEquals(false, jumper.canMove());
		assertEquals(loc, jumper.getLocation());
		assertEquals(Location.NORTHEAST, jumper.getDirection());
		
		flower = new Flower();
		world.add(flower);
	}
}


// in shell you can use 
// javac -classpath .:junit-4.9.jar JumperTest.java
// java -classpath .:junit-4.9.jar -ea org.junit.runner.JUnitCore JumperTest
