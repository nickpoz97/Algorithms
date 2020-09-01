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
        if (length == 0){
            System.out.println("list is empty");
            return;
        }
        else if(this.length == 1) { // only one node -> delete list
            deleteList();
        }
        else if (position == 0){ // delete first node
            deleteHead();
        }
        else if (position >= length){
            deleteTail();
        }
        else{
            deleteInside(position);
        }

        length--;
    }

    private void deleteInside(int position) {
        DoubleNode tempNode = (DoubleNode) head;
        for (int i = 0; i < position - 1 ; i++){
            tempNode = (DoubleNode) tempNode.getNext();
        }
        tempNode.setNext(tempNode.getNext().getNext());
        ((DoubleNode) tempNode.getNext()).setPrev(tempNode);
    }

    private void deleteTail(){
        tail = ((DoubleNode) tail).getPrev(); // new tail
        tail.setNext(head);
        ((DoubleNode) head).setPrev(tail);
    }

    private void deleteHead() {
        ((DoubleNode) head.getNext()).setPrev(tail);
        tail.setNext(head.getNext());
        head = head.getNext();
    }

    @Override
    public boolean searchNode(int value) {
        if(head == null){
            System.out.println("value NOT present");
            return false;
        }

        Node tempNode = head;
        for(int i = 0 ; i < length ; i++){
            if(tempNode.getValue() == value){
                System.out.println("value present");
                return true;
            }
            else{
                tempNode = tempNode.getNext();
            }
        }

        System.out.println("value NOT present");
        return false;
    }

    @Override
    public void traverseList() {
        if(this.head == null) return;

        Node tempNode = this.head;
        do{
            System.out.println(tempNode.getValue() + " -> ");
            tempNode = tempNode.getNext();
        }
        while(tempNode != this.head);
    }

    @Override
    public void traverseListReversed() {
        if(this.tail == null) return;

        DoubleNode tempNode = (DoubleNode) this.tail;
        do{
            System.out.println(tempNode.getValue() + " -> ");
            tempNode = (DoubleNode) tempNode.getPrev();
        }
        while (tempNode != this.tail);
    }

    @Override
    public void deleteList() {
        head = null;
        tail = null;
    }
}
