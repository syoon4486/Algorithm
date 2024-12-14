
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        if (M == 1) M++;
        int sum = 0;
        int min = -1;
        for (int i = M; i <= N; i++) {
            int j;
            for (j = 2; j < i; j++) {
                if (i % j == 0) break;
            }

            if (j == i) {
                if (min == -1) min = i;
                sum += i;
            }
        }

        if (min > 0) System.out.println(sum);
        System.out.println(min);
    }
}