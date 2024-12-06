
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[42];
        int cnt = 0;

        int N;
        for (int i = 0; i < 10; i++) {
            N = Integer.parseInt(br.readLine());
            N %= 42;
            if (a[N] == 0) {
                a[N] = 1;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
