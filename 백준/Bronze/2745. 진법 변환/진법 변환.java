import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String N = s[0];
        int B = Integer.parseInt(s[1]);

        char c;
        int res = 0;
        for (int i = 0; i < N.length(); i++) {
            res *= B;
            c = N.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                res += c-'A'+10;
            } else {
                res += c-'0';
            }
        }

        System.out.println(res);
    }
}