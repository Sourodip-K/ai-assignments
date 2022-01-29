package Question1;
import java.util.*;
public class IDFS {
    private LinkedList<Integer> adj[];
    public IDFS(int v) {
        adj = new LinkedList[v];
        for(int i = 0; i<v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public boolean dfsStack(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;
        int depth=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        depth = 0;
        while(!stack.isEmpty()) {
            int cur = stack.pop();

            System.out.print(cur+" ");
            if(cur == destination) return true;
            for(int neighbor: adj[cur]) {
                if(!vis[neighbor]) {
                    vis[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();
        IDFS graph = new IDFS(v);
        System.out.println("Enter "+ e +" edges");
        for(int i = 0; i<e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }
        System.out.println("Enter source and destination");
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println("The path, if it exists is: ");
        boolean chk = graph.dfsStack(source, destination);
        if(chk==false)
            System.out.println("Sorry, no path exists between "+source+" and "+destination);

    }
}
