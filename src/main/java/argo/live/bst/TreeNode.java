package argo.live.bst;

public class TreeNode<T extends Comparable<T>> {

    T value;
    TreeNode<T> left, right;

    public TreeNode(T value) {
        this.value = value;
        this.left = this.right = null;
    }
}
