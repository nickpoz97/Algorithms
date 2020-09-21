import java.util.Objects;
import java.util.Random;

public class Node implements Comparable<Node>{
    private static int maxIndex = -1; // augmented on each node creation
    private final static Random generator = new Random();

    private int value;
    private int index;

    protected boolean explored = false;
    protected boolean discovered = false;

    public Node(){
        value = generator.nextInt(101);
        index = ++maxIndex;
    }

    public Node(int value){
        this.value = value;
        index = ++maxIndex;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Node && ((Node) o).index == this.index){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.index;
    }

    @Override
    public int compareTo(Node o) {
        return this.index - o.index;
    }

    public int getIndex() {
        return index;
    }
}
