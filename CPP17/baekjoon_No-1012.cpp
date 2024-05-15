#include <iostream>
#include <cstring>

using namespace std;

int main()
{
    int test_case;
    std::cin >> test_case;

    for(int i = 0; i < test_case; i++)
    {
        int col, row, cnt;
        int result = 0;
        std::cin >> col >> row >> cnt;
        int ground[row][col];
        int Cabbage[cnt+1][3]; // [배추번호], [y좌표][x좌표][flag]
        memset(ground, 0, sizeof(ground));

        for(int j = 1; j < cnt+1 ; j++){
            int x,y;
            std::cin >> x >> y;
            ground[y][x] = j;
            Cabbage[j][0] = y;
            Cabbage[j][1] = x;
            Cabbage[j][2] = 1;
        }
        
        for(int j = 1; j < cnt+1; j++){
            int x = Cabbage[j][1],y = Cabbage[j][0];
            if(Cabbage[j][2] == 1){
                Cabbage[j][2] = 3;
            }
            if(Cabbage[j][2] > 0){
                if(y!= 0 && ground[y-1][x] != 0 && Cabbage[ground[y-1][x]][2] != 3){ //상
                    if(Cabbage[ground[y-1][x]][2] == 2){
                        Cabbage[j][2] = 2;
                    }else{
                        Cabbage[ground[y-1][x]][2] = 2;
                    }
                }
                if(y!= row-1 && ground[y+1][x] != 0 && Cabbage[ground[y+1][x]][2] != 3){ //하
                    if(Cabbage[ground[y+1][x]][2] == 2){
                        Cabbage[j][2] = 2;
                    }else{
                        Cabbage[ground[y+1][x]][2] = 2;
                    }
                }
                if(x!= 0 && ground[y][x-1] != 0 && Cabbage[ground[y][x-1]][2] != 3){ //좌
                    if(Cabbage[ground[y][x-1]][2] == 2){
                        Cabbage[j][2] = 2;
                    }else{
                        Cabbage[ground[y][x-1]][2] = 2;
                    }
                }
                if(x!= col-1 && ground[y][x+1] != 0 && Cabbage[ground[y][x+1]][2] != 3){ //우
                    if(Cabbage[ground[y][x+1]][2] == 2){
                        Cabbage[j][2] = 2;
                    }else{
                        Cabbage[ground[y][x+1]][2] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                std::cout << ground[i][j] << " ";
            }
            std::cout << std::endl;
        }
        
        std::cout << "---------------------------" << std::endl;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if(ground[i][j] == 0){
                    std::cout << ground[i][j] << " ";
                }else{
                    std::cout << Cabbage[ground[i][j]][2] << " ";
                }
            }
            std::cout << std::endl;
        }

        
        for(int j = 1; j < cnt+1; j++){
            if(Cabbage[j][2] == 3)
                result++;
        }
        std::cout << result << std::endl;
    }
    return 0;
}