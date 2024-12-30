package educative.trees;

public class MaxPathSum {
    private static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode<Integer> root) {
        maxSum = Integer.MIN_VALUE;
        traverse(root);
        return maxSum;
    }

    private static int traverse(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftData = traverse(root.left);
        int rightData = traverse(root.right);
        leftData = Math.max(leftData, 0);
        rightData = Math.max(rightData, 0);
        int sum = leftData + rightData + root.data;
        maxSum = Math.max(maxSum, sum);
        return root.data + Math.max(leftData, rightData);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(-10);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(12);
        root.left.right = new TreeNode<>(11);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(7);
        System.out.println("Sum: " + maxPathSum(root));
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
