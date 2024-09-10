import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N;
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(br.readLine());
			}
			
			Collections.sort(list);
			
			int i;
			for (i = 1; i < list.size(); i++) {
                if (list.get(i).length() < list.get(i-1).length()) continue;
				if (list.get(i).substring(0, list.get(i-1).length()).equals(list.get(i-1))) {
					System.out.println("NO");
					break;
				}
			}
			
			if (i == list.size())
				System.out.println("YES");
		}
	}
}