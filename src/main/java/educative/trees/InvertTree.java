package educative.trees;

public class InvertTree {
    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
