package datastructure.tree;

import java.util.List;

public interface Tree<T> {
    class  TreeNode<T> {
        public T data;
        public List<TreeNode<T>> child;
    }

    public TreeNode<T> getRoot();

    // for normal BT level by level insertion
    public void insertBT(int key);

    // for BST insertion
    public void insert(T nodeData);

    public TreeNode<T> findInBST(int nodeData);

    public int getSubTreeNodeCount(TreeNode<T> node);

    public Tree<T> getTreeDeepCopy();

}
