import info.gridworld.actor.Bug;

/**
 * A <code>DancingBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class DancingBug extends Bug
{
    private int steps;
    private int[] sideTurnTimesArray;
    private boolean needTurn;
    private int trunTimes;

    /**
     * Constructs a box bug that traces a square of a given side turnTimesArray
     * @param turnTimesArray the side turnTimesArray
     */
    public DancingBug(int []turnTimesArray)
    {
        steps = 0;
        needTurn = true;
        trunTimes = 0;

        if (turnTimesArray == null) 
        {
            sideTurnTimesArray = new int[0];
        } else 
        {
            sideTurnTimesArray = turnTimesArray.clone();
        }

    }

    /**
     * do the next action 
     */
    public void act()
    {
        if (needTurn)
        {
            turnToDirectiom();
        } else {
            runLine();
        }
    }

    /**
     * turn Direction and check if is finished 
     */
    public void turnToDirectiom()
    {
        if ( trunTimes == sideTurnTimesArray[steps%sideTurnTimesArray.length] )
        {
            needTurn = false;
            trunTimes = 0;
        } else {
            turn();
            trunTimes++;
        }
    }

    /**
     * move at one line
     */
    public void runLine()
    {
        if (canMove())
        {
            move();
            steps++;
            needTurn = true;
        }
    }
}
