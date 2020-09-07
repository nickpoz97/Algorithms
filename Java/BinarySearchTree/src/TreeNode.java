public class TreeNode {
    private int value;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(int value){
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int numberOfChildren(){
        if(this.left == null && this.right == null){
            return 0;
        }
        else if(this.left == null || this.right == null){
            return 1;
        }
        else{
            return 2;
        }
    }
}
