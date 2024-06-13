import java.util.*;
import java.util.LinkedList;

public class GraphDFS {
    private Map<Integer,List<Integer>>hash;
    public GraphDFS(){
        this.hash=new HashMap<>();
    }
    public void addVertex(int vertex){
        hash.putIfAbsent(vertex,new ArrayList<>());
    }
    public void addUndirectedEdge(int src,int dest){
        hash.putIfAbsent(src,new ArrayList<>());
        hash.putIfAbsent(dest,new ArrayList<>());
        hash.get(src).add(dest);
        hash.get(dest).add(src);
    }
    public void printGraph(){
        for(int vertex:hash.keySet()){
            System.out.print(vertex+"->");
            for(int neighbors:hash.get(vertex)){
                System.out.print(neighbors+" ");
            }
            System.out.println();
        }
    }
    public void dfsRecursion(int startVertex){
        Set<Integer> set=new HashSet<>();
        dfsHelper(startVertex,set);
    }
    public void dfsHelper(int vertex,Set<Integer> visited){
        visited.add(vertex);
        System.out.print(vertex+" ");
        for(int neighbor:hash.get(vertex)){
            if(!visited.contains(neighbor)){
                dfsHelper(neighbor,visited);
            }
        }
    }
    public void dfsIterative(int startVertex){
        HashSet<Integer> visited=new HashSet<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(startVertex);
        visited.add(startVertex);
        while(!stack.isEmpty()){
            int vertex=stack.pop();
            System.out.print(vertex+" ");
            for(int neighbor:hash.get(vertex)){
                if(!visited.contains(neighbor)){
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args){
        GraphDFS graph=new GraphDFS();
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
        graph.dfsRecursion(0);
        System.out.println();
        graph.dfsIterative(0);
    }
}
