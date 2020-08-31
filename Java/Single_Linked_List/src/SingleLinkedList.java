public class SingleLinkedList extends LinkedList{
    public SingleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void insertNode(int value, int position) {
        Node newNode = new Node(value);

        if(this.head == null || position == 0){ // empty list
            insertOnHead(newNode);
        }

        else if(position >= this.length){ // if position is out of bound we place it on tail
            insertOnTail(newNode);
        }

        else{
            insertInside(position, newNode);
        }

        this.length++;
    }

    private void insertInside(int position, Node newNode) {
        Node tempNode = this.head;

        for (int i = 0 ; i < position - 1 ; i++){ // loop until the node before position
            tempNode = tempNode.getPointer();
        }

        newNode.setPointer(tempNode.getPointer());
        tempNode.setPointer(newNode);
    }

    private void insertOnTail(Node newNode){
        tail.setPointer(newNode);
        newNode.setPointer(null); // optional
        tail = newNode;
    }

    private void insertOnHead(Node newNode){
        if(this.head == null){ // empty list
            this.tail = newNode;
        }

        newNode.setPointer(this.head);
        this.head = newNode;
    }

    @Override
    public void deleteNode(int position) {
        if(this.length == 0){
            System.out.println("Empty list");
            return;
        }

        if(this.length == 1){ // only one element
            deleteList();
        }
        else if (position >= this.length){ // if position is out of bound then delete last
            deleteLastNode();
        }
        else {
            deleteInside(position);
        }

        this.length--;
    }

    public void deleteInside(int position) {
        Node tempNode = this.head;

        for (int i = 0 ; i < position - 1 ; i++){ // loop until the node before position
            tempNode = tempNode.getPointer();
        }

        tempNode.setPointer(tempNode.getPointer().getPointer());
    }

    public void deleteList() {
        this.head = null;
        this.tail = null;
    }

    private void deleteLastNode() {
        Node tempNode = this.head;

        while(tempNode.getPointer() != this.tail){
            tempNode = tempNode.getPointer();
        }
        tempNode.setPointer(null);
    }

    @Override
    public boolean searchNode(int value) {
        Node tempNode = this.head;

        while (tempNode!=null){
            if(tempNode.getValue() == value){
                System.out.println("node found");
                return true;
            }
            else{
                tempNode = tempNode.getPointer();
            }
        }

        System.out.println("node not found");
        return false;
    }

    @Override
    public void traverseList() {
        Node tempNode = this.head;
        while (tempNode != null){
            System.out.print(tempNode.getValue() + " -> ");
            tempNode = tempNode.getPointer();
        }
    }
}
