/**
 * Class to represent a given space on the puzzle
 */

public class Node
{
    //instance variables
    private int rowCord;
    private int colCord;
    private boolean dot; //a dot is a starting/ending point in the maze

    /**
     * Constructor
     */
    public void Node()
    {

    }

    /**
     *
     * @return
     */
    public int getRowCord()
    {
        return rowCord;
    }

    /**
     *
     * @return
     */
    public int getColCord()
    {
        return colCord;
    }

    /**
     *
     * @return
     */
    public boolean isDot()
    {
        return dot;
    }
}
