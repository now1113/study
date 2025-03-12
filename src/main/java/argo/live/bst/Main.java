package argo.live.bst;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("BST 중위 순회: ");
        bst.inorder(); // 20 30 40 50 60 70 80

        System.out.println("검색 (40): " + bst.search(40)); // true
        System.out.println("검색 (100): " + bst.search(100)); // false

        bst.delete(30);
        System.out.print("BST 중위 순회 (30 삭제 후): ");
        bst.inorder(); // 20 40 50 60 70 80

    }
}
