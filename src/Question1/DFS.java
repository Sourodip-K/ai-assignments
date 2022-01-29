package Question1;

import java.util.*;
public class DFS {
    /*
    BASIC REPRESENTATION OF A GRAPH USING AN ADJACENCY LIST, which is created by an array of LinkedLists.
     */
    private LinkedList<Integer> adj[];

    public DFS(int v) {
        adj=new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    //fill data from the main function
    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
    //recursive function
    private boolean dfsUtil(int source, int destination, boolean vis[], int currdepth, int limit) {
        if (currdepth > limit) {
            return false;

        }
        System.out.println("Visited vertex: "+source+" at depth: "+currdepth);
        if(source == destination) {
            System.out.println("GOAL!!!");
            return true; //base condition
        }
        currdepth++;
        for(int neighbor: adj[source]) { //traversing the graph
            if(!vis[neighbor]) {
                vis[neighbor] = true; //mark if true
                boolean chk = dfsUtil(neighbor, destination, vis, currdepth, limit); //induction
                if(chk) return true;
            }
        }
        return false;
    }

    public boolean dfs(int source, int destination, int limit) {
        boolean vis[] = new boolean[adj.length];
        //a boolean visited array is created to store true if visited
        vis[source] = true; //mark the source to be visited
        int depth=0;
        //System.out.println ("Starting Vertex: "+source+" at depth: "+depth);
        boolean isfound =dfsUtil(source, destination, vis, depth, limit); //call the helper function
        if (isfound) return true;
        else return false;
    }

    //main function to take input from the user
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        /**System.out.println("Enter number of vertices : ");
         int v=sc.nextInt();
         System.out.println("Enter number of edges : ");
         int e=sc.nextInt();
         **/
        //using the vertices  we create the adjacency list
        DFS graph = new DFS(11);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 7);
        graph.addEdge(3, 6);
        graph.addEdge(3, 5);
        graph.addEdge(5, 8);
        graph.addEdge(4, 9);
        graph.addEdge(4, 10);

        /**System.out.println("Enter the edges : ");
         for(int j=0; j<e; j++) {
         int source=sc.nextInt();
         int destination = sc.nextInt();
         graph.addEdge(source,destination);
         //filled up the list with their respective source and destinations
         }
         **/

        //input for the source and destination vertex
        System.out.println("Enter the starting vertex: ");
        int start = sc.nextInt();
        System.out.println("Enter the ending vertex: ");
        int end = sc.nextInt();
        System.out.println("Enter the limit: ");
        int limit=sc.nextInt();
        System.out.println("The path taken was>>>");
        boolean chk = graph.dfs(start, end, limit);
        if(chk==false) System.out.println("\nSorry, Path is not possible with given limit: "+limit);
        //if path not found

    }
}