
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cnt = 0;
        int N = s.length();
        int cur = 0;

        int c;
        while (cur < N) {
            cnt++;
            c = s.charAt(cur);
            if (cur+1 < N) {
                if (c == 'c') {
                    if (s.charAt(cur+1) == '=' || s.charAt(cur+1) == '-') {
                        cur++;
                    }
                }
                else if (c == 'd') {
                    if (s.charAt(cur+1) == '-') {
                        cur++;
                    }
                    else if (cur+2 < N && s.charAt(cur+1) == 'z' && s.charAt(cur+2) == '=') {
                        cur += 2;
                    }
                }
                else if (c == 'l' && s.charAt(cur+1) == 'j') {
                    cur++;
                }
                else if (c == 'n' && s.charAt(cur+1) == 'j') {
                    cur++;
                }
                else if (c == 's' && s.charAt(cur+1) == '=') {
                    cur++;
                }
                else if (c == 'z' && s.charAt(cur+1) == '=') {
                    cur++;
                }
            }
            cur++;
        }

        System.out.println(cnt);
    }
}
