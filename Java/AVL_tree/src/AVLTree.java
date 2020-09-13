import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    private TreeNode root;

    public AVLTree(){
        root = null;
    }

    public void deleteTree(){
        root = null;
    }

    public void traverseTree(){
        if(root == null){return;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode actualNode = queue.remove();

            System.out.print(actualNode.getValue() + ", ");
            addChidrenToQueue(queue, actualNode);
        }

        System.out.println();
    }

    public TreeNode searchNode(int value){
        TreeNode actualNode = root;

        while(actualNode != null){
            if(actualNode.getValue() == value){
                return actualNode;
            }
            else if(value > actualNode.getValue()){
                actualNode = actualNode.getRight();
            }
            else{
                actualNode = actualNode.getLeft();
            }
        }
        return null; // this node does not exists
    }

    private void addChidrenToQueue(Queue<TreeNode> queue, TreeNode actualNode) {
        if(actualNode.getLeft() != null){
            queue.add(actualNode.getLeft());
        }
        if(actualNode.getRight() != null){
            queue.add(actualNode.getRight());
        }
    }

    public void insertNode(int value){
        TreeNode newNode = new TreeNode(value);
        root = insertNodeAtPosition(root, newNode);
    }

    private TreeNode insertNodeAtPosition(TreeNode actualNode, TreeNode newNode) {
        if(actualNode == null){
            actualNode = newNode;
        }
        else if (newNode.getValue() > actualNode.getValue()){
            actualNode.setRight(insertNodeAtPosition(actualNode.getRight(), newNode));
        }
        else{
            actualNode.setLeft(insertNodeAtPosition(actualNode.getLeft(), newNode));
        }
        actualNode.updateHeigth();
        actualNode = balanceNode(actualNode);
        return actualNode;
    }

    private TreeNode balanceNode(TreeNode node) {
        int balance = node.getLeftHeight() - node.getRightHeight();

        if(balance > 1){ // left subtree overloaded
            if(node.getLeft().getLeftHeight() > node.getLeft().getRightHeight()){ // LL case
                node = rightRotate(node);
            }
            else{ // LR case
                node.setLeft(leftRotate(node.getLeft()));
                node = rightRotate(node);
            }
        }
        else if(balance < -1){ // right subtree overloaded
            if(node.getRight().getRightHeight() > node.getRight().getLeftHeight()) { // RR case
                node = leftRotate(node);
            }
            else{ // RL case
                node.setRight(rightRotate(node.getRight()));
                node = leftRotate(node);
            }
        }

        return node;
    }

    private TreeNode rightRotate(TreeNode oldRoot){
        TreeNode newRoot = oldRoot.getLeft(); // store temporary the new root
        // old root is greater than newRoot right child (and it is greater than newroot since it is on the right)
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);

        oldRoot.updateHeigth();
        newRoot.updateHeigth();
        return newRoot;
    }

    private TreeNode leftRotate(TreeNode oldRoot){
        TreeNode newRoot = oldRoot.getRight();
        // newroot left child is greater than oldroot (and it is smaller than newroot)
        oldRoot.setRight(newRoot.getLeft());
        newRoot.setLeft(oldRoot);

        oldRoot.updateHeigth();
        newRoot.updateHeigth();
        return newRoot;
    }
}
