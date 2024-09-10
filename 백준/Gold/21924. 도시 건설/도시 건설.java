import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class Road implements Comparable<Road>{
		int from;
		int to;
		int w;
		
		public Road(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.w - o.w;
		}
	}
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		long total = 0;
		PriorityQueue<Road> queue = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			queue.offer(new Road(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])));
			total += Integer.parseInt(s[2]);
		}
		
		int cnt = 0;
		while (!queue.isEmpty() && cnt < N-1) {
			Road r = queue.poll();
			if (findP(r.from) == findP(r.to)) continue;
			parent[parent[r.to]] = parent[r.from];
			cnt++;
			total -= r.w;
		}
		
		System.out.println(cnt == N-1 ? total : -1);
	}

	static int findP(int n) {
		if (n == parent[n]) return n;
		else return parent[n] = findP(parent[n]);
	}
}