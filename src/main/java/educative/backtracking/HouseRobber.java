package educative.backtracking;

public class HouseRobber {
    public static int rob(TreeNode<Integer> root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] robHelper(TreeNode<Integer> root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] result = new int[2];
        result[0] = root.data + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }

    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        TreeNode<Integer> root = houseRobber.new TreeNode<>(3);
        root.left = houseRobber.new TreeNode<>(5);
        root.left.left = houseRobber.new TreeNode<>(10);
        root.left.right = houseRobber.new TreeNode<>(12);
        root.right = houseRobber.new TreeNode<>(25);
        root.right.left = houseRobber.new TreeNode<>(3);
        root.right.right = houseRobber.new TreeNode<>(1);
        System.out.println(rob(root));
    }
}
