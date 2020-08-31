public class Node {
    private int value;
    private Node pointer;

    public Node(int value){
        this.value = value;
        this.pointer = null;
    }

    public Node getPointer(){
        return pointer;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setPointer(Node pointer){
        this.pointer = pointer;
    }
}
