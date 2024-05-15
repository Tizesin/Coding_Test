#include <stdio.h>
#include <iostream>

int main(void)
{
    //baekjoon No.1011
    int X; // 출발위치
    int Y; // 목표위치
    int Test_case; // 테스트 횟수 
    int dest; // x와y의 거리
    int total_dest;
    int total_move_cnt;
    int i = 1;

    std::cin >> Test_case;
    for(int a = 0; a < Test_case; a++){
        i = 1;
        total_move_cnt = 0;
        total_dest = 0;
        std::cin >> X;
        std::cin >> Y;
        dest = Y - X; 
        while(1)
        {
            if(dest-total_dest == i*2){
                //완벽한 대칭 (이동횟수 : 짝수)
                total_move_cnt = i*2;
                break;
            }else if(dest-total_dest < i*2){
                //더 이상 대칭 구조를 찾지 못할 때,
                if(i>=dest-total_dest){
                    //마지막 남은 숫자가 대칭 값 최고값이거나 낮을 때,
                    total_move_cnt = ((i-1)*2) + 1;
                }else{
                    total_move_cnt = ((i-1)*2) + 2;
                }
                break;
            }else{
                //대칭 숫자들 중 가장 높은 숫자를 구하지 못했을 때,
                total_dest = total_dest+(i*2);
            }
            i++;
        }
        printf("%d\n",total_move_cnt);
    }
}