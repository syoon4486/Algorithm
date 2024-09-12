import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0, max;
		int[] light = new int[N];
		
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		
		if (Integer.parseInt(s2[0]) == 1) {
			cnt += Integer.parseInt(s1[0]);
			light[0] -= Integer.parseInt(s1[0]);
		}
		else {
			light[0] += Integer.parseInt(s1[0]);
		}
		max = light[0];
		
		int[] min = new int[N];
		min[0] = light[0];
		for (int i = 1; i < N; i++) {
			if (Integer.parseInt(s2[i]) == 1) {
				cnt += Integer.parseInt(s1[i]);
				light[i] = light[i-1] - Integer.parseInt(s1[i]);
			}
			else {
				light[i] = Integer.parseInt(s1[i])+light[i-1];
			}
			min[i] = Math.min(min[i-1], light[i]);
			max = Math.max(max, light[i]);
		}
		
		for (int i = 1; i < N; i++) {
			max = Math.max(max, light[i]-min[i-1]);
		}
		
		System.out.println(cnt+max);
	}
}