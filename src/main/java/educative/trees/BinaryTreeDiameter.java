package educative.trees;

public class BinaryTreeDiameter {
    private static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        diameter = 0;
        int rootHeight = height(root);
        return diameter;
    }
    // 3 -> 20 -> 7
    // |-> 9
    private static int height(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(15);
        root.left.right = new TreeNode<>(7);
        System.out.println("Diameter: " + diameterOfBinaryTree(root));
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
