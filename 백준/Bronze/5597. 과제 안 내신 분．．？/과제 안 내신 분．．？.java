
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[31];

        for (int i = 0; i < 28; i++) {
            a[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 30; i++) {
            if (a[i] == 0) System.out.println(i);
        }
    }
}
