import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int N2 = N*2;
        int[] belt = new int[N2];
        int[] robot = new int[N2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int finish = N-1;
        int step = 0;

        while (K > 0) {
            start = (start + N2 - 1)%N2;
            finish = (finish + N2 - 1)%N2;

            if (robot[finish] == 1) robot[finish] = 0;
            int tmp = finish;
            while (tmp != start) {
                if (robot[tmp] == 1) {
                    int next = (tmp+1)%N2;
                    if ((robot[next] == 0) && (belt[next] > 0)) {
                        robot[tmp] = 0;
                        robot[next] = 1;
                        belt[next]--;
                        if (belt[next] == 0) {
                            K--;
                        }
                    }
                }
                tmp = (tmp+N2-1)%N2;
            }
            if (robot[finish] == 1) robot[finish] = 0;

            if (belt[start] > 0) {
                belt[start]--;
                if (belt[start] == 0) {
                    K--;
                }
                robot[start] = 1;
            }

            step++;
        }
        System.out.println(step);
    }
}