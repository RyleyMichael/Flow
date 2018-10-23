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
     * Method to check if the entire puzzle
     * @param puzzle the Flow grid as a 2d Node array
     * @return a boolean representing whether or not the puzzle is full
     */
    public boolean checkFull(Node[][] puzzle)
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
     *
     * @param puzzle the Flow grid as a 2d Node array
     * @param node   the current node being checked
     * @return a boolean value representing whether or not the placement is valid
     */
    public boolean checkAdjacent(Node[][] puzzle, Node node)
    {
        //represents the number of adjacent Nodes of the same color
        int adjNodes = 0;

        char color = node.getSymbol();

        //check North Node
        if (puzzle[node.getRowCord() - 1][node.getColCord()].getSymbol() == color)
        {
            //update the number of adjacent Nodes
            adjNodes++;
        }

        //check East
        if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() == color)
        {
            adjNodes++;
        }

        //check South
        if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() == color)
        {
            adjNodes++;
        }

        //check West
        if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == color)
        {
            adjNodes++;
        }

        //the placement is valid
        if ((node.isDot() && adjNodes == 1) || (!node.isDot() && adjNodes == 2))
        {
            return true;
        }

        //the placement is not valid
        else
        {
            return false;
        }
    }
}
