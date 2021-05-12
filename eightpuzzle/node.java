/* This is a class that can be considered as something that creates the graph for the solution. it's a node (in a graph, list, linkedlist, array, etc.).
 */

package eightpuzzle;


public class node {
 
    state State;
    node previous;
    int cost;
    int heuristicCost;
    int totalCost;
    
    public node(state arg)
    {
        State=arg;
        previous=null;
        cost=heuristicCost=totalCost=0;
    }
    
    public node(state arg,int hn, int c,node prev)
    {
        State=arg;
        previous=prev;
        this.cost=c;
        heuristicCost=hn;
        totalCost=cost+heuristicCost;
        
    }
    
    public state getState()
    {
        return State;
    }
}
