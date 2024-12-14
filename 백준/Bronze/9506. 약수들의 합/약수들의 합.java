import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == -1) break;

            List<Integer> list = new ArrayList<>();
            int sum = 0;
            int end = N/2;
            for (int i = 1; i <= end; i++) {
                if (N % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }

            if (sum == N) {
                sb.append(N).append(" = ");
                for (int i = 0; i < list.size()-1; i++) {
                    sb.append(list.get(i)).append(" + ");
                }
                sb.append(list.get(list.size()-1));
            } else {
                sb.append(N).append(" is NOT perfect.");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}