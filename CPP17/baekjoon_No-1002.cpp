#include <iostream>
#include <math.h>

int main()
{
    //baekjoon No. 1002
    int x1, y1, x2, y2, r1, r2;
    double real_dist;
    int case_cnt = 1;

    scanf("%d",&case_cnt);

    int result[case_cnt] = {0,};
    
    for(int i=0;i<case_cnt;i++){
        scanf("%d %d %d %d %d %d",&x1,&y1,&r1,&x2,&y2,&r2);
        real_dist = sqrt((pow(x1 - x2,2)) + (pow(y1 - y2,2)));
        if(real_dist < (r1+r2) && real_dist > abs(r1-r2)){
            //접점 둘
            result[i] = 2;
        }
        else if(!real_dist && (r1 == r2)){
            //완전겹침
            result[i] = -1;
        }
        else if(real_dist == (r1+r2) || real_dist == abs(r1-r2)){
            //접점 하나 - 내부 or 외부
            result[i] = 1;
        }
        else if(real_dist > (r1+r2)){
            //접점 없음 - 외부
            result[i] = 0;
        }
        if(real_dist < (r1+r2) && real_dist < abs(r1-r2)){
            //접점 없음 - 내부
            result[i] = 0;
        }
    }
    for(int i=0;i<case_cnt;i++)
        printf("%d\n",result[i]);
}