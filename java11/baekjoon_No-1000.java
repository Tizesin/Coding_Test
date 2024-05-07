import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		int num1 = System.in.read();
		System.in.read();
		int num2 = System.in.read();
		System.in.read();
		
		num1 -= 48;
		num2 -= 48;
		
		System.out.println(num1+num2);
	}
}
