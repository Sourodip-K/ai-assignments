import java.util.*;
public class DLS {

    private int V;  //number of nodes

    private LinkedList<Integer> adj[]; //adjacency list

    public DLS(int V)
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
        adj[v].add(w);
    }


    public void dls(int s, int d, int limit, boolean visited[], int depth[]) {
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
                    dls(x, d, limit, visited, depth);
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
        DLS adj = new DLS(v);
        boolean visited[] = new boolean[v];
        int depth[] = new int[v]; //Stores depth of vertex v.
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
        System.out.println("Enter the Depth Limit: ");
        int limit = sc.nextInt();
        System.out.println("The order of nodes visited: ");
        adj.dls(s, d, limit, visited, depth);
        if(visited[d] == false) {
            System.out.println("Goal Not Reached");
        }

    }

}