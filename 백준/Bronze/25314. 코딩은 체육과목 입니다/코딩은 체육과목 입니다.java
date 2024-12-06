
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        N /= 4;

        for (int i = 0; i < N; i++) {
            sb.append("long").append(" ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}
