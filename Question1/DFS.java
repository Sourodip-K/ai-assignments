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
    private boolean dfsUtil(int source, int destination, boolean vis[]) {
        if(source == destination) return true; //base condition

        for(int neighbor: adj[source]) { //traversing the graph
            if(!vis[neighbor]) {
                vis[neighbor] = true; //mark if true
                System.out.print(neighbor + " "); //print what is visited
                boolean isConnected = dfsUtil(neighbor, destination, vis); //induction
                if(isConnected) return true;
            }
        }

        return false;
    }

    public boolean dfs(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        //a boolean visited array is created to store true if visited
        vis[source] = true; //mark the source to be visited
        System.out.print ("Starting from "+source+" ");
        return dfsUtil(source, destination, vis); //call the helper function
    }

    //main function to take input from the user
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        //using the vertices  we create the adjacency list
        DFS graph = new DFS(v);
        System.out.println("Enter the edges : ");
        for(int j=0; j<e; j++) {
            int source=sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source,destination);
            //filled up the list with their respective source and destinations
        }
        //input for the source and destination vertex
        System.out.println("Enter the starting vertex: ");
        int start = sc.nextInt();
        System.out.println("Enter the ending vertex: ");
        int end = sc.nextInt();
        System.out.println("The path taken to reach if possible will be>>>>");
        boolean chk = graph.dfs(start, end);
        if(chk==false) System.out.println("\n sorry, Path is not possible!");
        //if path not found

    }
}
