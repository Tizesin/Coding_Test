import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int[][] map;
    public static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Queue<int[]> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); // X
        M = Integer.parseInt(line[1]); // Y
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String mapLine = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = mapLine.charAt(j) - '0';
            }
        }

        if(M == 1 && N == 1){
            sb.append("1");
        }else{
            sb.append(BFS());
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static int BFS() {
        int[][][] check = new int[2][N][M]; // [벽 뚫는 루트 여부][y][x]

        que.offer(new int[] { 0, 0, 0 });
        check[0][0][0] = 1;

        while (!que.isEmpty()) {

            int[] node = que.poll();
            int w = node[0];
            int x = node[1];
            int y = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // map과 check에 쓰일 인덱스가 배열의 범위를 벗어나면 무시하기.
                if (nx >= N || nx < 0 || ny >= M || ny < 0) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    if (check[w][nx][ny] == 0) {
                        que.offer(new int[] { w, nx, ny });
                        check[w][nx][ny] = check[w][x][y] + 1;
                        if (nx == N - 1 && ny == M - 1) {
                            return check[w][nx][ny];
                        }

                    }
                } else {
                    if (w == 0) {
                        if (check[1][nx][ny] == 0) {
                            que.offer(new int[] { 1, nx, ny });
                            check[1][nx][ny] = check[0][x][y] + 1;
                            if (nx == N - 1 && ny == M - 1) {
                                return check[1][nx][ny];
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
