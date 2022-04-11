package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public class BinaryTreeNode {
        public int data;
        public BinaryTreeNode leftNode;
        public BinaryTreeNode rightNode;
        public BinaryTreeNode parentNode;

        public BinaryTreeNode (int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
            this.parentNode = null;
        }
    }

    private BinaryTreeNode rootNode;

    public BinaryTree() {
        this.rootNode = null;
    }

    public BinaryTree(int nodeData) {
        this.rootNode = new BinaryTreeNode(nodeData);
    }

    public BinaryTreeNode getRoot() {
        return this.rootNode;
    }

    public void setRoot(BinaryTreeNode node) {
        this.rootNode = node;
    }

    // Level insertion
    public void insertBT(int nodeData) {
        BinaryTreeNode node = new BinaryTreeNode(nodeData);
        if (this.rootNode == null) {
            this.rootNode = node;
            return;
        }
        Queue<BinaryTreeNode> tempQueue = new LinkedList<>();
        BinaryTreeNode temp = this.rootNode;
        tempQueue.add(temp);
        while (!tempQueue.isEmpty()) {
            temp = tempQueue.poll();
            if(temp.leftNode == null) {
                temp.leftNode = node;
                return;
            } else {
                tempQueue.add(temp.leftNode);
            }
            if (temp.rightNode == null) {
                temp.rightNode = node;
                return;
            } else {
                tempQueue.add(temp.rightNode);
            }
        }
    }

    // Binary Search Tree Insertion
    public void insertBST(int nodeData) {
        BinaryTreeNode node = new BinaryTreeNode(nodeData);
        if (this.rootNode == null) {
            this.rootNode = node;
            return;
        }
        BinaryTreeNode parentNode = null;
        BinaryTreeNode tempNode = this.rootNode;
        while (tempNode != null) {
            parentNode = tempNode;
            if (nodeData < tempNode.data)  {
                tempNode = tempNode.leftNode;
            } else {
                tempNode = tempNode.rightNode;
            }
        }
        if (nodeData <= parentNode.data) {
            parentNode.leftNode = node;
        } else {
            parentNode.rightNode = node;
        }
    }

    public BinaryTreeNode findInBST(int nodeData) {
        BinaryTreeNode parentNode = null;
        BinaryTreeNode tempNode = this.rootNode;
        while (tempNode != null) {
            if (tempNode.data == nodeData) {
                return tempNode;
            } else if (nodeData < tempNode.data) {
                tempNode = tempNode.leftNode;
            } else {
                tempNode = tempNode.rightNode;
            }
        }
        return null;
    }

    private void populateParentRec(BinaryTreeNode node, BinaryTreeNode parentNode) {
        if(node != null) {
            node.parentNode = parentNode;
            populateParentRec(node.leftNode, node);
            populateParentRec(node.rightNode, node);
        }
    }

    public void populateParent() {
        populateParentRec(this.rootNode, null);
    }

    public int getSubTreeNodeCount(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSubTreeNodeCount(node.leftNode) + getSubTreeNodeCount(node.rightNode);
        }
    }

    private BinaryTreeNode findInBTRec(BinaryTreeNode node, int nodeData) {
        if (node == null) {
            return null;
        }

        if (node.data == nodeData) {
            return node;
        }

        BinaryTreeNode leftNode = findInBTRec(node.leftNode, nodeData);
        if (leftNode != null) {
            return leftNode;
        }

        BinaryTreeNode rightNode = findInBTRec(node.rightNode, nodeData);
        return rightNode;
    }

    public BinaryTreeNode findInBT(int nodeData) {
        return findInBTRec(this.rootNode, nodeData);
    }
}
