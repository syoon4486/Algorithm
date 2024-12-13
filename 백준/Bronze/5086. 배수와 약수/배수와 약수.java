
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        int a, b;

        while (true) {
            s = br.readLine().split(" ");

            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);

            if (a == 0 && b == 0) break;

            if (b % a == 0) sb.append("factor");
            else if (a % b == 0) sb.append("multiple");
            else sb.append("neither");

            sb.append("\n");
        }

        System.out.println(sb);
    }
}