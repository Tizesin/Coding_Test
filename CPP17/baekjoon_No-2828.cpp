#include <iostream>

int main() {
    int line, bucket_size, apple_cnt;
    int result = 0, bucket_l = 1, bucket_r;
    std::cin >> line >> bucket_size >> apple_cnt;

    bucket_r = bucket_size;
    
    for(int i = 0; i < apple_cnt; i++){
        int apple_position, move_cnt = 0;
        std::cin >> apple_position;

        //바구니가 이동해야하는지? 이동하면 어디로 얼만큼 이동해야 하는지?
        if(bucket_l > apple_position)
            move_cnt = apple_position-bucket_l;
        else if(bucket_r < apple_position)
            move_cnt = apple_position-bucket_r;

        result += abs(move_cnt);
        bucket_l += move_cnt;
        bucket_r += move_cnt;
    }
    std::cout << result;

    return 0;
}