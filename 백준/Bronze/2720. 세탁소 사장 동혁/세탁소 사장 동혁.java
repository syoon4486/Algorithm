
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] change = {25, 10, 5, 1};

        int N = Integer.parseInt(br.readLine());

        int cost;
        for (int i = 0; i < N; i++) {
            cost = Integer.parseInt(br.readLine());

            for (int j = 0; j < 4; j++) {
                sb.append(cost/change[j]).append(" ");
                cost %= change[j];
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}