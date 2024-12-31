import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] map;
    static Queue<Integer[]> queue = new LinkedList<>();
    static Queue<Integer[]> needVisit = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int col, row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        while(testcase-- > 0) {
            String[] line = br.readLine().split(" ");
            col = Integer.parseInt(line[0]);
            row = Integer.parseInt(line[1]);
            int cabbageCount = Integer.parseInt(line[2]);

            map = new int[row][col];

            for (int i = 0; i < cabbageCount; i++) {
                line = br.readLine().split(" ");
                map[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
                needVisit.offer(new Integer[]{Integer.parseInt(line[1]),Integer.parseInt(line[0])});
            }
            sb.append(bfs(cabbageCount));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int bfs(int cabbageCount) {
        int ret = 0;
        while(!needVisit.isEmpty()) {
            Integer[] chkVisit = needVisit.poll();
            if (map[chkVisit[0]][chkVisit[1]] == 0)
                continue;
            queue.offer(chkVisit);
            map[chkVisit[0]][chkVisit[1]] = 0;
            ret++;

            while (!queue.isEmpty()) {
                Integer[] currentPosition = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = currentPosition[1] + dx[i];
                    int ny = currentPosition[0] + dy[i];
                    if (nx >= 0 && nx < col && ny >= 0 && ny < row && map[ny][nx] == 1) {
                        queue.offer(new Integer[]{ny, nx});
                        map[ny][nx] = 0;
                    }
                }
            }
        }
        return ret;
    }
}
