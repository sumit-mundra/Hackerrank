package graphtheory;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach/problem
 */
public class BreadthFirstSearch {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = -1;
        }

        List<Set<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbours.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            // handshake
            neighbours.get(edges[i][0] - 1).add(edges[i][1] - 1);
            neighbours.get(edges[i][1] - 1).add(edges[i][0] - 1);
        }
        bfs_visit(s - 1, neighbours, parent, visited);
        int[] dist = new int[n - 1];
        int l = 0;
        int k = 0;
        while (l < n - 1 && k < n) {
            if (k != s - 1) {
                dist[l++] = getDist(s - 1, k, parent);
            }
            k++;
        }
        return dist;
    }

    private static void bfs_visit(int s, List<Set<Integer>> neighboursList, int[] parent, int[] discovered) {
        Queue<Integer> toSee = new LinkedList<>();
        toSee.offer(s);
        parent[s] = -1;
        discovered[s] = 1;
        while (toSee.size() != 0) {
            int currentNode = toSee.poll();
            Set<Integer> neighbours = neighboursList.get(currentNode);
            for (Integer neighbour : neighbours) {
                if (discovered[neighbour] == -1) {
                    toSee.offer(neighbour);
                    parent[neighbour] = currentNode;
                    discovered[neighbour] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    private static int getDist(int source, int target, int[] parent) {
        int k = target;
        int result = 0;
        boolean disconnected = false;

        while (k != source) {
            int newK = parent[k];
            if (parent[k] != -1) {
                k = newK;
                result += 6;
            } else {
                disconnected = true;
                break;
            }
        }
        return disconnected ? -1 : result;
    }
}
