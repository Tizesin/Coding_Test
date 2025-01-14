import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] map;
    static int N,M;
    static int[][][] shape = {
	    {{0,0},{0,1},{0,2},{0,3}},
	    {{0,0},{1,0},{2,0},{3,0}},
	    {{0,0},{1,0},{0,1},{1,1}},
	    {{0,0},{1,0},{2,0},{2,1}},
	    {{0,0},{0,1},{0,2},{-1,2}},
	    {{0,0},{0,1},{1,1},{2,1}},
	    {{0,0},{1,0},{0,1},{0,2}},
	    {{0,0},{0,1},{-1,1},{-2,1}},
	    {{0,0},{0,1},{0,2},{1,2}},
	    {{0,0},{0,1},{1,0},{2,0}},
	    {{0,0},{1,0},{1,1},{1,2}},
	    {{0,0},{1,0},{1,1},{2,1}},
	    {{0,0},{0,1},{-1,1},{-1,2}},
	    {{0,0},{1,0},{1,-1},{2,-1}},
	    {{0,0},{0,1},{1,1},{1,2}},
	    {{0,0},{1,0},{1,-1},{1,1}},
	    {{0,0},{0,1},{0,2},{1,1}},
	    {{0,0},{1,0},{2,0},{1,1}},
	    {{0,0},{0,1},{-1,1},{1,1}},
    };



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        int max = 0;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 19; k++) {
                    max = Math.max(max, check(i,j,k));
                }
            }
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int check(int y, int x, int k) {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            int dy = y+shape[k][i][0];
            int dx = x+shape[k][i][1];
            if(!(0 <= dy && dy < N && 0 <= dx && dx < M))
                return -1;
            score += map[dy][dx];
        }
        return score;
    }
}
