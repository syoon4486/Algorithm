
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int K = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        long[] line = new long[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Long.parseLong(br.readLine());
            max = Math.max(line[i], max);
        }

        long left = 1, right = max;
        while (left < right) {
            long mid = (left + right)/2+1;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += line[i]/mid;
            }

            if (cnt >= N) {
                left = mid;
            } else {
                right = mid-1;
            }
        }

        System.out.println(left);
    }
}