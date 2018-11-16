/**
 * Class to represent a given position in the puzzle
 */

public class Node
{
    //instance variables
    private int rowCord;
    private int colCord;
    private char symbol;
    private boolean dot; //a dot is a starting/ending point in the maze
    private boolean assigned;

    /**
     * Constructor
     */
    public Node(int rowCord, int colCord, char symbol)
    {
        this.rowCord = rowCord;
        this.colCord = colCord;
        this.symbol = symbol;
    }

    /**
     * Method to return whether or not a Node is assigned
     * @return boolean value, true for assigned, false for not assigned
     */
    public boolean isAssigned()
    {
        return assigned;
    }

    /**
     * Method to set the assign value of a Node
     * @param assigned boolean value
     */
    public void setAssigned(boolean assigned)
    {
        this.assigned = assigned;
    }

    /**
     * Method to get the next Node to be tested
     * @param puzzle a 2d Node array representing the Flow puzzle
     * @return the next Node that is not a dot
     *          'next' in this case means moving East
     */
    public Node getNext(Node[][] puzzle)
    {
        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            {
                if (!puzzle[row][col].isAssigned())
                {
                    return puzzle[row][col];
                }
            }
        }
        return this;
    }

    public Node getMostConstrained(Node[][] puzzle, Object[] colors)
    {
        //set the initial conditions
        Node mostConstrainedNode = null;
        int mostConstrainedVal = Integer.MIN_VALUE;

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
                    //get the constraint value of the current Node
                    int currentConstraintVal = getConstraintVal(puzzle, puzzle[row][col], colors);

                    //set the new most constrained Node
                    if (currentConstraintVal > mostConstrainedVal)
                    {
                        mostConstrainedNode = puzzle[row][col];
                        mostConstrainedVal = currentConstraintVal;
                    }
                }
            }
        }
        return mostConstrainedNode;
    }

    public int getConstraintVal(Node[][] puzzle, Node node, Object[] colors)
    {
        //set the initial conditions
        int validColors = 0;
        char originalColor = node.getSymbol();
        Constraint constraint = new Constraint();

        //check all colors
        for (Object color : colors)
        {
            //try a color at the current position and mark it assigned
            puzzle[node.getRowCord()][node.getColCord()].setSymbol((Character) color);
            //puzzle[node.getRowCord()][node.getColCord()].setAssigned(true);

            //see if the placement is valid
            if (constraint.isValid(puzzle))
            {
                //update the number of valid colors
                validColors++;
            }
            //reset the color
            puzzle[node.getRowCord()][node.getColCord()].setSymbol(originalColor);
            //puzzle[node.getRowCord()][node.getColCord()].setAssigned(true);
        }
        return validColors;
    }

    public Node getMCN(Node[][] puzzle){
        int constraints;
        int maxConstraints = 0;
        Node node;
        Node mostConstrained = this;
        for (int row = 0; row < puzzle.length; row++){
            for (int col = 0; col < puzzle[row].length; col++){
                node = puzzle[row][col];
                constraints = 0;
                if (node.getRowCord() > 0) {
                    //only care about Nodes of the same colors
                    if (puzzle[node.getRowCord() - 1][node.getColCord()].getSymbol() != '_') {
                        //update the number of adjacent Nodes
                        constraints++;
                    }
                }
                if (node.getColCord() < puzzle[0].length - 1) {
                    if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() != '_') {
                        constraints++;
                    }
                }
                if (node.getRowCord() < puzzle.length - 1) {
                    if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() != '_') {
                        constraints++;
                    }
                }
                if (node.getColCord() > 0) {
                    if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() != '_') {
                        constraints++;
                    }
                }

                if(constraints == 4){
                    return node;
                }
                if(constraints > maxConstraints){
                    mostConstrained = node;
                    maxConstraints = constraints;
                }
            }
        }
        return mostConstrained;
    }

    /**
     * Method to print a given Node instance
     * (row coordinate, column coordinate) color
     */
    @Override
    public String toString()
    {
        return "(" + rowCord + ", " + colCord + ") " + symbol;
    }

    /**
     * Method to set the symbol of a Node and mark it assigned
     * @param symbol char value
     */
    public void setSymbol(char symbol)
    {
        this.assigned = true;
        this.symbol = symbol;
    }

    /**
     * Method to return the symbol of a Node
     * @return char value
     */
    public char getSymbol()
    {
        return symbol;
    }

    /**
     * Method to set the row coordinate of a Node
     * @param rowCord the coordinate as an integer
     */
    public void setRowCord(int rowCord)
    {
        this.rowCord = rowCord;
    }

    /**
     * Method to return the row coordinate of a Node
     * @return int value
     */
    public int getRowCord()
    {
        return rowCord;
    }

    /**
     * Method to set the column coordinate of a Node
     * @param colCord the coordinate as an integer
     */
    public void setColCord(int colCord)
    {
        this.colCord = colCord;
    }

    /**
     * Method to return the column coordinate of a Node
     * @return int value
     */
    public int getColCord()
    {
        return colCord;
    }

    /**
     * Method to mark a Node as a dot; and also as assigned
     */
    public void setDot()
    {
        this.dot = true;
        this.assigned = true;
    }

    /**
     * Method to determine if a Node is a dot
     * @return boolean value
     */
    public boolean isDot()
    {
        return dot;
    }
}
