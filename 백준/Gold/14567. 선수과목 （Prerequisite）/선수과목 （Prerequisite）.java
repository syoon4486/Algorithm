import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] indegree = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		while (M-- > 0) {
			s = br.readLine().split(" ");
			list[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
			indegree[Integer.parseInt(s[1])]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] res = new int[N+1];
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
				if (indegree[tmp] == 0) {
					res[tmp] = res[n]+1;
					queue.offer(tmp);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(res[i] + " ");
		}
	}
}