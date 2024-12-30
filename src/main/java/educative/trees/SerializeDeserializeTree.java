package educative.trees;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeTree {
    public static List<String> serialize(TreeNode<Integer> root) {
        return serializeHelper(root, new ArrayList<String>());
    }

    static List<String> serializeHelper(TreeNode<Integer> root, List<String> stream) {
        if (root == null) {
            stream.add("null");
            return stream;
        }
        stream.add(String.valueOf(root.data));
        serializeHelper(root.left, stream);
        serializeHelper(root.right, stream);
        return stream;
    }
    public static TreeNode<Integer> deserialize(List<String> stream){
        if (stream.isEmpty()) {
            return null;
        }
        String data = stream.remove(0);
        if (data.equals("null")) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(Integer.parseInt(data));
        root.left = deserialize(stream);
        root.right = deserialize(stream);
        return root;
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
