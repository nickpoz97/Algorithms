import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Node> nodes = new HashSet<>();

        for(int i = 0 ; i < 8 ; i++){
            nodes.add(new Node());
        }

        Graph graph = new Graph(nodes);
        graph.connect(0,1);
        graph.connect(1,2);
        graph.connect(2,3);
        graph.connect(2,3);
        graph.connect(3,4);
        graph.connect(4,5);
        graph.connect(5,0);
        graph.connect(1,6);
        graph.connect(3,6);

        graph.breadthFirstSearch();
    }
}
