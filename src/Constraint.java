/**
 * Class to check that the constraints of the puzzle are not violated
 */

public class Constraint
{

    /**
     * Constructor
     */
    public Constraint()
    {

    }

    public boolean forwardCheck(Node[][] puzzle, Node node, Object[] colors)
    {
        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //skip Nodes that have been filled
                if (puzzle[row][col].getSymbol() == '_')
                //if (!puzzle[row][col].isAssigned())
                {
                    //Nodes with no valid color options fail the constraint
                    if (puzzle[row][col].getConstraintVal(puzzle, puzzle[row][col], colors) == 0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Method to determine if the current puzzle is valid i.e. the adjacent Node constraint is met for the entire puzzle
     * @param puzzle the current Flow puzzle
     * @return a boolean value; false for not valid, true for valid
     */
    public boolean isValid(Node[][] puzzle)
    {
        //loop through the columns
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the rows
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //the current Node is not valid
                if (!checkAdjacent(puzzle, puzzle[row][col]))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to check if the entire puzzle is full
     * @param puzzle the Flow grid as a 2d Node array
     * @return a boolean value; false for not full, true for full
     */
    public boolean isFull(Node[][] puzzle)
    {
        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //a blank space is encountered
                if (puzzle[row][col].getSymbol() == '_')
                {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Method to check adjacent Nodes and determine if a constraint is violated
     * The first constraint is that a filled-in cell must be adjacent to exactly TWO cells of the same color
     * The second constraint is that a dot must be adjacent to exactly ONE filled-in cell of the same color
     * @param puzzle the Flow grid as a 2d Node array
     * @param node the current node being checked
     * @return a boolean value; false for fail, true for pass
     */
    public boolean checkAdjacent(Node[][] puzzle, Node node)
    {
        //set the initial conditions
        int adjNodes = 0;
        char color = node.getSymbol();
        boolean nonFilledAdjNodes = false;

        //only checking Nodes that have already been filled in and dots i.e. skip unfilled Nodes
        //if (color != '_') *BOTH IF STATEMENTS WORK*
        if (node.isAssigned())
        {
            /* ONLY CHECK VIABLE NODES i.e. WITHIN THE RANGE OF THE ARRAY */

            //check North if not on first row
            if (node.getRowCord() > 0)
            {
                //only care about Nodes of the same colors
                if (puzzle[node.getRowCord() - 1][node.getColCord()].getSymbol() == color)
                {
                    //update the number of adjacent Nodes
                    adjNodes++;
                }

                //check for non-filled adjacent Nodes
                if (!puzzle[node.getRowCord() - 1][node.getColCord()].isAssigned())
                {
                    //unassigned adjacent Node found
                    nonFilledAdjNodes = true;
                }
            }

            //check East if not on last column
            if (node.getColCord() < puzzle[0].length - 1) {
                if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() == color)
                {
                    adjNodes++;
                }

                //check for non-filled adjacent Nodes
                if (!puzzle[node.getRowCord()][node.getColCord() + 1].isAssigned())
                {
                    nonFilledAdjNodes = true;
                }
            }

            //check South if not on last row
            if (node.getRowCord() < puzzle.length - 1) {
                if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() == color)
                {
                    adjNodes++;
                }

                //check for non-filled adjacent Nodes
                if (!puzzle[node.getRowCord() + 1][node.getColCord()].isAssigned())
                {
                    nonFilledAdjNodes = true;
                }
            }

            //check West if not on first column
            if (node.getColCord() > 0) {
                if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == color)
                {
                    adjNodes++;
                }

                //check for non-filled adjacent Nodes
                if (!puzzle[node.getRowCord()][node.getColCord() - 1].isAssigned())
                {
                    nonFilledAdjNodes = true;
                }
            }

            //only check Nodes whose adjacent Nodes are all assigned
            if (!nonFilledAdjNodes)
            {
                //no adjacent Nodes are of the same color as the Node being checked
                if (adjNodes == 0)
                {
                    return false;
                }

                //the Node is not a dot
                if (!node.isDot())
                {
                    //number of adjacent nodes to a newly filled-in cell must be at least one, not greater than 2
                    if (adjNodes != 2)
                    {
                        return false;
                    }
                }

                //the Node is a dot
                if (node.isDot())
                {
                    //number of adjacent nodes to a dot must be exactly one
                    if (adjNodes != 1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public boolean forwardChecking(Node[][] puzzle, Object[] colors)
    {
        //represents the number of adjacent Nodes of the same color
        int adjNodes;
        boolean validDomain;
        for (int row = 0; row < puzzle.length; row++){
            for (int col = 0; col < puzzle[row].length; col++){
                if (puzzle[row][col].getSymbol() == '_') {
                    validDomain = false;
                    for (Object color : colors) {
                        adjNodes = 0;
                        //only check viable Nodes i.e. values within the range of the array
                        //check North if not on first row
                        if (row > 0) {
                            //only care about Nodes of the same colors
                            if (puzzle[row - 1][col].getSymbol() == (char)color) {
                                //update the number of adjacent Nodes
                                adjNodes++;
                            }
                        }

                        //check East if not on last column
                        if (col < puzzle[0].length - 1) {
                            if (puzzle[row][col + 1].getSymbol() == (char)color) {
                                adjNodes++;
                            }
                        }

                        //check South if not on last row
                        if (row < puzzle.length - 1) {
                            if (puzzle[row + 1][col].getSymbol() == (char)color) {
                                adjNodes++;
                            }
                        }

                        //check West
                        if (col > 0) {
                            if (puzzle[row][col - 1].getSymbol() == (char)color) {
                                adjNodes++;
                            }
                        }

                        if(puzzle[row][col].isDot()) {
                            if (adjNodes < 1){
                                validDomain = true;
                            }
                        }
                        else{
                            if (adjNodes < 2){
                                validDomain = true;
                            }
                        }
                    }
                    if (!validDomain)
                        return false;
                }
            }
        }
        return true;
    }
}
