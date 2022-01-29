package Question1;

import java.util.*;
//DFS to DLS where the limit is auto-increased for every level one by one detailing output for every step
public class DFStoDLS {

    /*
   BASIC REPRESENTATION OF A GRAPH USING AN ADJACENCY LIST, which is created by an array of LinkedLists.
    */
    private LinkedList<Integer> adj[];

    public DFStoDLS(int v) {
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
//    private boolean dfsUtil(int source, int destination, int limit, boolean vis[]) {
//        if(source == destination) return true; //base condition
//
//        for(int neighbor: adj[source]) { //traversing the graph
//            if(!vis[neighbor]) {
//                vis[neighbor] = true; //mark if true
//                System.out.print(neighbor + " "); //print what is visited
//
//                boolean isConnected = dfsUtil(neighbor, destination, limit+1, vis); //induction
//                if(isConnected) return true;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean dfs(int source, int destination, int limit) {
//        boolean vis[] = new boolean[adj.length];
//        //a boolean visited array is created to store true if visited
//        vis[source] = true; //mark the source to be visited
//        System.out.print ("Starting from "+source+" ");
//        return dfsUtil(source, destination, limit, vis); //call the helper function
//    }

    public void dfs(int source, int destination, int v) {
        boolean vis[] = new boolean[v];
        int depth[]; //Stores depth of vertices.
        int limit = 0;
        while(!vis[destination]) {
            vis = new boolean[v];
            depth = new int[v];
            System.out.print("For depth limit "+ limit + " ,Nodes visited: ");
            // Depth Limit Search
            dfsUtil(source, destination, limit, vis, depth);
            limit++;
            System.out.println();
        }
        if (!vis[destination]) {
            System.out.println("No, Path found");
        }
    }

    public void dfsUtil(int source, int destination, int limit, boolean vis[], int level[]) {
        vis[source] = true;
        System.out.print(source + " ");
        if(vis[destination]) {
            System.out.println("\nThe destination achieved at depth "+ level[destination]);
            return;
        }
        Iterator<Integer> i = adj[source].listIterator();
        while(i.hasNext()){
            int neighbour = i.next();
            if(vis[neighbour] == false && vis[destination] == false) {
                level[neighbour] = level[source] + 1;
                if(level[neighbour] <= limit) {
                    dfsUtil(neighbour, destination, limit, vis, level);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        //using the vertices  we create the adjacency list
        DFStoDLS graph = new DFStoDLS(v);
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
        graph.dfs(start, end, v);
        //if(chk==false) System.out.println("\n sorry, Path is not possible!");
        //if path not found

    }

}