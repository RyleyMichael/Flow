/**
 * Class to perform conversions on the puzzle as an ArrayList, 2d char array
 */

//imports
import java.util.ArrayList;

public class Array {

    //instance variables

    /**
     * Constructor
     */
    public Array()
    {

    }

    /**
     * Method to find the starting point in the puzzle
     * the starting point, in this case, is just the first non-filled entry in the table
     * @param puzzle the original flow grid
     * @return the starting point as a Node instance
     */
    public Node findStart(char[][] puzzle)
    {
        Node start = new Node(0, 0);

        //loop through the rows
        for (int row = 0; row < puzzle.length; row++)
        {
            //loop through the columns
            for (int col = 0; col < puzzle[0].length; col++)
            {
                if (puzzle[row][col] == '_')
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
     * Method to convert a two-dimensional ArrayList into a two-dimensional char array
     * @param input the text file as a 2d ArrayList
     * @return a 2d char array representing the puzzle
     */
    public char[][] convert(ArrayList<ArrayList<Character>> input)
    {
        int numRows = input.size();
        int numCols = input.get(0).size();
        char[][] puzzle = new char[numCols][numCols];

        //loop through the entire maze
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                puzzle[i][j] = input.get(i).get(j);
            }
        }

        return puzzle;
    }

    /**
     * Method to print a two-dimensional char array
     * @param input 2d char array
     */
    public void print(char[][] input)
    {
        //loop through the entire puzzle
        for (int i = 0; i < input.length; i++)
        {
            for (int j = 0; j < input[0].length; j++)
            {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}
