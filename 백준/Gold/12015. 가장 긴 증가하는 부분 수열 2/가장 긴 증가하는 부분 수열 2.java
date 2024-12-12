
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        a = new int[N];

        a[0] = Integer.parseInt(st.nextToken());
        int n, last = 0;
        for (int i = 1; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            if (n < a[last]) {
                binarySearch(0, last, n);
            } else if (n > a[last]) {
                last++;
                a[last] = n;
            }
        }

        System.out.println(last+1);
    }

    static void binarySearch(int first, int last, int target) {
        int i = first;
        int j = last;

        while (i < j) {
            int mid = (i + j)/2;
            if (target <= a[mid]) j = mid;
            else i = mid+1;
        }

        a[i] = target;
    }
}