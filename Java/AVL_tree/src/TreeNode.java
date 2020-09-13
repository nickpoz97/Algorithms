public class TreeNode {
    private int value;
    private int height;

    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(int value){
        this.height = 0; // leaf node on creation
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

    public int getHeight(){
        return this.height;
    }

    public int getLeftHeight(){
        return (left == null) ? -1 : left.getHeight();
    }

    public int getRightHeight(){
        return (right == null) ? -1 : right.getHeight();
    }

    public void updateHeigth(){
        this.height = Math.max(getLeftHeight(), getRightHeight()) + 1;
    }
}
