package educative.trees;

import datastructure.tree.BinaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InorderIterator {
    private Queue<BinaryTreeNode> inorderNodes;
    public InorderIterator(BinaryTreeNode root) {
        inorderNodes = new LinkedList<>();
        convertInorder(root, inorderNodes);

    }

    private void convertInorder(BinaryTreeNode node, Queue<BinaryTreeNode> result) {
        if (node == null) {
            return;
        }
        convertInorder(node.leftNode, result);
        result.add(node);
        convertInorder(node.rightNode, result);
    }

    public boolean hasNext() {
        return !inorderNodes.isEmpty();
    }

    public BinaryTreeNode getNext() {
        return inorderNodes.poll();
    }

    // Iterator helper function (Don't modify it)
    // This function returns the in-order list of nodes using the hasNext() and
    // getNext() methods
    public String inorderUsingIterator(BinaryTreeNode root) {
        InorderIterator iter = new InorderIterator(root);
        String result = "";
        while (iter.hasNext()) {
            result += iter.getNext().data;
            if (iter.hasNext()) {
                result += ", ";
            }
        }
        if (result == "") {
            result = "null";
        } else if (result.contains(", ")) {
            result.substring(0, result.length() - 2);
        }
        return result;
    }
}
