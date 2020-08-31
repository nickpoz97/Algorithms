public abstract class LinkedList {
    protected Node tail;
    protected Node head;
    protected int length = 0;

    public abstract void insertNode(int value, int position);
    public abstract void deleteNode(int position);
    public abstract boolean searchNode(int position);
    public abstract void traverseList();
    public abstract void deleteList();
}
