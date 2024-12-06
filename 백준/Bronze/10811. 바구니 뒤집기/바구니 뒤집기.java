
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] a = new int[N+1];
        int[] b = new int[N+1];

        for (int i = 1; i <= N; i++) a[i] = i;

        int x, y;
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);

            for (int j = x; j <= y; j++) {
                b[j] = a[j];
            }

            int k = y-x;
            for (int j = 0; j <= k; j++) {
                a[y-j] = b[x+j];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(a[i] + " ");
        }
    }
}