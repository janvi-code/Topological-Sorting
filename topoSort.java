import java.util.*;
import java.lang.*;

class Mains
{ 
	int V;
	private LinkedList<Integer> adj[];
   Mains(int V)
   {
	   this.V=V;
	     adj = new LinkedList[V]; 
	        for (int i=0; i<V; i++) 
	            adj[i] = new LinkedList();
   }
   public void addEdge(int v,int w)
   {
	  adj[v].add(w);	  
   }
   
   public void topologicalSort()
   {
	   Stack<Integer> stack=new Stack<>();
	   boolean visited[]=new boolean[V];
	   for(int i=0;i<V;i++)
		   visited[i]=false;
	   
	   for(int i=0;i<V;i++)
	   {
		   if(visited[i]==false)
			   TOPOSORT(i,visited,stack);
	   }
	   System.out.println("Topological sort is = ");
	   System.out.println();
	   while(stack.isEmpty()==false)
	   {
		   System.out.println(stack.pop());
	   }
   }
   
   public void TOPOSORT(int v,boolean visited[],Stack<Integer> stack)
   {
	   visited[v]=true;
	   
	   for(int i=0;i<adj[v].size();i++)
	   {
		   if(visited[adj[v].get(i)]==false)
			   TOPOSORT(adj[v].get(i),visited,stack);
	   }
	   
	   stack.push(v);
   }
   
}
public class topoSort 
{
   public static void main(String args[])
   {
       Mains g = new Mains(6); 
       g.addEdge(5, 2); 
       g.addEdge(5, 0); 
       g.addEdge(4, 0); 
       g.addEdge(4, 1); 
       g.addEdge(2, 3); 
       g.addEdge(3, 1); 
       
       g.topologicalSort();
       
   }
}
