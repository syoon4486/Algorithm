import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int a, b;
        for (int i = 1; i <= m; i++) {
            s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            if (findP(a) == findP(b)) {
                System.out.println(i);
                return;
            }
            union(a, b);
        }

        System.out.println(0);
    }

    static void union(int a, int b) {
        parent[parent[b]] = parent[a];
    }

    static int findP(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findP(parent[a]);
    }
}