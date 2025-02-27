import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Integer>[] list;
    static int[] count, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int Q = Integer.parseInt(s[2]);

        count = new int[N+1];
        visited = new int[N+1];
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 1; i < N; i++) {
            s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            list[a].add(b);
            list[b].add(a);
        }

        visited[R] = 1;
        count[R] = countNode(R);

        int U;
        for (int i = 0; i < Q; i++) {
            U = Integer.parseInt(br.readLine());
            sb.append(count[U]).append("\n");
        }
        System.out.println(sb);
    }

    public static int countNode(int root) {
        int result = 0;

        for (int node : list[root]) {
            if (visited[node] == 1) continue;
            visited[node] = 1;
            count[node] = countNode(node);
            result += count[node];
        }

        return result + 1;
    }
}