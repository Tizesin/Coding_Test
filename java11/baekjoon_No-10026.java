import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] map;
    static boolean[][] visited;
    static Queue<Integer[]> que = new LinkedList<>();
    static int lineLength;
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};
    static int red = 0, blue = 0, green = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        lineLength = Integer.parseInt(br.readLine());
        map = new String[lineLength][lineLength];
        visited = new boolean[lineLength][lineLength];

        for (int i = 0; i < lineLength; i++) {
            String line = br.readLine();
            for (int j = 0; j < lineLength; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }
        for (int i = 0; i < lineLength; i++) {
            for (int j = 0; j < lineLength; j++) {
                if(!visited[i][j]){
                    que.offer(new Integer[]{i,j});
                    bfs("OFF");
                }
            }
        }
        sb.append(red+blue+green);
        sb.append(" ");
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        red = 0; blue = 0; green = 0;
        for (int i = 0; i < lineLength; i++) {
            for (int j = 0; j < lineLength; j++) {
                if(!visited[i][j]){
                    que.offer(new Integer[]{i,j});
                    bfs("ON");
                }
            }
        }
        sb.append(red+blue+green);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void bfs(String mode){
        String color = "";
        if(mode.equals("OFF")){
            while (!que.isEmpty()) {
                Integer[] position = que.poll();
                color = map[position[0]][position[1]];
                for (int i = 0; i < 4; i++) {
                    int dy = position[0] + my[i];
                    int dx = position[1] + mx[i];
                    if (dy >= 0 && dx >= 0 && dy < lineLength && dx < lineLength) {
                        if (!visited[dy][dx] && map[dy][dx].equals(color)) {
                            visited[dy][dx] = true;
                            que.offer(new Integer[]{dy, dx});
                        }
                    }
                }
            }
            switch (color){
                case "R": red++; break;
                case "B": blue++; break;
                case "G": green++;
            }
        }else{
            while (!que.isEmpty()) {
                Integer[] position = que.poll();
                color = map[position[0]][position[1]];
                for (int i = 0; i < 4; i++) {
                    int dy = position[0] + my[i];
                    int dx = position[1] + mx[i];
                    if (dy >= 0 && dx >= 0 && dy < lineLength && dx < lineLength) {
                        if (!visited[dy][dx]) {
                            if(color.equals("B") && map[dy][dx].equals(color)){
                                visited[dy][dx] = true;
                                que.offer(new Integer[]{dy, dx});
                            }else if(!color.equals("B") && !map[dy][dx].equals("B")){
                                visited[dy][dx] = true;
                                que.offer(new Integer[]{dy, dx});
                            }
                        }
                    }
                }
            }
            if(color.equals("B")){
                blue++;
            }else{
                red++;
            }
        }
    }
}
