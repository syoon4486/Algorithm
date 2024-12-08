import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = -1;
        int cur;
        int x = -1; int y = -1;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                cur = Integer.parseInt(st.nextToken());
                if (cur > max) {
                    max = cur;
                    x = i; y = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((x+1) + " " + (y+1));
    }
}