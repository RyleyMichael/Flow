/**
 * Class to perform conversions on an ArrayList
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
     * Method to convert a two-dimensional ArrayList into a two-dimensional char array
     * @param input
     * @return
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
     * @param input
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
