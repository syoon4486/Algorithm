import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[201];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[Integer.parseInt(st.nextToken())+100]++;
        }

        int v = Integer.parseInt(br.readLine());

        System.out.println(a[v+100]);
    }
}
