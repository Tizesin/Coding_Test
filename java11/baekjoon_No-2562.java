import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        int max = -1, idx = 0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] array=new int[9];

        for(int i=0; i<9; i++){
            array[i]=Integer.parseInt(br.readLine());
            if(array[i] > max) {
                max = array[i];
                idx = i+1;
            }
        }
        System.out.println(max+"\n"+idx);
    }
}
