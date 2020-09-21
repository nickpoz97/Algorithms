import java.util.*;

public class Graph {
    private Map<Integer, Node> nodesMap = new HashMap<>();
    private int[][] edges;

    public Graph(Collection<Node> nodes){
        for(Node n : nodes){
            nodesMap.put(n.getIndex(), n);
        }
        edges = new int[nodes.size()][nodes.size()];
    }

    public void connect(int i1, int i2){
        if(nodesMap.containsKey(i1) && nodesMap.containsKey(i2)){
            edges[i1][i2] = 1;
            edges[i2][i1] = 1;
        }
    }

    public void breadthFirstSearch(){
        Queue<Node> queue = new LinkedList<>();

        for(Node n : nodesMap.values()){ // for loop for unreachable nodes
            if(!n.explored){
                queue.add(n);
                n.discovered = true; // first node added
                while (!queue.isEmpty()){
                    Node actualNode = queue.remove();
                    exploreNode(queue, actualNode);
                }
            }
        }
    }

    private void exploreNode(Queue<Node> queue, Node actualNode) {
        int[] neighbors = edges[actualNode.getIndex()];
        for(int i = 0 ; i < neighbors.length ; i++) {
            if (neighbors[i] == 1) {
                Node neighbor = nodesMap.get(i);
                if(!neighbor.discovered) {
                    queue.add(neighbor);
                    neighbor.discovered = true;
                }
            }
        }
        System.out.println(actualNode);
        actualNode.explored = true;
    }
}
