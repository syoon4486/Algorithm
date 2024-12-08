
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s;
        char cur;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int[] alphabet = new int[150];
            s = br.readLine();

            cur = s.charAt(0);
            alphabet[cur] = 1;
            int j;
            for (j = 1; j < s.length(); j++) {
                if (s.charAt(j) != cur) {
                    if (alphabet[s.charAt(j)] == 0) {
                        alphabet[s.charAt(j)] = 1;
                        cur = s.charAt(j);
                    } else {
                        break;
                    }
                }
            }
            if (j == s.length()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}