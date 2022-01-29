package Question1;
import java.util.*;
public class BFS {
    /*
    BASIC REPRESENTATION OF A GRAPH USING AN ADJACENCY LIST, which is created by an array of LinkedLists.
     */
    private LinkedList<Integer> adj[];

    public BFS(int v) {
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

    public int bfs(int source, int destination) {
        boolean visited[] =new boolean[adj.length];
        //will return true of false if a current vertex has been visited
        int parent[]= new int[adj.length];
        //stores who's parent is who?
        Queue<Integer> q = new LinkedList<>();
        q.add(source); //add the source to the queue that is to be visited
        parent[source]=-1; //beginning so -1
        visited[source]=true; //make the source visited to be true
        //unless the queue is empty
        while(!q.isEmpty()) {
        int cur = q.poll();
        if(cur == destination)
            break;
        for(int neighbour: adj[cur]) {
            if(!visited[neighbour]) {
                //mark the visited node to be true
                visited[neighbour]=true;
                //add it into the queue
                q.add(neighbour);
                //store the current vertex as
                parent[neighbour]=cur;
                 }
            }
        }
        int cur = destination; //traversing the parent from destination -> source
        int cost = 0;
            while(parent[cur]!=-1) {
             System.out.print(cur+" -> ");
             cur= parent[cur];
            cost++;
        }
        System.out.print(source);
        return cost;
    }

    //main function to take input from the user
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        //using the vertices  we create the adjacency list
        BFS graph = new BFS(v);
        System.out.println("Enter the edges: ");
        for(int i=0; i<e; i++) {
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
        int cost = graph.bfs(start, end);
        //call the bfs function and store the cost that is returned
        //System.out.println("\n Minimum Cost to traverse is: "+cost);
    }
}

