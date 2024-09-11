import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] food = new int[N];
		for (int i = 0; i < N; i++) {
			food[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N][3];
		
		dp[0][0] = 0;
		dp[0][1] = food[0];
		dp[0][2] = food[0];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			dp[i][1] = dp[i-1][2] + food[i]/2;
			dp[i][2] = dp[i-1][0] + food[i];
		}
		
		System.out.println(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2])));
	}
}