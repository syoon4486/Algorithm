
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[15];
        char[][] res = new char[15][5];

        String s;
        for (int i = 0; i < 5; i++) {
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                res[j][cnt[j]] = s.charAt(j);
                cnt[j]++;
            }
        }

        for (int i = 0; i < 15; i++) {
            if (cnt[i] == 0) break;
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(res[i][j]);
            }
        }

        System.out.println(sb);
    }
}