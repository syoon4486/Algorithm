import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int idx=0, max = 0;
		for (int i = 1; i <= 9; i++) {
			int n = Integer.parseInt(br.readLine());
			if (max < n) {
				max = n;
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
	}
}