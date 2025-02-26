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

        NQueen(0);
        System.out.println(cnt);
    }

    public static void NQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[depth] = i;
            if (possible(depth)) {
                NQueen(depth+1);
            }
        }
    }

    static public boolean possible(int i) {
        for (int j = 0; j < i; j++) {
            if (queen[j] == queen[i] || Math.abs(j - i) == Math.abs(queen[j] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}