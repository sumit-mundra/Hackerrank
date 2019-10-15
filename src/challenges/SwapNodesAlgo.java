package challenges;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/*
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 */
public class SwapNodesAlgo {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {

        int n = indexes.length;

        Node[] nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < indexes.length; i++) {
            int[] pair = indexes[i];
            if (pair[0] != -1) {
                nodes[i].left = nodes[pair[0] - 1];
            }
            if (pair[1] != -1) {
                nodes[i].right = nodes[pair[1] - 1];
            }
        }

        int[][] result = new int[queries.length][];
        int k = 0;
        for (int query : queries) {
            result[k++] = swapNodeForQuery(nodes, query);
        }
        return result;
    }

    private static int[] swapNodeForQuery(Node[] nodes, int query) {
        int depth = 1;
        List<Node> stack = new ArrayList<>();
        stack.add(nodes[0]);
        while (stack.size() > 0) {
            List<Node> newStack = new ArrayList<>();
            for (Node node : stack) {
                if (node.left != null)
                    newStack.add(node.left);
                if (node.right != null)
                    newStack.add(node.right);
                if (depth % query == 0) {
                    swapChildren(node);
                }
            }
            depth++;
            stack = newStack;
        }
        return inorderTraverse(nodes);
    }


    private static int[] inorderTraverse(Node[] nodes) {
        Deque<Node> stack = new ArrayDeque<>();
        populateNodeAndLeftSubtreeInStack(stack, nodes[0]);
        List<Integer> result = new ArrayList<>();
        while (stack.size() != 0) {
            Node top = stack.remove();
            result.add(top.data);
            populateNodeAndLeftSubtreeInStack(stack, top.right);
        }
        int[] finalResult = new int[result.size()];
        int k = 0;
        for (Integer data : result) {
            finalResult[k++] = data;
        }
        return finalResult;
    }

    private static void populateNodeAndLeftSubtreeInStack(Deque<Node> stack, Node rootNode) {
        while (rootNode != null) {
            stack.offerFirst(rootNode);
            rootNode = rootNode.left;
        }
    }

    private static void swapChildren(Node node) {
        if (node != null) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }


}
