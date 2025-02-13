import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static final int MAX_POSITION = 100000;

    public static class Node implements Comparable<Node>{
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] visited = new int[MAX_POSITION+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(N, 0));

        while(!pq.isEmpty()) {
            Node tmp = pq.poll();

            int curP = tmp.position;
            int curT = tmp.time;

            if (visited[curP] == 1) continue;
            visited[curP] = 1;

            if (curP == K) {
                System.out.println(curT);
                return;
            }

            if (curP > 0) {
                pq.offer(new Node(curP-1, curT+1));
            }
            if (curP < MAX_POSITION) pq.offer(new Node(curP+1, curT+1));
            if (curP*2 <= MAX_POSITION) pq.offer(new Node(curP*2, curT));
        }
    }
}