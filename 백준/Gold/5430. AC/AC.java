import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String command = br.readLine();
            int commandLength = command.length();
            int size = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split("[\\[,\\]]");
            int dir = 1;

            int first = 1, last = size;

            for (int i = 0; i < commandLength; i++) {
                char c = command.charAt(i);
                if (c == 'R') {
                    dir *= -1;
                } else if (c == 'D') {
                    size--;
                    if (size < 0) {
                        sb.append("error").append("\n");
                        break;
                    }

                    if (dir == 1) {
                        first++;
                    } else {
                        last--;
                    }
                }
            }

            if (size < 0) continue;
            else if (size == 0) {
                sb.append("[]\n");
                continue;
            }

            sb.append("[");
            if (dir > 0) {
                for (int i = first; i < last; i++) {
                    sb.append(s[i]).append(",");
                }
                sb.append(s[last]);
            } else {
                for (int i = last; i > first; i--) {
                    sb.append(s[i]).append(",");
                }
                sb.append(s[first]);
            }
            sb.append("]\n");
        }

        System.out.println(sb);
    }
}