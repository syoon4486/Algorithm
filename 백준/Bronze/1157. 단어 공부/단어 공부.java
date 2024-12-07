
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        s = s.toUpperCase();

        int[] alphabet = new int[150];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)]++;
        }

        char res = '?';
        int max = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                res = (char)i;
            } else if (alphabet[i] == max) {
                    res = '?';
            }
        }
        System.out.println(res);
    }
}
