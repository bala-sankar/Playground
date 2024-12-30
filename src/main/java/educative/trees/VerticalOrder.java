package educative.trees;

import java.util.*;

public class VerticalOrder {
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

    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        nodeQueue.add(root);
        colQueue.add(0);
        int minCol = 0, maxCol = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode<Integer> node = nodeQueue.poll();
            int col = colQueue.poll();
            colMap.computeIfAbsent(col, k -> new ArrayList<>()).add(node.data);
            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(col - 1);
                minCol = Math.min(minCol, col - 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(col + 1);
                maxCol = Math.max(maxCol, col + 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            result.add(colMap.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(15);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(11);
        root.right.right = new TreeNode<>(7);
        List<List<Integer>> result = verticalOrder(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
