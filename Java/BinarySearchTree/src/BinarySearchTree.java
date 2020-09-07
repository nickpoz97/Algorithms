import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(){
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
        return actualNode;
    }

    private void addChidrenToQueue(Queue<TreeNode> queue, TreeNode actualNode) {
        if(actualNode.getLeft() != null){
            queue.add(actualNode.getLeft());
        }
        if(actualNode.getRight() != null){
            queue.add(actualNode.getRight());
        }
    }

    public void removeNode(int value){
        TreeNode nodeToRemove = searchNode(value);

        if(nodeToRemove == null){ return; }
        if(nodeToRemove == root && root.numberOfChildren() == 0){
            deleteTree();
            return;
        }

        else if(nodeToRemove.numberOfChildren() < 2){
            removeNodeWithMaxOneChild(nodeToRemove);
        }
        else{
            TreeNode successor = findSuccessor(nodeToRemove);
            nodeToRemove.setValue(successor.getValue());
            removeNodeWithMaxOneChild(successor); // successor can have at most a right child
        }
    }

    private void removeNodeWithMaxOneChild(TreeNode nodeToRemove) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode actualNode = queue.remove();
            if(actualNode.getLeft() == nodeToRemove){
                if(nodeToRemove.getRight() != null){
                    actualNode.setLeft(nodeToRemove.getRight());
                    return;
                }
                else if(nodeToRemove.getLeft() != null){
                    actualNode.setLeft(nodeToRemove.getLeft());
                    return;
                }
                else{
                    actualNode.setLeft(null);
                    return;
                }
            }
            if(actualNode.getRight() == nodeToRemove){
                if(nodeToRemove.getRight() != null){
                    actualNode.setRight(nodeToRemove.getRight());
                    return;
                }
                else if(nodeToRemove.getLeft() != null){
                    actualNode.setRight(nodeToRemove.getLeft());
                    return;
                }
                else{
                    actualNode.setRight(null);
                    return;
                }
            }
            addChidrenToQueue(queue, actualNode);
        }
    }

    private TreeNode findSuccessor(TreeNode actualNode){
        TreeNode candidate = actualNode.getRight();

        while (candidate.getLeft() != null){
            candidate = candidate.getLeft();
        }

        return candidate; // no more a candidate
    }
}
