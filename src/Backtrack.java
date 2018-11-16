/**
 * Class to solve the Flow puzzle via backtracking
 * This class implements a simple backtracking method and one with a heuristic function
 */

public class Backtrack
{

    //instance variables
    private Node[][] puzzle;
    private Object[] colors;
    private Constraint constraint;
    private Array array;
    private Node initial;

    /**
     * Constructor
     */
    public Backtrack(Node[][] puzzle, Object[] colors)
    {
        this.puzzle = puzzle;
        this.colors = colors;
        constraint = new Constraint();
        array = new Array();
        initial = puzzle[0][0];
    }

    public Node[][] dumbSolve()
    {
        //if the puzzle is full
        if (constraint.isFull(puzzle))
        {
            //solution found
            return puzzle;
        }

        // get most constrained node
        Node nextNode = initial.getNext(puzzle);

        //loop through all color choices
        for (Object color : colors)
        {
            //try a color at the current position and mark it assigned
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol((Character) color);
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(true);

            //print for testing
            /*System.out.println();
            array.print(puzzle);
            System.out.println("Current Node: " + puzzle[nextNode.getRowCord()][nextNode.getColCord()]);*/

            //see if the placement is valid
            if (constraint.isValid(puzzle))
            {
                Node[][] solution = dumbSolve();

                //see if the placement is valid
                //if (solution != null && constraint.isValid(solution))
                if (solution != null && constraint.isValid(puzzle))
                {
                    //solution found
                    return solution;
                }
            }
            //reset the placement
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol('_');
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(false);
        }
        return null;
    }

    public Node[][] smartSolve()
    {
        //if the puzzle is full
        if (constraint.isFull(puzzle))
        {
            //solution found
            return puzzle;
        }

        Node nextNode = initial.getMCN(puzzle);

        //loop through all color choices
        for (Object color : colors)
        {
            //try a color at the current position and mark it assigned
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol((Character) color);
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(true);

            //print for testing
            /*System.out.println();
            array.print(puzzle);
            System.out.println("Current Node: " + puzzle[nextNode.getRowCord()][nextNode.getColCord()]);*/

            //see if the placement is valid
            if (constraint.isValid(puzzle))
            {

                if(constraint.forwardChecking(puzzle, colors)) {
                    Node[][] solution = dumbSolve();


                    //see if the placement is valid
                    //if (solution != null && constraint.isValid(solution))
                    if (solution != null && constraint.isValid(puzzle)) {
                        //solution found
                        return solution;
                    }
                }
            }
            //reset the placement
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setSymbol('_');
            puzzle[nextNode.getRowCord()][nextNode.getColCord()].setAssigned(false);
        }
        return null;
    }

    /**
     * Recursive method to solve the puzzle via backtracking without a heuristic
     * @param currentNode the Node currently being tested
     *                    this is the starting Node when first called
     */
    public void simpleSolve(Node currentNode)
    {
        if(isComplete())
        //loop through color choices
        for (Object color : colors)
        {
            //only check non-assigned Nodes
            if (!puzzle[currentNode.getRowCord()][currentNode.getColCord()].isAssigned())
            {
                //place a color in the current position and print
                puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol((Character) color);
                puzzle[currentNode.getRowCord()][currentNode.getColCord()].setAssigned(true);
                System.out.println();
                array.print(puzzle);
                System.out.println("Current Node: " + puzzle[currentNode.getRowCord()][currentNode.getColCord()]);

                //check adjacent node constraint
                if (constraint.isValid(puzzle))
                {
                    //check full constraint
                    if (constraint.isFull(puzzle))
                    {
                        System.exit(0);
                    }
                    simpleSolve(currentNode.getNext(puzzle));
                }

                //recent placement is not valid
                puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol('_');
                puzzle[currentNode.getRowCord()][currentNode.getColCord()].setAssigned(false);
                //System.out.println();
                //array.print(puzzle);
            }
        }

        /*
        //loop through all possible color choices
        for (int i = 0; i < colors.length; i++)
        {
            //place a color in the current position
            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol((Character) colors[i]);
            //currentNode.setSymbol((Character) colors[i]);

            //print the puzzle
            System.out.println();
            array.print(puzzle);

            //print the current node
            //System.out.println("Current Node: " + currentNode);
            System.out.println("Current Node: " + puzzle[currentNode.getRowCord()][currentNode.getColCord()]);

            //if recent placement does not violate constraints for the board so far i.e. board does not have to be full
            if (constraint.checkAdjacent(puzzle, currentNode))
            {
                //if the whole board is full and constraints hold for all positions
                if (constraint.isComplete(puzzle))
                {
                    //complete solution
                    System.out.println("COMPLETE");
                    System.exit(0);
                }

                //else if the whole board is not full
                else
                {
                    //make a recursive call with the next position in the puzzle
                    Node node = currentNode.getNext(puzzle);
                    simpleSolve(node);
                }
            }

            //the recent placement does violate constraints, so remove it
            puzzle[currentNode.getRowCord()][currentNode.getColCord()].setSymbol('_');
            currentNode.setSymbol('_');
        }
        */

    }

    public Node[][] dumbdumb(){
        if(isComplete()) return puzzle;
        Node node = next();
        char orig = node.getSymbol();

        for(Object color : colors){
            node.setSymbol((char)color);
            System.out.println();
            array.print(puzzle);
            System.out.println();
            System.out.println("Current Node: " + puzzle[node.getRowCord()][node.getColCord()]);
            if(check(puzzle)){
                puzzle = dumbdumb();

                if (puzzle != null && check(puzzle)){
                    return puzzle;
                }
                //node.setSymbol(orig);
                node.setSymbol('_');
            }
            else{
                //node.setSymbol(orig);
                node.setSymbol('_');
            }
        }
        return null;
    }

    private boolean isComplete(){
        for(int row = 0; row < this.puzzle.length; row++){
            for (int col = 0; col < this.puzzle.length; col++){
                if (this.puzzle[row][col].getSymbol() == '_')
                    return false;
            }
        }
        return true;
    }

    private Node next(){
        for(int row = 0; row < puzzle.length; row++){
            for (int col = 0; col < puzzle.length; col++){
                if (puzzle[row][col].getSymbol() == '_')
                    return puzzle[row][col];
            }
        }
        return null;
    }

    public boolean check(Node[][] puzzle)
    {
        //represents the number of adjacent Nodes of the same color
        int adjNodes = 0;
        int adjEmpty = 0;
        Node node;
        char color;

        //cells with no unassigned neighbors need to contain at least one neighbor of the same color...
        for(int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle.length; col++) {
                node = puzzle[row][col];
                color = node.getSymbol();
                if (node.getSymbol() != '_')
                {
                    //only check viable Nodes i.e. values within the range of the array
                    //check North if not on first row
                    if (node.getRowCord() > 0) {
                        //only care about Nodes of the same colors
                        if (puzzle[node.getRowCord() - 1][node.getColCord()].getSymbol() == color) {
                            //update the number of adjacent Nodes
                            adjNodes++;
                        }
                        if (puzzle[node.getRowCord() - 1][node.getColCord()].getSymbol() == '_') {
                            //update the number of adjacent Nodes
                            adjEmpty++;
                        }
                    }

                    //check East if not on last column
                    if (node.getColCord() < puzzle[0].length - 1) {
                        if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() == color) {
                            adjNodes++;
                        }
                        if (puzzle[node.getRowCord()][node.getColCord() + 1].getSymbol() == '_') {
                            adjEmpty++;
                        }
                    }

                    //check South if not on last row
                    if (node.getRowCord() < puzzle.length - 1) {
                        if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() == color) {
                            adjNodes++;
                        }
                        if (puzzle[node.getRowCord() + 1][node.getColCord()].getSymbol() == '_') {
                            adjEmpty++;
                        }
                    }

                    //check West
                    if (node.getColCord() > 0) {
                        if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == color) {
                            adjNodes++;
                        }
                        if (puzzle[node.getRowCord()][node.getColCord() - 1].getSymbol() == '_') {
                            adjEmpty++;
                        }
                    }

                    if(adjNodes > 2) return false;

                    if(adjEmpty == 0) {
                        if (adjNodes == 0)
                            return false;

                        //the Node is not a dot
                        if (!node.isDot()) {
                            //number of adjacent nodes to a newly filled-in cell must be at least one, not greater than 2
                            //if (adjNodes < 1 || adjNodes > 2)
                            if (adjNodes != 2)
                            //if (adjNodes > 2)
                            {
                                return false;
                            }
                        }

                        //the Node is a dot
                        else if (node.isDot()) {
                            //number of adjacent nodes to a dot must be exactly one
                            //if (adjNodes > 1)
                            if (adjNodes != 1)
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
