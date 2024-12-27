import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[][] result;
    static Queue<Integer[]> queue = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        int col = Integer.parseInt(line[0]), row = Integer.parseInt(line[1]);
        map = new int[row][col];
        visited = new boolean[row][col];
        result = new int[row][col];
        int minDay = 0;
        int boxCount = row * col;

        for (int i = 0; i < row; i++) {
            String[] box = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                int tomatoStatus = Integer.parseInt(box[j]);
                map[i][j] = tomatoStatus;
                if (tomatoStatus == -1) {
                    visited[i][j] = true;
                    boxCount--;
                } else if (tomatoStatus == 1) {
                    queue.offer(new Integer[]{i, j});
                    visited[i][j] = true;
                    boxCount--;
                }
            }
        }

//        System.out.println("start : " + boxCount);
        while (!queue.isEmpty()) {
            Integer[] currentLocation = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = currentLocation[0] + dy[i];
                int nx = currentLocation[1] + dx[i];
                if (nx >= 0 && nx < col && ny >= 0 && ny < row) {
                    if (!visited[ny][nx]) {
                        result[ny][nx] = result[currentLocation[0]][currentLocation[1]] + 1;
                        if(minDay < result[ny][nx])
                            minDay = result[ny][nx];
                        visited[ny][nx] = true;
                        boxCount--;
                        queue.offer(new Integer[]{ny, nx});
                    }
                }
            }
        }
//        System.out.println("end : " + boxCount);
//        System.out.println(Arrays.deepToString(visited));
        if (boxCount == 0) {
            sb.append(minDay);
        } else {
            sb.append("-1");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
