import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(s[i]);
		
		int[] up = new int[n];
		int[] down = new int[n];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) up[i] = Math.max(up[i], up[j]+1);
			}
		}
		
		for (int i = n-2; i >= 0; i--) {
			for (int j = i+1; j < n; j++) {
				if (nums[j] < nums[i]) down[i] = Math.max(down[i], down[j]+1);
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, up[i]+down[i]);
		}
		
		System.out.println(max+1);
	}
}