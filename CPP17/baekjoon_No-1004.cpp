#include <iostream>
#include <math.h>

int main(void)
{
    //1004
    //원의 방정식 (x-x1)^2 + (y-y1)^2 = r^2
    int start_x, start_y;
    int end_x, end_y;
    int test_cnt, ss_cnt;
    int penetration_cnt;
    std::cin >> test_cnt;

    for(int a = 0; a < test_cnt; a++){
        penetration_cnt = 0;
        std::cin >> start_x >> start_y >> end_x >> end_y;
        std::cin >> ss_cnt;
        int ss[ss_cnt][3]; //Stellar system (행성계)
        for(int i = 0; i < ss_cnt; i++){
            int score = 0;
            std::cin >> ss[i][0] >> ss[i][1]>> ss[i][2];

            // 출발 지점이 이 원(행성계) 밖에 존재하는 가?
            if(pow(start_x-ss[i][0],2)+pow(start_y-ss[i][1],2)>pow(ss[i][2],2)){
                score++;
            }

            // 도착 지점이 이 원(행성계) 밖에 존재하는 가?
            if(pow(end_x-ss[i][0],2)+pow(end_y-ss[i][1],2)>pow(ss[i][2],2)){
                score++;
            }

            // 출발/도착 지점 모두 이 원(행성계)밖에 존재하거나 외부에 존재 하지 않는가?
            if(score % 2 != 0){
                penetration_cnt++;
            }
        }
        std::cout << penetration_cnt << std::endl;
    }
}