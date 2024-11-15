import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums)
            set.add(num);
            
        int max = nums.length/2;
        answer = (max > set.size() ? set.size() : max);
        return answer;
    }
}
