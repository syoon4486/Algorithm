import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		
		int[] nums = new int[N];
		
		s = br.readLine().split(" ");
		nums[0] = Integer.parseInt(s[0]);
		if (nums[0] >= S) {
			System.out.println(1);
			return;
		}
		
		int min = 100001;
		int left, right;
		for (left = 0, right = 1; right < N; right++) {
			nums[right] = nums[right-1] + Integer.parseInt(s[right]);
			
			if (nums[right] >= S) {
				while (nums[right] - nums[left] >= S) left++;
				min = Math.min(min, right-left+1);
			}
		}
		
		System.out.println(min == 100001 ? 0 : min);
		
	}
}