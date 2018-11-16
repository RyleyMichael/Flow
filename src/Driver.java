/**
 * Main class to read in the file and handle the progress through the assignment
 *
 * Team Members: Connor Grace & Ryley Rodriguez
 * CSCI 446 - Artificial Intelligence
 * Flow Assignment - Backtracking
 * Fall 2018
 */

//imports for ArrayList, scanning, file reading
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;


public class Driver {
    public static void main (String[] args)
    {
        //instance variables
        Array array = new Array();
        Backtrack backtrack;
        Node[][] originalPuzzle;
        Node[][] solvedPuzzle;
        Object[] colors;
        long startTime;
        long elapsedTime;
        ArrayList<ArrayList<Character>> puzzle = new ArrayList<>();

        /* USER INPUT SECTION */
        boolean error = true;
        System.out.println("\nWelcome to Flow Solver. Please enter a file name.");
        System.out.print("Name of Puzzle > ");
        Scanner in = new Scanner(System.in);
        String fileName = "";

        //loop until the user enters a valid file name
        while (error)
        {
            try
            {
                //get the name of the file as the whole line entered
                fileName = in.nextLine();

                //only accept valid puzzles
                if (fileName.equals("5x5maze.txt") || fileName.equals("7x7maze.txt") || fileName.equals("8x8maze.txt")
                        || fileName.equals("9x9maze.txt") || fileName.equals("10x10maze.txt") || fileName.equals("12x12maze.txt"))
                {
                    System.out.println("\n" + fileName + " is valid. Please wait while your puzzle is being solved.");

                    //open the file
                    Scanner fileRead = new Scanner(new FileReader(fileName));

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

                    //valid input entered
                    error = false;
                }

                //invalid input entered
                else
                {
                    System.out.println("\nInvalid puzzle name. Please try some form of.. NxNmaze.txt");
                    System.out.print("Name of Puzzle > ");
                }
            }
            catch (Exception e)
            {
                System.out.println("\nInvalid puzzle name. Please try some form of.. NxNmaze.txt");
                System.out.print("Name of Puzzle > ");
                in.next();
            }
        }

        //setting the initial conditions; converting, printing, getting domain, starting timer
        originalPuzzle = array.convert(puzzle);
        System.out.println("\nOriginal Puzzle");
        array.print(originalPuzzle);
        colors = array.getColors(originalPuzzle);
        backtrack = new Backtrack(originalPuzzle, colors);
        startTime = System.nanoTime();

        //solve the puzzle using simple backtracking and print out the solution
        solvedPuzzle = backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved " + fileName + " using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");

        //solve the same puzzle using advanced backtracking and print out the solution
        originalPuzzle = array.convert(puzzle);
        backtrack = new Backtrack(originalPuzzle, colors);
        startTime = System.nanoTime();
        solvedPuzzle = backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved " + fileName + " using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");

        System.out.println("\nSolved Puzzle");
        array.print(solvedPuzzle);

        /* TESTING */
        //Node start = array.findStart(openPuzzle);
        //System.out.println("\nStarting node is " + start);
        //System.out.println("\nColors are..");
        //array.printColors(colors);
        //System.out.println("\nDots at...");
        //array.printDots(openPuzzle);
    }
}
