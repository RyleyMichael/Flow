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
        //loop through all possible color choices
        for (int i = 0; i < colors.length; i++)
        {
            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol((Character) colors[i]);
            currentNode.setSymbol((Character) colors[i]);

            //print the puzzle
            Array a = new Array();
            a.print(puzzle);

            //the placement is valid
            if (constraint.checkAdjacent(puzzle, currentNode))
            {
                //the solution is complete
                if (constraint.checkFull(puzzle))
                {
                    System.out.println("the solution is complete");
                }

                //valid but not complete
                else
                {
                    Node node = currentNode.getNext(puzzle);

                    simpleSolve(node);
                    /*
                    //not at the end of a row
                    if (currentNode.getColCord() != puzzle.length - 1)
                    {
                        currentNode = puzzle[currentNode.getRowCord()][currentNode.getColCord() + 1];
                        simpleSolve(currentNode);
                    }

                    //not on the last row
                    else if (currentNode.getRowCord() != puzzle.length - 1)
                    {
                        //move to the next row
                        currentNode = puzzle[currentNode.getRowCord() + 1][0];
                        simpleSolve(currentNode);
                    }
                    */
                }
            }

            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol('_');
            currentNode.setSymbol('_');
        }
    }
}
