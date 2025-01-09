import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int HORIZONTAL = 0, VERTICAL = 1, DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N+1][N+1][3];
        dp[1][2][HORIZONTAL] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) continue;
                dp[i][j][HORIZONTAL] += dp[i][j-1][HORIZONTAL] + dp[i][j-1][DIAGONAL];
                dp[i][j][VERTICAL] = dp[i-1][j][VERTICAL] + dp[i-1][j][DIAGONAL];

                if (map[i-1][j] == 1 || map[i][j-1] == 1) continue;
                dp[i][j][DIAGONAL] = dp[i-1][j-1][DIAGONAL] + dp[i-1][j-1][HORIZONTAL] + dp[i-1][j-1][VERTICAL];
            }
        }
        
        System.out.println(dp[N][N][HORIZONTAL] + dp[N][N][VERTICAL] + dp[N][N][DIAGONAL]);
    }
}