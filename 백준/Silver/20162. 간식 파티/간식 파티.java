import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] party = new int[N];
		for (int i = 0; i < N; i++) {
			party[i] = Integer.parseInt(br.readLine());
		}
		
		int[] res = Arrays.copyOf(party, N);
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, party[i]);
			for (int j = i+1; j < N; j++) {
				if (party[i] < party[j] && res[j] < res[i] + party[j]) {
					res[j] = res[i] + party[j];
					max = Math.max(max, res[j]);
				}
			}
		}
		
		System.out.println(max);
	}
}