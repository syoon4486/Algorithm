import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] domino = new int[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			domino[i] = Integer.parseInt(s[i]);
		}
		
		int[] res = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int w = domino[i];
			int cnt = 1;
			for (int j = i+1; j < N; j++) {
				if (domino[j] > w) continue;
				w += domino[j];
				cnt++;
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
}