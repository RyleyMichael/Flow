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
    private Node initial;
    private int dumbCount;
    private int smartCount;

    /**
     * Constructor
     */
    public Backtrack(Node[][] puzzle, Object[] colors)
    {
        this.puzzle = puzzle;
        this.colors = colors;
        constraint = new Constraint();
        array = new Array();
        initial = puzzle[0][0];
        dumbCount = 0;
        smartCount = 0;
    }

    /**
     * Recursive method to solve the puzzle using simple backtracking
     * @return a 2d array of Nodes, representing the solution
     */
    public Node[][] dumbSolve()
    {
        //the puzzle is full
        if (constraint.isFull(puzzle))
        {
            //solution found
            return puzzle;
        }

        //retrieve the next Node to be checked
        Node nextNode = initial.getNext(puzzle);

        //loop through all color choices
        for (Object color : colors)
        {
            //try a color at the current position and mark it assigned
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol((Character) color);
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(true);
            dumbCount++;

            //print for testing
            /*System.out.println();
            array.print(puzzle);
            System.out.println("Current Node: " + puzzle[nextNode.getRowCord()][nextNode.getColCord()]);*/

            //the placement is valid
            if (constraint.isValid(puzzle))
            {
                //recursive call
                Node[][] solution = dumbSolve();

                //the placement is non-null and valid
                if (solution != null && constraint.isValid(puzzle))
                {
                    //solution found
                    return solution;
                }
            }
            //reset the placement
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol('_');
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(false);
        }
        return null;
    }

    /**
     * Recursive method to solve the puzzle using advanced backtracking
     * @return a 2d Node array, representing the solution
     */
    public Node[][] smartSolve()
    {
        //the puzzle is full
        if (constraint.isFull(puzzle))
        {
            //solution found
            return puzzle;
        }

        //retrieve the most constrained Node
        Node nextNode = initial.getNext(puzzle);
        //Node nextNode = initial.getMCN(puzzle);

        //loop through all color choices
        for (Object color : colors)
        {
            //try a color at the current position and mark it assigned
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol((Character) color);
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(true);
            smartCount++;

            //print for testing
            /*System.out.println();
            array.print(puzzle);
            System.out.println("Current Node: " + puzzle[nextNode.getRowCord()][nextNode.getColCord()]);*/

            //the placement is valid
            if (constraint.isValid(puzzle))
            {
                //the placement passes forward checking
                if(constraint.forwardChecking(puzzle, colors))
                {
                    //recursive call
                    Node[][] solution = smartSolve();

                    //the placement is non-null and valid
                    if (solution != null && constraint.isValid(puzzle))
                    {
                        //solution found
                        return solution;
                    }
                }
            }
            //reset the placement
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol('_');
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(false);
        }
        return null;
    }

    /**
     * Method to return the number of attempted assignments by simple backtracking
     * @return an integer value
     */
    public int getDumbCount()
    {
        return dumbCount;
    }

    /**
     * Method to return the number of attempted assignments by advanced backtracking
     * @return an integer value
     */
    public int getSmartCount()
    {
        return smartCount;
    }
}
