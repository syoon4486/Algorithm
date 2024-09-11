import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] road = new int[N];
		
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			road[i] = Integer.parseInt(s[i]);
		}
		
		int[] cnt = new int[N];
		cnt[N-1] = 1;
		for (int i = N-2; i >= 0; i--) {
			if (i+road[i] >= N-1) cnt[i] = 1;
			else cnt[i] = cnt[i+road[i]+1]+1;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}