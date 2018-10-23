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
     * Method to print a given Node instance
     */
    @Override
    public String toString()
    {
        return "(" + rowCord + ", " + colCord + ")";
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
