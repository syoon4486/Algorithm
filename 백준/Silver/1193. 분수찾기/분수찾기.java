
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int p, q;
        int cnt = 1;
        while (N > cnt) {
            N -= cnt;
            cnt++;
        }

        p = cnt - N + 1;
        q = 1 + N - 1;

        System.out.println(cnt % 2 == 0 ? q + "/" + p : p + "/" + q);
    }
}