import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] parent;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		s = br.readLine().split(" ");
		int t = Integer.parseInt(s[0]);		//진실을 아는 사람 수
		
		for (int i = 1; i <= t; i++) {
			parent[Integer.parseInt(s[i])] = 0;	//진실을 알면 부모를 0으로 만든
		}
		
		List<Integer>[] parties = new ArrayList[M];
		for (int i = 0; i < M; i++) {	//파티
			parties[i] = new ArrayList<>();
			
			s = br.readLine().split(" ");
			t = Integer.parseInt(s[0]); 	//파티에 온 사람 수
			
			int first = Integer.parseInt(s[1]); 	//파티 사람 중 맨 처음 사람
			parties[i].add(first);
			int p = findP(first);		//첫 사람의 부모
			for (int j = 2; j <= t; j++) {
				int n = Integer.parseInt(s[j]);
				parties[i].add(n);
				if (p != findP(n)) {
					union(p, n);
				}
			}
		}
		
		int cnt = M;
		for (int i = 0; i < M; i++) {
			int p = findP(0);
			
			for (int n : parties[i]) {
				if (p == findP(n)) {
					cnt--;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static int findP(int n) {
		if (parent[n] == n) return n;
		return parent[n] = findP(parent[n]);
	}
	
	static void union(int a, int b) {
		parent[parent[b]] = parent[a];
	}
}