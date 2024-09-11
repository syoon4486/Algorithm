import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int[] visited = new int[K+1];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {A, 0});
		
		int[] n;
		int twice, one;
		while (true) {
			n = queue.poll();

			twice = n[0]*2;
			one = n[0]+1;
			if (twice == K || n[0]+1 == K) {
				System.out.println(n[1] + 1);
				break;
			}
			if (twice < K && visited[twice] == 0) {
				visited[twice] = 1;
				queue.offer(new int[] {twice, n[1]+1});
			}
			if (visited[one] == 0) {
				visited[one] = 1;
				queue.offer(new int[] {n[0]+1, n[1]+1});
			}
		}
		
	}
}