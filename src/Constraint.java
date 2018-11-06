/**
 * Class to check that the constraints of the puzzle are not violated
 */

public class Constraint {
    //instance variables

    /**
     * Constructor
     */
    public Constraint() {

    }

    /**
     * Method to check if the entire puzzle violates any constraints
     * @param puzzle the Flow grid as a 2d Node array
     * @return a boolean representing whether or not the puzzle is full
     */
    public boolean isComplete(Node[][] puzzle)
    {
        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //a blank space is encountered or a Node fails a constraint
                if (puzzle[row][col].getSymbol() == '_' ||
                          !checkAdjacent(puzzle, puzzle[row][col]))
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
     * A newly filled-in cell needs to be adjacent to at least one cell of the same color
     *
     * @param puzzle the Flow grid as a 2d Node array
     * @param node the current node being checked
     * @return a boolean value representing whether or not the constraint is satisfied
     */
    public boolean checkAdjacent(Node[][] puzzle, Node node)
    {
        //represents the number of adjacent Nodes of the same color
        int adjNodes = 0;
        char color = node.getSymbol();

        //only check viable Nodes i.e. values within the range of the array
        //check North if not on first row
        if (node.getRowCord() > 0) {
            //only care about Nodes of the same colors
            if (puzzle[node.getRowCord() - 1][node.getColCord()].getSymbol() == color) {
                //update the number of adjacent Nodes
                adjNodes++;
            }
        }

        //check East if not on last column
        if (node.getColCord() < puzzle[0].length - 1) {
            if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() == color) {
                adjNodes++;
            }
        }

        //check South if not on last row
        if (node.getRowCord() < puzzle.length - 1) {
            if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() == color) {
                adjNodes++;
            }
        }

        //check West
        if (node.getColCord() > 0) {
            if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == color) {
                adjNodes++;
            }
        }

        //the Node is not a dot
        if (!node.isDot())
        {
            //number of adjacent nodes to a newly filled-in cell must be at least one, not greater than 2
            if (adjNodes < 1 || adjNodes > 2)
            {
                return false;
            }
        }

        //the Node is a dot
        else if (node.isDot())
        {
            //number of adjacent nodes to a dot must be exactly one
            if (adjNodes != 1)
            {
                return false;
            }
        }
        return true;
    }
}
