import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N];
        int[][] dp = new int[2][N];

        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        if (N == 1) {
            System.out.println(stairs[0]);
            return;
        }
        
        dp[0][0] = stairs[0];
        dp[0][1] = stairs[0] + stairs[1];
        dp[1][1] = stairs[1];

        for (int i = 2; i < N; i++) {
            dp[0][i] = dp[1][i-1] + stairs[i];
            dp[1][i] = Math.max(dp[0][i-2], dp[1][i-2]) + stairs[i];
        }

        System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
    }
}