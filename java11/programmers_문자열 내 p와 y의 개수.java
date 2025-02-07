class Solution {
	boolean solution(String s) {
		int pCnt = 0, yCnt = 0;
		String[] array = s.toLowerCase().split("");
		for (int i = 0; i < array.length; i++) {
			if ("p".equals(array[i])) { 
				pCnt++;
			} else if ("y".equals(array[i])) {
				yCnt++;
			}
		}
        return !(pCnt != yCnt);
	}
}
