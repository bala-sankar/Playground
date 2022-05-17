package educative.trees;

import datastructure.tree.BinaryTree.BinaryTreeNode;

import java.util.Queue;

public class InorderSuccessor {
    static BinaryTreeNode findInorderSuccessor(BinaryTreeNode root, int nodeValue) {
        BinaryTreeNode parentNode = null;
        BinaryTreeNode tempNode = root;
        while (tempNode != null) {
            if (tempNode.data == nodeValue) {
                if (tempNode.rightNode != null) {
                    return tempNode.rightNode;
                }
                return parentNode;
            } else if (nodeValue < tempNode.data) {
                parentNode = tempNode;
                tempNode = tempNode.leftNode;
            } else {
                parentNode = tempNode;
                tempNode = tempNode.rightNode;
            }
        }
        return null;
    }

//    private BinaryTreeNode traverseInorder(BinaryTreeNode node, int nodeValue) {
//        if (node == null) {
//            return null;
//        }
//        convertInorder(node.leftNode, result);
//        result.add(node);
//        convertInorder(node.rightNode, result);
//    }


}
