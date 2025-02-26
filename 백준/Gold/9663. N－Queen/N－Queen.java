import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int cnt = 0;
    static int N;
    static int[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];
        Arrays.fill(queen, -1);

        NQueen(0);
        System.out.println(cnt);
    }

    public static void NQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (queen[i] >= 0) continue;

            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if (queen[j] < 0) continue;
                if (((j - i) == (queen[j] - depth)) || ((j - i) == -(queen[j] - depth))) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            queen[i] = depth;
            NQueen(depth+1);
            queen[i] = -1;
        }
    }
}