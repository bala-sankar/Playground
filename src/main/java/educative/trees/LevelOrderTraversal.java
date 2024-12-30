package educative.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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

    public static String levelOrderTraversal(TreeNode<Integer> root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }

        Queue<TreeNode<Integer>> currentQueue = new LinkedList<>();
        currentQueue.add(root);

        Queue<TreeNode<Integer>> nextQueue = new LinkedList<>();

        while (!currentQueue.isEmpty()) {
            TreeNode<Integer> currentNode = currentQueue.poll();
            result.append(currentNode.data);
            if (currentNode.left != null) {
                nextQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nextQueue.add(currentNode.right);
            }
            if (!currentQueue.isEmpty()) {
                result.append(", ");
            }
            if (currentQueue.isEmpty() && !nextQueue.isEmpty()) {
                result.append(":");
                currentQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        return result.toString();
    }
}
