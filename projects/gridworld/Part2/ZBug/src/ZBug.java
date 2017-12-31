import info.gridworld.actor.Bug;

/**
 * A <code>ZBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private boolean needTurn;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        needTurn = true;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (needTurn)
        {
            int direction =  steps == sideLength  ? 225 : 90;
            turnToDirectiom(direction);
        } else {
            runLine();
        }
    }

    /**
     * turn to 'Z'  direction
     */
    public void turnToDirectiom(int direction)
    {
        if ( getDirection() == direction )
        {
            needTurn = false;
        } else {
            turn();
        }
    }

    /**
     * move at one line 
     */
    public void runLine()
    {
        if (canMove() && steps < 3 * sideLength)
        {
            move();
            steps++;

            if (steps % sideLength == 0)
            {
                needTurn = true;
            }
        }
    }
}
