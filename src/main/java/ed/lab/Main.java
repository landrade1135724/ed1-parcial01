package ed.lab;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Ejemplo 1.1:
        Integer[] arr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode<Integer> root1 = buildTree(arr1);
        E01FlattenBT solver = new E01FlattenBT();
        solver.flatten(root1);
        System.out.println("Resultado Eje 1.1:");
        printFlattened(root1);

        // Ejemplo 1.2: Árbol vacío
        Integer[] arr2 = {};
        TreeNode<Integer> root2 = buildTree(arr2);
        solver.flatten(root2);
        System.out.println("\nResultado Eje 1.2:");
        printFlattened(root2);

        // Ejemplo Eje 1.3:
        Integer[] arr3 = {0};
        TreeNode<Integer> root3 = buildTree(arr3);
        solver.flatten(root3);
        System.out.println("\nResultado Eje 1.3:");
        printFlattened(root3);
    }

    public static TreeNode<Integer> buildTree(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(arr[0]);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode<Integer> current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode<>(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode<>(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printFlattened(TreeNode<Integer> root) {
        System.out.print("[");
        TreeNode<Integer> current = root;
        boolean first = true;
        while (current != null) {
            if (!first) {
                System.out.print(", null, " + current.value);
            } else {
                System.out.print(current.value);
                first = false;
            }
            current = current.right;
        }
        System.out.println("]");
    }
}
