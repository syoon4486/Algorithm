import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] money = {1, 2, 5, 7};
		
		int visited[] = new int[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < 4; i++) {
			if (money[i] > N) continue;
			if (money[i] == N) {
				System.out.println(1);
				return;
			}
			visited[money[i]] = 1;
			queue.offer(money[i]);
		}
		
		while (!queue.isEmpty()) {
			int n = queue.poll();
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				tmp = n+money[i];
				if (tmp == N) {
					visited[tmp] = visited[n] + 1;
					break;
				}
				if (tmp < N && visited[tmp] == 0) {
					visited[tmp] = visited[n] + 1;
					queue.offer(tmp);
				}
			}
			if (tmp == N) break;
		}
		
		System.out.println(visited[N]);
	}
}