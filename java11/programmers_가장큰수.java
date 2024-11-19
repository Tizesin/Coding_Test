import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                                     .mapToObj(String::valueOf)
                                     .toArray(String[]::new);
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String str : strNumbers) {
            result.append(str);
        }

        return result.toString();
    }
}
