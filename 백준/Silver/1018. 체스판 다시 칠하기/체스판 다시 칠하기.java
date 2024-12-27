
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] color1 = new int[N+1][M+1];     //even is B, count the wrong
        int[][] color2 = new int[N+1][M+1];     //even is W

        String line;

        for (int i = 1; i <= N; i++) {
            line = br.readLine();

            for (int j = 1; j <= M; j++) {
                if ((i+j) % 2 == 0) {
                    if (line.charAt(j-1) == 'W') {
                        color1[i][j] = 1;
                    } else {
                        color2[i][j] = 1;
                    }
                } else {
                    if (line.charAt(j-1) == 'B') {
                        color1[i][j] = 1;
                    } else {
                        color2[i][j] = 1;
                    }
                }
                color1[i][j] += color1[i-1][j] + color1[i][j-1] - color1[i-1][j-1];
                color2[i][j] += color2[i-1][j] + color2[i][j-1] - color2[i-1][j-1];
            }
        }

        int res = Integer.MAX_VALUE;
        int tmp1, tmp2;
        for (int i = 8; i <= N; i++) {
            for (int j = 8; j <= M; j++) {
                tmp1 = color1[i][j] - color1[i-8][j] - color1[i][j-8] + color1[i-8][j-8];
                tmp2 = color2[i][j] - color2[i-8][j] - color2[i][j-8] + color2[i-8][j-8];
                res = Math.min(res, Math.min(tmp1, tmp2));
            }
        }

        System.out.println(res);
    }
}