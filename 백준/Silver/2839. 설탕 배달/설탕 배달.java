
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int cnt = 1;
        for (int i = 3; i <= N; i+=3) {
            dp[i] = cnt++;
        }

        cnt = 1;
        int sugar = 5;
        while (sugar <= N) {
            for (int i = N; i > 0; i--) {
                if (i-sugar < 0) break;
                if (dp[i-sugar] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i-sugar] + cnt, dp[i]);
            }

            cnt++;
            sugar += 5;
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}