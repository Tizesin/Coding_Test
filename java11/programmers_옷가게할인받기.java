class Solution {
    public int solution(int price) {
        if(price >= 500000)
            return (int)price*80/100;
        else if(price >= 300000)
            return (int)price*90/100;
        else if(price >= 100000)
            return (int)price*95/100;
        return price;
    }
}
