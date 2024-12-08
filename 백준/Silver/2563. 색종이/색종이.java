
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] visited = new int[100][100];

        String[] s;
        int x, y, cnt=0;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    if (visited[j][k] == 0) {
                        visited[j][k] = 1;
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}