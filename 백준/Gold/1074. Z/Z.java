import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int r, c;
    static int cnt = 0;
    static int[][] dir = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        Z(0, 0, N);
    }

    public static void Z(int beginr, int beginc, int N) {
        if (N == 0) {
            System.out.println(cnt);
            System.exit(0);
        }

        for (int i = 0; i < 4; i++) {
            int range = (int)Math.pow(2, N-1);
            int newr = beginr + dir[i][0]*range;
            int newc = beginc + dir[i][1]*range;
            if (r < newr+range && c < newc+range) {
                Z(newr, newc, N-1);
            }
            cnt += (int) Math.pow(Math.pow(2, N-1), 2);
        }
    }
}