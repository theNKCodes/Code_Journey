//It is evolved version on BT
// Time Complexity in BST is O(N) where N is no. of nodes.
// In average Height of tree become log(N) then BST is much faster.
/*
 * Properties :
 *  1) Follows all properties of BT.
 *  2) Left Subtree Nodes < Root.
 *  3) Right Subtree Nodes > Root.
 *  4) Left & Right subtrees are also BST with no duplicates.
 */
/* Special Property -
    - Inorder Traversal of BST gives a sorted sequence always.
 */
/* Build a BST :
 *  Simplest method is like first make root and insert your corresponding value in it.
 *  Then if upcoming value for nodes is less than root then it goes to left 
 *  else if it greater then it will go to the right. 
 *  Checking of root is for every node in tree while inserting or building.
 */
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " -> ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 11, 45, 21, 9, 56, 41, 5 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.print("\nInorder Traversal : ");
        inorder(root);
        System.out.println("NULL");
    }
}
