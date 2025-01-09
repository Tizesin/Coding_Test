import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] Fibonacci = new long[1001];
        Fibonacci[0] = 0;
        Fibonacci[1] = 1;
        Fibonacci[2] = 2;
        for (int i = 3; i < N+1; i++) {
            Fibonacci[i] = (Fibonacci[i-2] + Fibonacci[i-1]) % 10007;
        }
        sb.append(Fibonacci[N]);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
