import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	static class Road implements Comparable<Road> {
		int a;
		int b;
		int w;
		
		public Road(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
		
		@Override
		public int compareTo(Road o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Road> queue = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			queue.offer(new Road(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])));
		}
		
		for (int i = 1; i < N; i++) {
			Road tmp = queue.poll();
			
			if (tmp.w != i || findP(tmp.a) == findP(tmp.b)) {
				System.out.println(i);
				return;
			} else {
				union(tmp.a, tmp.b);
			}
		}
		System.out.println(N);
	}
	
	static int findP(int n) {
		if (parent[n] == n) return n;
		return parent[n] = findP(parent[n]);
	}
	
	static void union(int a, int b) {
		parent[parent[b]] = parent[a];
	}
}