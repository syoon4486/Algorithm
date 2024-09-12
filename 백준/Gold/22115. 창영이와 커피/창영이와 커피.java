import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] coffee = new int[N];
		s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			coffee[i] = Integer.parseInt(s[i]);
		}
		
		int[] knap = new int[M+1];
		Arrays.fill(knap, N+1);
		knap[0] = 0;
		
		for (int i = 0; i < N; i++) {
			int n = coffee[i];
			for (int j = M; j >= n; j--) {
				knap[j] = Math.min(knap[j], knap[j-n]+1);
			}
		}
		System.out.println(knap[M] > N ? -1 : knap[M]);
	}
}