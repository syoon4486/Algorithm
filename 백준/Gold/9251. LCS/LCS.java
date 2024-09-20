import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		int[][] lcs = new int[l1+1][l2+1];
		int a;
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				a = s1.charAt(i-1)==s2.charAt(j-1) ? 1 : 0;
				lcs[i][j] = Math.max(lcs[i-1][j-1]+a, Math.max(lcs[i-1][j], lcs[i][j-1]));
			}
		}
		System.out.println(lcs[l1][l2]);
	}
}