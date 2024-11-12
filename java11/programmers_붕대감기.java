import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackCnt = attacks.length;
        int healCombo = 0;
        int attackidx = 0;
        int nextAtt = -1;
        int nowHP = health;
        for(int turn = 0; turn < attacks[attackCnt-1][0]+1; turn++){
            if(turn == attacks[attackidx][0]){
                healCombo = 0;
                nowHP -= attacks[attackidx][1];
                attackidx++;
            }else{
                healCombo++;
                if(healCombo == bandage[0]){
                    healCombo = 0;
                    nowHP += bandage[2];
                }
                nowHP += bandage[1];
                if(nowHP > health)
                    nowHP = health;
            }
            if(nowHP < 1)
                return -1;
        }
        return nowHP;
    }
}
