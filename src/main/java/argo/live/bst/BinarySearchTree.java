package argo.live.bst;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    // 삽입(O(Log N))
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRec(node.right, value);
        }

        return node;
    }

    // 탐색 (O(Log N))
    public boolean search(T value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.equals(node.value)) {
            return true;
        } else if (value.compareTo(node.value) < 0) {
            return searchRec(node.left, value);
        } else {
            return searchRec(node.right, value);
        }
    }

    // 삭제 (O(Long N))
    public void delete(T value) {
        root = deleteRec(root, value);
    }

    private TreeNode<T> deleteRec(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = deleteRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteRec(node.right, value);
        } else {
            // 노드 삭제 로직
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // 오른쪽 서브트리에서 최솟값 찾기
            node.value = findMin(node.right);
            node.right = deleteRec(node.right, node.value);
        }

        return node;
    }

    private T findMin(TreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode<T> node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.value + " ");
            inorderRec(node.right);
        }
    }
}
