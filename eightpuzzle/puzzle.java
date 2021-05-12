/*  puzzle inherits state class and implements the definition and operations of the puzzle states. */


package eightpuzzle;

import java.util.ArrayList;
import java.util.Arrays;


public class puzzle implements state {
    
    int misplacedTiles = 0;
    int manhattanDistance = 0;
    final int[] FinalState = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0};
    int[] currentState;
    
    public puzzle(int[] initialState)
    {
  
    currentState=initialState;
    calculateMisplacedTiles();
    calculateManhattanDistance();
    
    //this.currentState=currentState;

    }
    
    public void calculateMisplacedTiles()
{
    misplacedTiles=0;
    
    for(int i=0; i<currentState.length;i++)
    {
        if(currentState[i]!=FinalState[i])
        {
            misplacedTiles++;
           
        }
    }
    //System.out.println("Misplaced:"+misplacedTiles);
}
    
    public int getMisplacedTiles()
    {
        return misplacedTiles;
    }
    
    public void calculateManhattanDistance()
    {
      int ind=-1;
      
       for (int y = 0; y < 3; y++)
       {
            for (int x = 0; x < 3; x++)
            {
                ind++;
                int value = (currentState[ind] - 1);
                if (value != -1) 
                {
                    int horizontal = value % 3;
                    int vertical = value / 3;
                     manhattanDistance += Math.abs(vertical - (y)) + Math.abs(horizontal - (x));
                }
            }
       }
    }
    
    public int getManhattanDistance()
    {
        return manhattanDistance;
    }
    
    public int getBlankTile()
    {
        int blankIndex = -1;

        for (int i=0; i<9; i++)
        {
            if (currentState[i] == 0)
            {
                blankIndex = i;
                break;
            }
        }
        return blankIndex;
    }
  
  private int[] duplicate(int[] toBeDuplicated) {
        int[] dupe = new int[9];
        for (int i=0; i<9; i++)
        {
            dupe[i] = toBeDuplicated[i];
        }
        return dupe;
    }
  
  public ArrayList<state> possibleMoves()
{
   ArrayList<state> moves=new ArrayList<state>();
   int blankIndex=getBlankTile();
   
   if(blankIndex!= 0 && blankIndex!= 3 && blankIndex!= 6)
   {
      move(blankIndex-1 ,blankIndex, moves); 
      System.out.println("Moved left");
   }
   if(blankIndex!=6 && blankIndex!=7 && blankIndex!=8)
   {
      move(blankIndex+3 ,blankIndex, moves); 
      System.out.println("Moved up");
   }  
   if(blankIndex!=0 && blankIndex!=1 && blankIndex!=2)
   {
      move(blankIndex-3 ,blankIndex, moves); 
      System.out.println("Moved down");
   }  
   if(blankIndex!=2 && blankIndex!=5 && blankIndex!=8)
   {
      move(blankIndex+1 ,blankIndex, moves);
      System.out.println("Moved right");
   }  
  
   return moves;
   
}
  
  public void move(int from, int to, ArrayList<state> storeHere)
{
    int[] newstate= duplicate(currentState);
    int temp=newstate[from];
    newstate[from]=newstate[to];
    newstate[to]=temp;
    puzzle newState=new puzzle(newstate);
    storeHere.add(newState);
}
  
@Override  
public int costToThisState()
{
    int cost=0;
    for(int i=0;i<9;i++)
    {
        int num;
        
        if(FinalState[i]==0)
        {
           num=9;
        }
        else
        {
            num=FinalState[i];
        }
        
        cost= cost+(Math.abs(currentState[i]-num));
    }
    return cost;
}  

public boolean isFinalState()
{
    return Arrays.equals(currentState,FinalState);
}

public boolean compareTwoStates(state toBeCompared)
{
    boolean compared= Arrays.equals(currentState, ((puzzle) toBeCompared).currentState);
    return compared;
}

public void printState() {
        System.out.println(currentState[0] + " | " + currentState[1] + " | "
                + currentState[2]);
        System.out.println("---------");
        System.out.println(currentState[3] + " | " + currentState[4] + " | "
                + currentState[5]);
        System.out.println("---------");
        System.out.println(currentState[6] + " | " + currentState[7] + " | "
                + currentState[8]);

    }
    
}