import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException { 

        double num1 =  System.in.read() - 48 ;
        System.in.read();
        double num2 = System.in.read() - 48 ;

        System.out.println(num1/num2);

    }
}
