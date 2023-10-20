import java.io.*;

public class Main {
    static Integer[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        count = new Integer[50001];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;
        count[3] = 3;


        bw.write(dp(n) + "");
        bw.flush();
    }

    public static int dp(int n) {
        if (count[n] == null) {
            int a = (int) Math.sqrt(n);
            int b = a / 2;
            int aa = a * a;

            if (n == aa) {
                count[n] = 1;
            } else {
                int k = Integer.MAX_VALUE;
                while (a > b) {
                    int r = a * a;
                    k = Math.min(dp(r) + dp(n - r), k);
                    a--;
                }
                count[n] = k;
            }
        }
        return count[n];
    }
}