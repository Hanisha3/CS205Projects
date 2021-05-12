/* This contains the code for A Star Search algorithm with Misplaced Tiles and Manhattan Distance */


package eightpuzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class AStar {
    
public void aStarSearchWithMisplacedTiles(int[] Puzzle)    
{
    puzzle problem=new puzzle(Puzzle);
    node head=new node(problem);
    Queue<node> queue= new LinkedList<node>();
    queue.add(head);
    
    int searchCount = 1; //number of iterations
    while(!queue.isEmpty())
    {
       // System.out.println("in while");
        node temp=queue.poll();
        
        if (!temp.getState().isFinalState())
        {
            ArrayList<state> nextMovesForTemp=temp.getState().possibleMoves();
            
            ArrayList<node> nextNodes=new ArrayList<node>();
            
            //checking the list nextMovesForTemp
            
            for(int i=0;i<nextMovesForTemp.size();i++)
            {
                node checked;
                
                checked= new node(nextMovesForTemp.get(i),(temp.cost+nextMovesForTemp.get(i).costToThisState()),
                        ((puzzle)nextMovesForTemp.get(i)).getMisplacedTiles(), temp );
                //System.out.println("checked times:"+i);
                
                if(!repeated(checked))
                {
                    //System.out.println("Checked for repeats");
                    nextNodes.add(checked);
                }
                
            }
            if(nextNodes.size()==0)
            {
               // System.out.println("Got here");
                continue;
            }
            node nodewithLeastCost=nextNodes.get(0);
            
            for(int i=0;i<nextNodes.size();i++)
            {
                if(nodewithLeastCost.totalCost>nextNodes.get(i).totalCost)
                {
                    nodewithLeastCost=nextNodes.get(i);
                    //System.out.println("also here");
                }
            }
            
            int ValueofNodeWithLeastCost=nodewithLeastCost.totalCost;
           // System.out.println("Least cost:"+ValueofNodeWithLeastCost);
            
            for(int i=0;i<nextNodes.size();i++)
            {
                if(nextNodes.get(i).totalCost==ValueofNodeWithLeastCost)
                {
                    queue.add(nextNodes.get(i));
                }
            }
            searchCount++;
          //  System.out.println("Search count:"+searchCount);
        }
        else
        {
          //  System.out.println("Final state reached");
            Stack<node> Path=new Stack<node>();
            Path.push(temp);
            temp=temp.previous;
            
            while(temp.previous!=null)
            {
                Path.push(temp);
                temp=temp.previous;
            }
            Path.push(temp);
            
            int pathSize=Path.size();
            
            for(int i=0;i<pathSize;i++)
            {
                temp=Path.pop();
                temp.getState().printState();
                System.out.println();
                System.out.println();
            }
          System.out.println("The total cost was: " + temp.totalCost);
	    System.exit(0);
        }
    }
}
  

public void aStarSearchWithManhattanDistance(int[] Puzzle)    
{
    puzzle problem=new puzzle(Puzzle);
    node head=new node(problem);
    Queue<node> queue= new LinkedList<node>();
    queue.add(head);
    
    int searchCount = 1; //number of iterations
    while(!queue.isEmpty())
    {
      //  System.out.println("in while");
        node temp=queue.poll();
        
        if (!temp.getState().isFinalState())
        {
            ArrayList<state> nextMovesForTemp=temp.getState().possibleMoves();
            
            ArrayList<node> nextNodes=new ArrayList<node>();
            
            //checking the list nextMovesForTemp
            
            for(int i=0;i<nextMovesForTemp.size();i++)
            {
                node checked;
                
                checked= new node(nextMovesForTemp.get(i),(temp.cost+nextMovesForTemp.get(i).costToThisState()),
                        ((puzzle)nextMovesForTemp.get(i)).getManhattanDistance(), temp );
                //System.out.println("checked times:"+i);
                
                
                if(!repeated(checked))
                {
                   // System.out.println("Checked for repeats");
                    nextNodes.add(checked);
                }
                
            }
            if(nextNodes.size()==0)
            {
               // System.out.println("Got here");
                continue;
            }
            node nodewithLeastCost=nextNodes.get(0);
            
            for(int i=0;i<nextNodes.size();i++)
            {
                if(nodewithLeastCost.totalCost>nextNodes.get(i).totalCost)
                {
                    nodewithLeastCost=nextNodes.get(i);
                   // System.out.println("also here");
                }
            }
            
            int ValueofNodeWithLeastCost=nodewithLeastCost.totalCost;
           // System.out.println("Least cost:"+ValueofNodeWithLeastCost);
            
            for(int i=0;i<nextNodes.size();i++)
            {
                if(nextNodes.get(i).totalCost==ValueofNodeWithLeastCost)
                {
                    queue.add(nextNodes.get(i));
                }
            }
            searchCount++;
           // System.out.println("Search count:"+searchCount);
        }
        else
        {
           // System.out.println("Final state reached");
            Stack<node> Path=new Stack<node>();
            Path.push(temp);
            temp=temp.previous;
            
            while(temp.previous!=null)
            {
                Path.push(temp);
                temp=temp.previous;
            }
            Path.push(temp);
            
            int pathSize=Path.size();
            
            for(int i=0;i<pathSize;i++)
            {
                temp=Path.pop();
                temp.getState().printState();
                System.out.println();
                System.out.println();
            }
            System.out.println("The total cost was: " + temp.totalCost);
	    System.exit(0);
        }
    }
}
  



public boolean repeated(node Node)
{
    boolean val=false;
    node check=Node;
    
    while(Node.previous!=null && !val )
    {
        if (Node.previous.getState().compareTwoStates(check.getState()))
        {
            val=true;
        }
        
        Node=Node.previous;
    }
    
    return val;
    
}
    
    
}
