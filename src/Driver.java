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
        Array array = new Array();
        Backtrack backtrack;
        Node[][] solvedPuzzle;
        Object[] colors;
        //array list of characters
        ArrayList<ArrayList<Character>> puzzle = new ArrayList<>();
        long startTime;
        long elapsedTime;

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

        // 5x5 solver
        Node[][] five = array.convert(puzzle);
        System.out.println("\n5x5 Puzzle");
        array.print(five);
        colors = array.getColors(five);
        backtrack = new Backtrack(five, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 5x5 using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");
        array.print(solvedPuzzle);

        System.out.println();

        five = array.convert(puzzle);
        backtrack = new Backtrack(five, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 5x5 using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");
        array.print(solvedPuzzle);

        //////////////////////////////////////////////////////////////////

        puzzle = new ArrayList<>();
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("7x7maze.txt"));

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

        // 7x7 solver
        Node[][] seven = array.convert(puzzle);
        System.out.println("\n5x5 Puzzle");
        array.print(seven);
        colors = array.getColors(seven);
        backtrack = new Backtrack(seven, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 7x7 using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");
        array.print(solvedPuzzle);

        System.out.println();

        seven = array.convert(puzzle);
        backtrack = new Backtrack(seven, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 7x7 using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");
        array.print(solvedPuzzle);

        /////////////////////////////////////////////////////////////////

        puzzle = new ArrayList<>();
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("8x8maze.txt"));

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

        // 8x8 solver
        Node[][] eight = array.convert(puzzle);
        System.out.println("\n8x8 Puzzle");
        array.print(eight);
        colors = array.getColors(eight);
        backtrack = new Backtrack(eight, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 8x8 using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");
        array.print(solvedPuzzle);

        System.out.println();

        eight = array.convert(puzzle);
        backtrack = new Backtrack(eight, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 8x8 using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");
        array.print(solvedPuzzle);

        ///////////////////////////////////////////////////////////////////

        puzzle = new ArrayList<>();
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("9x9maze.txt"));

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

        // 9x9 solver
        Node[][] nine = array.convert(puzzle);
        System.out.println("\n9x9 Puzzle");
        array.print(nine);
        colors = array.getColors(nine);
        backtrack = new Backtrack(nine, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 9x9 using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");
        array.print(solvedPuzzle);

        System.out.println();

        nine = array.convert(puzzle);
        backtrack = new Backtrack(nine, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 9x9 using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");
        array.print(solvedPuzzle);

        ////////////////////////////////////////////////////////////////////

        puzzle = new ArrayList<>();
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("10x10maze.txt"));

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

        // 10x10 solver
        Node[][] ten = array.convert(puzzle);
        System.out.println("\n10x10 Puzzle");
        array.print(ten);
        colors = array.getColors(ten);
        backtrack = new Backtrack(ten, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 10x10 using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");
        array.print(solvedPuzzle);

        System.out.println();

        ten = array.convert(puzzle);
        backtrack = new Backtrack(ten, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 10x10 using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");
        array.print(solvedPuzzle);

        //////////////////////////////////////////////////////////////////

        /*puzzle = new ArrayList<>();
        try
        {
            //opens the file
            Scanner fileRead = new Scanner(new FileReader("12x12maze.txt"));

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

        // 12x12 solver
        Node[][] twelve = array.convert(puzzle);
        System.out.println("\n12x12 Puzzle");
        array.print(twelve);
        colors = array.getColors(twelve);
        backtrack = new Backtrack(twelve, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.dumbSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 12x12 using dumbSolve in " + elapsedTime + " milliseconds, " + backtrack.getDumbCount() + " placements attempted");
        array.print(solvedPuzzle);

        System.out.println();

        twelve = array.convert(puzzle);
        backtrack = new Backtrack(twelve, colors);
        startTime = System.nanoTime();
        solvedPuzzle =  backtrack.smartSolve();
        elapsedTime = (System.nanoTime()-startTime)/1000000;
        System.out.println("\nSolved 12x12 using smartSolve in " + elapsedTime + " milliseconds, " + backtrack.getSmartCount() + " placements attempted");
        array.print(solvedPuzzle);*/



        /* TESTING */
        //Node start = array.findStart(openPuzzle);
        //System.out.println("\nStarting node is " + start);
        //System.out.println("\nColors are..");
        //array.printColors(colors);
        //System.out.println("\nDots at...");
        //array.printDots(openPuzzle);
    }
}
