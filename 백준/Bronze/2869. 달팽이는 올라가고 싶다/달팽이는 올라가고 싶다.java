
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);

        int day = (N-A-1)/(A-B) + 2;

        System.out.println(A == N ? 1 : day);
    }
}