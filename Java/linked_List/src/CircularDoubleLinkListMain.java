public class CircularDoubleLinkListMain {
    public static void main(String[] args) {
        LinkedList list = new DoubleCircularLinkedList();
        list.insertNode(2, 1);
        list.insertNode(1, 0);
        list.insertNode(8, 16);
        list.insertNode(4, 2);
        list.insertNode(3, 1);

        list.deleteNode(6);
        list.deleteNode(0);
        list.deleteNode(1); // 3->4

        list.traverseList();
        list.traverseListReversed();

        list.searchNode(4);
        list.searchNode(7);
    }
}
