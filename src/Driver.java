/**
 * Driver class to read in the file and handle the progress through the assignment
 *
 * Connor Grace & Ryley Rodriguez
 * CSCI 446 - Artificial Intelligence
 * Fall 2018
 */

//imports for ArrayList, scanning, file reading
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

public class Driver {
    public static void main (String[] args)
    {
        //array list of characters
        ArrayList<ArrayList<Character>> puzzle = new ArrayList<>();

        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("5x5maze.txt"));

            //counter to represent the inner array list
            int i = 0;

            //loop through the whole file line-by-line
            while (fileRead.hasNextLine())
            {
                //read the next line and convert the entire line to a char array
                String line = fileRead.nextLine();
                char[] charLine = line.toCharArray();
                puzzle.add(new ArrayList<>()); //add an array list inside maze

                //get the ith element, which is the second layer of the arrayList, and add it to the inner array list
                for (int j = 0; j < charLine.length; j++)
                {
                    puzzle.get(i).add(charLine[j]);
                }
                i++; //increment i to the next inner arrayList
            }

            fileRead.close();
        }

        //error is thrown if file cannot be found
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        //convert the array list to a 2d char array and print it
        Array array = new Array();
        Node[][] openPuzzle = array.convert(puzzle);
        System.out.println("\nOriginal Puzzle");
        array.print(openPuzzle);

        //find the starting Node in the puzzle
        Node start = array.findStart(openPuzzle);
        System.out.println("\nStarting node is " + start);

        //get all the colors in the puzzle
        Object[] colors = array.getColors(openPuzzle);
        System.out.println("Colors are..");
        array.printColors(colors);

        //print all dot locations in the puzzle
        array.printDots(openPuzzle);

        //solve the puzzle using dumb backtracking i.e. no heuristic
        Backtrack backtrack = new Backtrack(openPuzzle, colors);
        backtrack.simpleSolve(start);

        //solve the puzzle using smart backtracking i.e. with some heuristic
    }
}
