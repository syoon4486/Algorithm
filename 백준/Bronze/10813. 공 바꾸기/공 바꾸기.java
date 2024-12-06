
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] basket = new int[N+1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        int a, b, tmp;
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            tmp = basket[a];
            basket[a] = basket[b];
            basket[b] = tmp;
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
