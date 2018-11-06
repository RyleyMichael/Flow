/**
 * Class to represent a given space on the puzzle
 */

public class Node
{
    //instance variables
    private int rowCord;
    private int colCord;
    private char symbol;
    private boolean dot; //a dot is a starting/ending point in the maze

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
     * Method to get the next Node to be tested
     * @param puzzle
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
                //skip dots and Nodes that are filled in
                if (!puzzle[row][col].isDot() && puzzle[row][col].getSymbol() == '_')
                {
                    //skip the current Node
                    if (!this.isEqual(puzzle[row][col]))
                    {
                        return puzzle[row][col];
                    }
                }
            }
        }
        return this;
    }

    /**
     * Method to determine if two Nodes are the same
     * @param node the Node to be checked against 'this'
     * @return a boolean value representing if the Nodes are equal
     */
    public boolean isEqual(Node node)
    {
        //the row coordinate is the same
        if (this.getRowCord() == node.getRowCord())
        {
            //the column coordinate is the same
            if (this.getColCord() == node.getColCord())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to print a given Node instance
     */
    @Override
    public String toString()
    {
        return "(" + rowCord + ", " + colCord + ") " + symbol;
    }

    /**
     * Method to set the symbol of a Node
     * @param symbol the symbol as a character
     */
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    /**
     * Method to return the symbol of a Node
     * @return the symbol as a character
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
     * @return the coordinate as an integer
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
     * @return the coordinate as an integer
     */
    public int getColCord()
    {
        return colCord;
    }

    /**
     * Method to mark a Node as a dot
     */
    public void setDot()
    {
        this.dot = true;
    }

    /**
     * Method to determine if a Node is a dot
     * @return
     */
    public boolean isDot()
    {
        return dot;
    }
}
