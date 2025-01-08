import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        int length = (int) Math.pow(2,N);
        int middleRow = length/2 - 1;
        int middleCol = length/2 - 1;
//        System.out.println(" | middleRow / middleCol : " + middleRow + " / " + middleCol);
        int result = 0;
        for (int i = 0; i < N; i++) {
            int position = 0;
            if(r > middleRow)
                position += 2;
            if(c > middleCol)
                position += 1;
            result += (length * length / 4 * position);
            length /= 2;
            middleRow += position < 2 ? -(length/2) : (length/2);
            middleCol += position % 2 == 0 ? -(length/2) : (length/2);
//            System.out.println(i + " | result : " + result);
//            System.out.println(i + " | middleRow / middleCol : " + middleRow + " / " + middleCol);
//            System.out.println(i + " | position: " + position);
        }
        sb.append(result);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
