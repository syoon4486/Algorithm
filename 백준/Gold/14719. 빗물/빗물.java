import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] water = new int[H];
        int res = 0;

        st = new StringTokenizer(br.readLine());
        int highest = 0;
        int cur;
        for (int i = 0; i < W; i++) {
            cur = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cur; j++) {
                res += water[j];
                water[j] = 0;
            }
            for (int j = cur; j < highest; j++) {
                water[j]++;
            }

            highest = Math.max(highest, cur);
        }

        System.out.println(res);
    }
}