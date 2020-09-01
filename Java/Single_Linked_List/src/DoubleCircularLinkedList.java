public class DoubleCircularLinkedList extends LinkedList{
    public DoubleCircularLinkedList(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void insertNode(int value, int position) {
        DoubleNode newNode = new DoubleNode(value);

        if(this.length == 0) { // empty list
            createList(newNode);
        }

        else if(position == 0) { // insert on head
            insertOnHead(newNode);
        }

        else if(position >= length){ // insert on tail
            insertOnTail(newNode);
        }
        else{
            insertInside(position, newNode);
        }

        length++;
    }

    private void insertInside(int position, DoubleNode newNode) {
        DoubleNode tempNode = (DoubleNode) head; // node 0

        for (int i = 0; i < position -1 ; i++){ // for every iteration we are 1 node above
            tempNode = (DoubleNode) tempNode.getNext();
        }

        newNode.setPrev(tempNode);
        newNode.setNext(tempNode.getNext());
        ((DoubleNode)tempNode.getNext()).setPrev(newNode);
        tempNode.setNext(newNode);
    }

    private void createList(DoubleNode newNode) {
        newNode.setNext(newNode);
        newNode.setPrev(newNode);
        this.head = newNode;
        this.tail = newNode;
    }

    private void insertOnHead(DoubleNode newNode) {
        newNode.setNext(head);
        newNode.setPrev(tail);
        ((DoubleNode) head).setPrev(newNode);
        ((DoubleNode) tail).setNext(newNode);
        head = newNode;
    }

    private void insertOnTail(DoubleNode newNode) {
        newNode.setPrev(tail);
        newNode.setNext(head);
        ((DoubleNode) tail).setNext(newNode);
        ((DoubleNode) head).setPrev(newNode);
        tail = newNode;
    }

    @Override
    public void deleteNode(int position) {
        length--;
    }

    @Override
    public boolean searchNode(int position) {
        return false;
    }

    @Override
    public void traverseList() {

    }

    @Override
    public void deleteList() {

    }
}
