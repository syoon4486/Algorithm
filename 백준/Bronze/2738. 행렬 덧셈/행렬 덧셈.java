
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] res = new int[N][M];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    res[j][k] += Integer.parseInt(s[k]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}