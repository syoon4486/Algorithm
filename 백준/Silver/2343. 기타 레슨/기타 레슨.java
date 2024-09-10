import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] blueray = new int[N];
		int totalLen = 0, max = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			blueray[i] = Integer.parseInt(st.nextToken());
			totalLen += blueray[i];
			max = Math.max(max, blueray[i]);
		}
		
		int left = max, right = totalLen;
		while (left < right) {
			int mid = (left+right)/2;
			
			int cnt = 1, len = 0;
			boolean pos = true;
			for (int i = 0; i < N; i++) {
				len += blueray[i];
				if (len > mid) {
					cnt++;
					len = blueray[i];
					if (cnt > M) {
						pos = false;
						break;
					}
				}
			}
			if (pos == false) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		
		System.out.println(right);
	}
}