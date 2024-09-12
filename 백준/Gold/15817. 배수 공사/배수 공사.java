import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] pipe = new int[N][2];
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			pipe[i][0] = Integer.parseInt(s[0]);
			pipe[i][1] = Integer.parseInt(s[1]);
		}
		
		int[] knap = new int[M+1];
		knap[0] = 1;
		
		for (int i = 0; i < N; i++) {
			int n = pipe[i][0];
			for (int j = M; j >= n; j--) {
				for (int k = 1; k <= pipe[i][1]; k++) {
					if (j-n*k < 0) break;
					knap[j] += knap[j-n*k];
				}
			}
		}
		System.out.println(knap[M]);
	}
}