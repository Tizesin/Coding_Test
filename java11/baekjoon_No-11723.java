import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int bitmap = 0b00000000000000000000;
        int cycle = Integer.parseInt(br.readLine());
        while(cycle-- > 0){
            String[] line = br.readLine().split(" ");
            switch(line[0]){
                case "add":
                    bitmap |= 1 << (Integer.parseInt(line[1])-1); break;
                case "remove":
                    bitmap &= ~(1 << (Integer.parseInt(line[1])-1)); break;
                case "check":
                    if((bitmap & ( 1 << (Integer.parseInt(line[1])-1)))!= 0){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    bitmap ^= ( 1 << (Integer.parseInt(line[1]))-1);
                    break;
                case "all":
                    bitmap = 0b11111111111111111111;
                    break;
                case "empty":
                    bitmap = 0b00000000000000000000;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
