public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode(6);
        bst.insertNode(8);
        bst.insertNode(9);
        bst.insertNode(5);
        bst.insertNode(4);

        bst.removeNode(6);
        bst.removeNode(5);
        bst.traverseTree();
    }
}
