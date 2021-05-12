/*
 state.java is an abstract class that defines the structure of the puzzle state.
 */
package eightpuzzle;



import java.util.ArrayList;


public interface state{
    
public  ArrayList<state> possibleMoves();

public int costToThisState();

public boolean isFinalState();

public boolean compareTwoStates(state State);

public void printState(); 

}