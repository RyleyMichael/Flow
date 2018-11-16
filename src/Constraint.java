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

    public boolean path(Node[][] puzzle, Node node)
    {
        //check if the Node is a dot or un-filled
        if (node.isDot() || node.getSymbol() == '_')
        {
            return true;
        }

        //the Node is a filled-in cell, make sure it has a path to two dots
        return true;
    }

    public boolean isValid(Node[][] puzzle)
    {
        //loop through the columns
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the rows
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //check the neighbors of each Node
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
     * @return a boolean representing whether or not the puzzle is full
     */
    public boolean isFull(Node[][] puzzle)
    {
        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        //loop through the columns
        //for (int col = 0; col < puzzle[0].length; col++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            //loop through the rows
            //for (int row = 0; row < puzzle.length; row++)
            {
                //a blank space is encountered or a Node fails a constraint
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
        boolean nonFilledAdjNodes = false;

        //only checking Nodes that have already been filled in and dots i.e. skip unfilled Nodes
        //if (color != '_') *BOTH IF STATEMENTS WORK*
        if (node.isAssigned())
        {
            //only check viable Nodes i.e. values within the range of the array
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
                    //unassigned adjacent Node found
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
                    //unassigned adjacent Node found
                    nonFilledAdjNodes = true;
                }
            }

            //check West
            if (node.getColCord() > 0) {
                if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == color)
                {
                    adjNodes++;
                }

                //check for non-filled adjacent Nodes
                if (!puzzle[node.getRowCord()][node.getColCord() - 1].isAssigned())
                {
                    //unassigned adjacent Node found
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
                    //if (adjNodes < 1 || adjNodes > 2)
                    if (adjNodes != 2)
                    //if (adjNodes > 2)
                    {
                        return false;
                    }
                }

                //the Node is a dot
                if (node.isDot())
                {
                    //number of adjacent nodes to a dot must be exactly one
                    //if (adjNodes > 1)
                    if (adjNodes != 1) {
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
