public class DoubleNode extends Node{
    private Node prev = null;

    public DoubleNode(int value){
        super(value);
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }
}
