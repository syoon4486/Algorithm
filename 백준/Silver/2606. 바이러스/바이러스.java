import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) {
            list[i] = new ArrayList<>();
        }

        String[] s;
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            list[from].add(to);
            list[to].add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] visited = new int[V+1];
        visited[1] = 1;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i = 0; i < list[n].size(); i++) {
                int tmp = list[n].get(i);
                if (visited[tmp] == 0) {
                    visited[tmp] = 1;
                    queue.offer(tmp);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}