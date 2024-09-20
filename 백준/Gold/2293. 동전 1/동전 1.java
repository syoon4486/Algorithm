import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		int[] sum = new int[k+1];
		sum[0] = 1;
		
		int coin, c, cur;
		for (int i = 0; i < n; i++) {
			coin = Integer.parseInt(br.readLine());
			for (int j = k; j >= coin; j--) {
				c = 1;
				cur = j-c*coin;
				while (cur >= 0) {
					sum[j] += sum[cur];
					c++;
					cur = j-c*coin;
				}
			}
		}
		
		System.out.println(sum[k]);
	}
}