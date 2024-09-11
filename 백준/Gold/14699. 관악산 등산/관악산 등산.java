import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] height = new int[N+1];
		s = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(s[i-1]);
		}
		
		int[] indegree = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int a, b;
		while (M-- > 0) {
			s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			
			if (height[a] > height[b]) {
				indegree[b]++;
				list[a].add(b);
			} else {
				indegree[a]++;
				list[b].add(a);
			}
		}
		
		int[] res = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
				res[i] = 1;
			}
		}
		
		while (!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 0; i < list[n].size(); i++) {
				int tmp = list[n].get(i);
				indegree[tmp]--;
				res[tmp] = Math.max(res[tmp], res[n]+1);
				if (indegree[tmp] == 0) {
					queue.offer(tmp);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}
	}
}