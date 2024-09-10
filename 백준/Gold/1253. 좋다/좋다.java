import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		int left, right, sum, cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		for (int i = 0; i < N; i++) {
			left = 0;
			right = N-1;
			
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}
				sum = nums[left] + nums[right];
				if (sum == nums[i]) {
					cnt++;
					break;
				}
				
				if (sum < nums[i]) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		
		System.out.println(cnt);
	}
}