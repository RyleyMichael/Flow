/**
 * Class to perform conversions on the puzzle as an ArrayList, 2d char array
 */

//imports
import java.util.ArrayList;

public class Array
{

    /**
     * Constructor
     */
    public Array()
    {

    }

    /**
     * Method to find the different colors that are present in the puzzle
     * @param puzzle 2d Node representation of the Flow puzzle
     * @return the different colors as an Object array
     */
    public Object[] getColors(Node[][] puzzle)
    {
        ArrayList<Character> colorList = new ArrayList<>();

        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //only add colors that have not been encountered
                if (!colorList.contains(puzzle[row][col].getSymbol()) && puzzle[row][col].isDot())
                {
                    colorList.add(puzzle[row][col].getSymbol());
                }
            }
        }
        return colorList.toArray();
    }

    /**
     * Method to print the colors in the puzzle
     * This method is mainly for testing
     * @param colors the list of colors as an Object array
     */
    public void printColors(Object[] colors)
    {
        for (int i = 0; i < colors.length; i++)
        {
            System.out.println(colors[i]);
        }
    }

    /**
     * Method to find all the dots i.e. starting/ending points in the maze
     * This method is mainly for testing
     * @param puzzle the original flow grid
     */
    public void printDots(Node[][] puzzle)
    {
        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[row].length; col++)
            {
                //only print the dots
                if (puzzle[row][col].isDot())
                {
                    System.out.println("Dot found at " + puzzle[row][col]);
                }

            }
        }
    }

    /**
     * Method to find the starting point in the puzzle
     * the starting point, in this case, is just the first non-filled entry in the table
     * @param puzzle the original flow grid
     * @return the starting point as a Node instance
     */
    public Node findStart(Node[][] puzzle)
    {
        Node start = new Node(0, 0, '_');

        //loop through the rows
        for (int col = 0; col < puzzle[0].length; col++)
        {
            //loop through the columns
            for (int row = 0; row < puzzle.length; row ++)
            {
                //the starting point is the first empty Node
                if (puzzle[row][col].getSymbol() == '_')
                {
                    start.setRowCord(row);
                    start.setColCord(col);
                    return start;
                }
            }
        }
        return start;
    }

    /**
     * Method to convert a two-dimensional ArrayList into a two-dimensional Node array
     * This method also marks the various dots in the puzzle as they are encountered
     * @param input the text file as a 2d ArrayList
     * @return a 2d Node array representing the puzzle
     */
    public Node[][] convert(ArrayList<ArrayList<Character>> input)
    {
        int numRows = input.size();
        int numCols = input.get(0).size();
        Node[][] puzzle = new Node[numRows][numCols];

        //loop through the rows
        for (int row = 0; row < numRows; row++)
        {
            //loop through the columns
            for (int col = 0; col < numCols; col++)
            {
                //make a new Node instance for each spot in the puzzle
                Node node = new Node(row, col, input.get(row).get(col));
                puzzle[row][col] = node;

                //mark the Node a dot if it is non-empty
                if (node.getSymbol() != '_')
                {
                    node.setDot();
                }
            }
        }
        return puzzle;
    }

    /**
     * Method to print a two-dimensional Node array
     * @param input 2d Node array
     */
    public void print(Node[][] input)
    {
        //loop through the rows
        for (int row = 0; row < input.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < input[row].length; col++)
            {
                System.out.print(input[row][col].getSymbol());
            }
            System.out.println();
        }
    }
}
