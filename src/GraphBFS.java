import java.util.*;
import java.util.LinkedList;

public class GraphBFS {
    private Map<Integer,List<Integer>> hash;
    public GraphBFS(){
        this.hash=new HashMap<>();
    }
    public void addVertex(int vertex){
        hash.putIfAbsent(vertex,new ArrayList<>());
    }
    //Directed
    public void addDirectedEdge(int src,int dest){
        hash.putIfAbsent(src,new ArrayList<>());
        hash.putIfAbsent(src,new ArrayList<>());
        hash.get(src).add(dest);
    }
    //Undirected
    public void addUndirectedEdge(int src,int dest){
        hash.putIfAbsent(src,new ArrayList<>());
        hash.putIfAbsent(src,new ArrayList<>());
        hash.get(src).add(dest);
        hash.get(dest).add(src);
    }
    public void printGraph() {
        for (int vertex : hash.keySet()) {
            System.out.print(vertex + " -> ");
            for (int neighbor : hash.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    public void bfs(int startNode){
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(startNode);
        visited.add(startNode);
        while(!queue.isEmpty()){
            int vertex= queue.poll();
            System.out.print(vertex+" ");
            for(int neighbor:hash.get(vertex)){
                if(!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(2, 0);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 3);
        System.out.println("Graph:");
        graph.printGraph();
        graph.bfs(0);
    }
}
