public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(50);
        tree.insertNode(60);
        tree.insertNode(70);
        tree.insertNode(65);
        tree.traverseTree();
    }
}
