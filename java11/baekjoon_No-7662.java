import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static HashMap<Integer, Integer> countMap = new HashMap<>(); // 삽입/삭제 상태 기록
    static int numCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            minHeap.clear();
            maxHeap.clear();
            countMap.clear();
            numCount = 0;

            int lineCount = Integer.parseInt(br.readLine());
            while (lineCount-- > 0) {
                String[] line = br.readLine().split(" ");
                command(line[0], Integer.parseInt(line[1]));
            }

            cleanHeap(minHeap);
            cleanHeap(maxHeap);

            if (numCount == 0) {
                sb.append("EMPTY");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek());
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void command(String command, int number) {
        switch (command) {
            case "I":
                minHeap.offer(number);
                maxHeap.offer(number);
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
                numCount++;
                break;

            case "D":
                if (numCount == 0) break;

                if (number == -1) {
                    cleanHeap(minHeap); // 최솟값 동기화
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.poll();
                        countMap.put(min, countMap.get(min) - 1);
                        numCount--;
                    }
                } else {
                    cleanHeap(maxHeap); // 최댓값 동기화
                    if (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll();
                        countMap.put(max, countMap.get(max) - 1);
                        numCount--;
                    }
                }
                break;
        }
    }

    public static void cleanHeap(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && countMap.getOrDefault(heap.peek(), 0) <= 0) {
            heap.poll();
        }
    }
}
