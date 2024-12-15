import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] card;
    static int max;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        brute(0, 0, 0);

        System.out.println(max);
    }

    static void brute(int depth, int sum, int next) {
        if (sum > M) return;

        if (depth == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = next; i < N; i++) {
            brute(depth+1, sum+card[i], i+1);
        }
    }
}