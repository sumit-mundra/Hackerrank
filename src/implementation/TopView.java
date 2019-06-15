package implementation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {
    static class Data {
        int data;
        int height;

        Data(int data, int height){
            this.data = data;
            this.height = height;
        }
    }
    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        Map<Integer, Data> map = new TreeMap<>();
        inOrderTravel(root, 0, 0, map);
        StringBuffer sb = new StringBuffer();
        for (Data store : map.values()){
            sb.append(store.data + " ");
        }
        System.out.println(sb.toString().trim());
    }



    static void inOrderTravel(Node root, int verticalOrder, int height, Map<Integer, Data> map) {
        if (root.left != null)
            inOrderTravel(root.left, verticalOrder - 1, height + 1, map);
        if (map.get(verticalOrder) == null) {
            map.put(verticalOrder, new Data(root.data, height));
        } else {
            Data dataStore = map.get(verticalOrder);
            if ( dataStore.height > height) {
                map.put(verticalOrder, new Data(root.data, height));
            }
        }
        if (root.right != null)
            inOrderTravel(root.right, verticalOrder + 1, height + 1, map);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}