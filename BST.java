public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root,int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val < root.data) {
            root.left = buildBST(root.left, val);
        }
        else {
            root.right = buildBST(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        if(root.data < key) {
            return search(root.right, key);
        }

        return false;
    }
    public static void main(String args[]) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for(int i=0; i<values.length; i++) {
            root = buildBST(root, values[i]);
        }
        inorder(root);
        System.out.println();
        System.out.println(search(root, 7));
    }
}
