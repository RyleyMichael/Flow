/**
 * Class to solve the Flow puzzle via backtracking
 * This class implements a simple backtracking method and one with a heuristic function
 */

public class Backtrack
{

    //instance variables
    private Node[][] puzzle;
    private Object[] colors;
    private Constraint constraint;

    /**
     * Constructor
     */
    public Backtrack(Node[][] puzzle, Object[] colors)
    {
        this.puzzle = puzzle;
        this.colors = colors;
        constraint = new Constraint();
    }

    /**
     * Recursive method to solve the puzzle via backtracking without a heuristic
     * @param currentNode the Node currently being tested
     *                    this is the starting Node when first called
     */
    public void simpleSolve(Node currentNode)
    {






        /*
        //loop through all possible color choices, but keep trying the same color until it *fails*
        for (int i = 0; i < puzzle.length; i++)
        {
            //place a color in the current position
            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol((Character) colors[i]);

            //the placement is valid
            if (constraint.checkAdjacent(puzzle, currentNode))
            {
                //the solution is complete
                if (constraint.checkFull(puzzle))
                {
                    System.out.println("the solution is complete");
                }

                //valid but not complete?
                else
                {
                    //reached the end of a row
                    if (currentNode.getColCord() == puzzle.length - 1)
                    {
                        //solve by moving to the next row
                        simpleSolve();
                    }

                    //reached the end of the maze
                    else if (true)
                    {

                    }
                }
            }

            //the placement is not valid, we want to try the next color at this position


            //update start by one if we haven't reached the end of the array
        }
        */
    }
}
