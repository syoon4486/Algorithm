import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/윤다은/A076_SWEA_1267_작업순서.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);
		StringTokenizer st;
		int V, E;
		List<Integer>[] list;
		int[] degree;
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			degree = new int[V+1];
			
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			int from, to;
			for (int i = 0; i < E; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
				degree[to]++;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) queue.offer(i);
			}
			
			while (!queue.isEmpty()) {
				int n = queue.poll();
				sb.append(n).append(" ");
				
				for (int i = 0; i < list[n].size(); i++) {
					int tmp = list[n].get(i);
					degree[tmp]--;
					if (degree[tmp] == 0) queue.offer(tmp);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}