
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, cnt = 0;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());

            if (n == 1) continue;
            int j;
            for (j = 2; j < n; j++) {
                if (n % j == 0) break;
            }

            if (j == n) cnt++;
        }

        System.out.println(cnt);
    }
}