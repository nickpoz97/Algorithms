public class SingleLinkListMain {
    public static void main(String[] args) {
        LinkedList list = new SingleLinkedList();
        list.insertNode(2, 1);
        list.insertNode(1, 0);
        list.insertNode(8, 16);
        list.insertNode(4, 2);
        list.insertNode(3, 1);

        list.deleteNode(1);
        list.deleteNode(5);

        list.searchNode(8);
        list.searchNode(2);

        list.deleteList();

        list.traverseList();
    }
}
