import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][][] map;
    static boolean[][][] visited;
    static int[][][] result;
    static Queue<Integer[]> queue = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0, 0, 0}; //앞뒤좌우상하
    static int[] dx = {0, 0, -1, 1, 0, 0}; //앞뒤좌우상하
    static int[] dz = {0, 0, 0, 0, 1, -1}; //앞뒤좌우상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] line = br.readLine().split(" ");
        int col = Integer.parseInt(line[0]),
            row = Integer.parseInt(line[1]),
            floor = Integer.parseInt(line[2]);
        map = new int[row][col][floor];
        visited = new boolean[row][col][floor];
        result = new int[row][col][floor];
        int minDay = 0;
        int boxCount = row * col * floor;

        for (int f = 0; f < floor; f++) {
            for (int i = 0; i < row; i++) {
                String[] box = br.readLine().split(" ");
                for (int j = 0; j < col; j++) {
                    int tomatoStatus = Integer.parseInt(box[j]);
                    map[i][j][f] = tomatoStatus;
                    if (tomatoStatus == -1) {
                        visited[i][j][f] = true;
                        boxCount--;
                    } else if (tomatoStatus == 1) {
                        queue.offer(new Integer[]{i, j, f});
                        visited[i][j][f] = true;
                        boxCount--;
                    }
                }
            }
        }

//        System.out.println("start : " + boxCount);
        while (!queue.isEmpty()) {
            Integer[] currentLocation = queue.poll();
            for (int i = 0; i < 6; i++) {
                int ny = currentLocation[0] + dy[i];
                int nx = currentLocation[1] + dx[i];
                int nz = currentLocation[2] + dz[i];
                if (nx >= 0 && nx < col && ny >= 0 && ny < row && nz >= 0 && nz < floor) {
                    if (!visited[ny][nx][nz]) {
                        result[ny][nx][nz] = result[currentLocation[0]]
                                [currentLocation[1]]
                                [currentLocation[2]] + 1;
                        if(minDay < result[ny][nx][nz])
                            minDay = result[ny][nx][nz];
                        visited[ny][nx][nz] = true;
                        boxCount--;
                        queue.offer(new Integer[]{ny, nx, nz});
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
