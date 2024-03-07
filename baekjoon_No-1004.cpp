#include <iostream>
#include <math.h>

int main(void)
{
    //1004
    //원의 방정식 (x-x1)^2 + (y-y1)^2 = r^2
    int start_x, start_y;
    int end_x, end_y;
    int test_cnt, ss_cnt;
    int through_point;
    std::cin >> test_cnt;

    for(int a = 0; a < test_cnt; a++){
        through_point = 0;
        std::cin >> start_x >> start_y >> end_x >> end_y;
        std::cin >> ss_cnt;
        int ss[ss_cnt][3]; //Stellar system
        for(int i = 0; i < ss_cnt; i++){
            int score = 0;
            std::cin >> ss[i][0] >> ss[i][1]>> ss[i][2];
            if(pow(start_x-ss[i][0],2)+pow(start_y-ss[i][1],2)>pow(ss[i][2],2)){
                // printf("start point is outside from this circle\n");
                score++;
            }
            if(pow(end_x-ss[i][0],2)+pow(end_y-ss[i][1],2)>pow(ss[i][2],2)){
                // printf("end point is outside form this circle\n");
                score++;
            }
            if(score % 2 != 0){
                through_point++;
            }
        }
        std::cout << through_point << std::endl;
    }
}