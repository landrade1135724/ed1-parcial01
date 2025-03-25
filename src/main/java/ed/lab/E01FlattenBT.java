package ed.lab;

public class E01FlattenBT {

    public void flatten(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode<Integer> left = root.left;
        TreeNode<Integer> right = root.right;

        root.left = null;

        root.right = left;

        TreeNode<Integer> current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = right;
    }
}
