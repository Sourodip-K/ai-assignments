package Question1;

import java.util.*;
public class IDS {

    private int V;  //number of nodes

    private LinkedList<Integer> adj[]; //adjacency list

    public IDS(int V)
    {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
        {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);      //adding an edge to the adjacency list (edges are bidirectional in this example)
    }

    public void IDSrec(int s,int d) { //IDS method
        boolean visited[] = new boolean[this.V]; //initialising the visited list
        int depth[]; //Stores depth of vertices.
        int limit = 0; //initializing limit
        while(!visited[d]) { //until goal node is visited,
            //we run dls with different values for limit
            visited = new boolean[this.V];
            depth = new int[this.V];
            System.out.print("For depth limit "+ limit + " ,Nodes visited: ");
            // Depth Limit Search
            DLS(s,d,limit, visited, depth);//calls the dls recursive method
            limit++; //increase the limit by 1
            System.out.println();
        }
    }

    public void DLS(int s, int d, int limit, boolean visited[], int depth[]) {
        visited[s] = true; //setting the start node as visited
        System.out.print(s+" "); //print the current node
        if(visited[d]) { //if visited we quit this function and return
            System.out.println("\nThe destination achieved at depth "+ depth[d]);
            return;
        }
        Iterator<Integer> i = adj[s].listIterator();
        while(i.hasNext()) {
            int x = i.next();
            if(visited[x] == false && visited[d] == false) {
                //if neighbour node is not visited and goal node is also not explored
                depth[x] = depth[s] + 1;
                //assigning depth of x
                if(depth[x] <= limit) {
                    //if depth of x is less than limit then recursively call DLS again
                    //but start node as x now
                    DLS(x, d, limit, visited, depth);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        IDS adj = new IDS(v);
        System.out.println("Enter the verices b/w which edge is present: ");
        for(int i=0;i<e;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.addEdge(x, y);
        }
        System.out.println("Enter the start node: ");
        int s = sc.nextInt();
        System.out.println("Enter the destination node: ");
        int d = sc.nextInt();
        //System.out.println("The order of nodes visited: ");
        adj.IDSrec(s, d);

    }

}
