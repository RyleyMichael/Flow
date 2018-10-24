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
                //a blank space is encountered or a Node fails a constraint
                //SHOULDN'T NEED TO CHECK THE SECOND CONDITION.. BUT WE SHALL SEE
                if (puzzle[row][col].getSymbol() == '_' ||
                        checkAdjacent(puzzle, puzzle[row][col]))
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

        //only check viable Nodes i.e. values within the range of the array
        //check North
        if (node.getRowCord() - 1 > -1)
        {
            Node north = puzzle[node.getRowCord() - 1][node.getColCord()];

            //only care about Nodes of the same colors
            if (north.getSymbol() == color)
            {
                //update the number of adjacent Nodes
                adjNodes++;
            }
        }

        //check East
        if (node.getColCord() + 1 < puzzle.length - 1)
        {
            if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() == color)
            {
                adjNodes++;
            }
        }

        //check South
        if (node.getRowCord() + 1 < puzzle.length - 1)
        {
            if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() == color)
            {
                adjNodes++;
            }
        }

        //check West
        if (node.getColCord() - 1 > -1)
        {
            if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == color)
            {
                adjNodes++;
            }
        }

        //Node is a dot
        if (node.isDot())
        {
            //placement is not valid
            if (adjNodes > 1)
            {
                return false;
            }
        }

        //Node is a cell to be filled
        else if (!node.isDot())
        {
            if (adjNodes > 2)
            {
                return false;
            }
        }

        return true;
    }
}
