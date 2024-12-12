
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] original = new int[N];
        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        a = new int[N];
        int[] b = new int[N];

        a[0] = original[0];
        int n, last = 0;
        for (int i = 1; i < N; i++) {
            n = original[i];
            if (n < a[last]) {
                int idx = binarySearch(0, last, n);
                b[i] = idx;
            } else if (n > a[last]) {
                last++;
                a[last] = n;
                b[i] = last;
            } else b[i] = last;
        }

        int[] res = new int[last+1];
        int cnt = last;
        for (int i = N-1; i >= 0; i--) {
            if (b[i] == cnt) {
                res[cnt--] = original[i];
            }
        }

        System.out.println(last+1);
        for (int i = 0; i <= last; i++) {
            System.out.print(res[i] + " ");
        }
    }

    static int binarySearch(int first, int last, int target) {
        int i = first;
        int j = last;

        while (i < j) {
            int mid = (i + j)/2;
            if (target <= a[mid]) j = mid;
            else i = mid+1;
        }

        a[i] = target;
        return i;
    }
}
