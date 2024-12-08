
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double cnt = 0;
        double res = 0;

        String[] s;
        String p;
        double point;
        for (int i = 0; i < 20; i++) {
            s = br.readLine().split(" ");
            p = s[2];

            if (p.equals("P")) continue;
            point = Double.parseDouble(s[1]);
            cnt += point;
            if (p.equals("A+")) {
                res += point*4.5;
            } else if (p.equals("A0")) {
                res += point*4.0;
            } else if (p.equals("B+")) {
                res += point*3.5;
            } else if (p.equals("B0")) {
                res += point*3.0;
            } else if (p.equals("C+")) {
                res += point*2.5;
            } else if (p.equals("C0")) {
                res += point*2.0;
            } else if (p.equals("D+")) {
                res += point*1.5;
            } else if (p.equals("D0")) {
                res += point;
            }
        }

        System.out.println(cnt == 0 ? 0.0 : res/cnt);
    }
}