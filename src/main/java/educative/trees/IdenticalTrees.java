package educative.trees;

import datastructure.tree.BinaryTree;

public class IdenticalTrees {
    public static boolean areIdentical(BinaryTree.BinaryTreeNode root1, BinaryTree.BinaryTreeNode root2) {
        // TODO: Write - Your - Code
        return areIdenticalRec(root1, root2);
    }

    private static boolean areIdenticalRec(BinaryTree.BinaryTreeNode node1, BinaryTree.BinaryTreeNode node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.data != node2.data) {
            return false;
        } else {
            return areIdenticalRec(node1.leftNode, node2.leftNode)
                    && areIdenticalRec(node1.rightNode, node2.rightNode);
        }
    }
}
