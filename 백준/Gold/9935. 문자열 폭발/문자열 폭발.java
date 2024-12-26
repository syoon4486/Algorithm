import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		String bomb = br.readLine();

		int bombLength = bomb.length();

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			st.add(s.charAt(i));

			int stSize = st.size();
			if (stSize >= bombLength) {
				int j = 0;
				for (; j < bombLength; j++) {
					if (bomb.charAt(j) != st.get(stSize-bombLength+j)) break;
				}

				if (j == bombLength) {
					for (j = 0; j < bombLength; j++) {
						st.pop();
					}
				}
			}
		}

		for (int i = 0; i < st.size(); i++) {
			sb.append(st.get(i));
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
}