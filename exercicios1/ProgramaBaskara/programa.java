import java.util.Scanner;

public class programa {
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int a = Integer.parseInt(entrada.nextLine());
		int b = Integer.parseInt(entrada.nextLine());
		int c = Integer.parseInt(entrada.nextLine());
		
		int delta = (b*b) - (4 * a * c);
		if(delta < 0) {
			System.out.println("Nao existe raiz");			
		}
		else {
			double raiz1 = ((b*-1) + Math.sqrt(delta)) / (2*a);
			double raiz2 = ((b*-1) -Math.sqrt(delta)) / (2*a);
			
			System.out.println(raiz1);
			System.out.println(raiz2);
		}
	}
}