import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[][] dir = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k, 0});
                    } else if (box[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        int newh, newr, newc;
        int[] tmp = {0, 0, 0, 0};
        while (!queue.isEmpty()) {
            tmp = queue.poll();

            for (int i = 0; i < 6; i++) {
                newh = tmp[0] + dir[i][0];
                newr = tmp[1] + dir[i][1];
                newc = tmp[2] + dir[i][2];

                if (newh < 0 || newh >= H || newr < 0 || newr >= N || newc < 0 || newc >= M || box[newh][newr][newc] != 0) continue;
                box[newh][newr][newc] = 1;
                cnt--;
                queue.offer(new int[]{newh, newr, newc, tmp[3]+1});
            }
        }

        System.out.println(cnt > 0 ? -1 : tmp[3]);
    }
}