
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int cnt = 0;
        int cur = 1;
        while (cur <= N) {
            if (N % cur == 0) cnt++;
            if (cnt == K) {
                System.out.println(cur);
                return;
            }
            cur++;
        }

        System.out.println(0);
    }
}