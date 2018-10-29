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
    private Array array;

    /**
     * Constructor
     */
    public Backtrack(Node[][] puzzle, Object[] colors)
    {
        this.puzzle = puzzle;
        this.colors = colors;
        constraint = new Constraint();
        array = new Array();
    }

    /**
     * Recursive method to solve the puzzle via backtracking without a heuristic
     * @param currentNode the Node currently being tested
     *                    this is the starting Node when first called
     */
    public void simpleSolve(Node currentNode)
    {
        //loop through all possible color choices
        for (int i = 0; i < colors.length; i++)
        {
            //place a color in the current position
            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol((Character) colors[i]);
            currentNode.setSymbol((Character) colors[i]);

            //print the puzzle
            System.out.println();
            array.print(puzzle);

            //this is the general form of the algorithm... as far as i understand it
            //place a color in the current position
            //if recent placement does not violate constraints
                //if the whole board is full and constraints hold for all positions
                    //the solution is complete
                //else if the whole board is not full
                    //make a recursive call with the next position in the puzzle
            //else if the recent placement does violate constraints
                //remove the recent placement
                //try the next color at the same position

            //if recent placement does not violate constraints for the board so far i.e. board does not have to be full
            if (constraint.isValid(puzzle))
            {
                //if the whole board is full and constraints hold for all positions
                if (constraint.isComplete(puzzle))
                {
                    //complete solution
                    System.out.println("COMPLETE");
                    System.exit(0);
                }

                //else if the whole board is not full
                else
                {
                    //make a recursive call with the next position in the puzzle
                    Node node = currentNode.getNext(puzzle);
                    simpleSolve(node);
                }
            }

            //else if the recent placement does violate constraints
            else
            {
                //remove the recent placement
                puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol('_');
                currentNode.setSymbol('_');

                //try the next color at the same position
                continue;
            }

            //the placement is valid
            /*if (constraint.checkAdjacent(puzzle, currentNode))
            {
                //the solution is complete
                if (constraint.isComplete(puzzle))
                {
                    System.out.println("the solution is complete");
                }

                //valid but not complete
                else
                {
                    Node node = currentNode.getNext(puzzle);
                    simpleSolve(node);
                }
            }

            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol('_');
            currentNode.setSymbol('_');*/
        }
    }
}
