#include <iostream>

// 검정부터 시작하는 완벽한 체스판 경우
char B_start_board[8][8] = {
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'}
};

// 하양부터 시작하는 완벽한 체스판 경우
char W_start_board[8][8] = {
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'}
};

int main()
{
    int row, col;
    std::cin >> row >> col;
    char board[row][col];

    for(int i=0; i < row; i++){
        for(int j = 0; j < col; j++){
            std::cin >> board[i][j];
        }
    }
    int result = 64;
    //확인할 범위를 부분적으로 잘라 체스판을 다시 칠해야 하는 최소 수를 확인
    for(int y=0; y<row-7; y++){
        for(int x=0; x<col-7; x++){
            int start_W=0, start_B=0;
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(B_start_board[i][j] != board[y+i][x+j])
                        start_W++;
                    if(W_start_board[i][j] != board[y+i][x+j])
                        start_B++;
                }
            }
            if(result > start_W || result > start_B)
                result = start_W<start_B?start_W:start_B;
        }
    }
    std::cout << result;
}