public abstract class LinkedList {
    protected Node tail;
    protected Node head;
    protected int length = 0;

    public abstract void insertNode(int value, int position);
    public abstract void deleteNode(int position);
    public abstract boolean searchNode(int value);
    public abstract void traverseList();
    public abstract void deleteList();

    public void traverseListReversed(){
        System.out.println("Only available on circular double linked list");
    }
}
