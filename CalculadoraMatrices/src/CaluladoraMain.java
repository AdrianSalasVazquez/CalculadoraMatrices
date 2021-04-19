import java.util.Scanner;
public class CaluladoraMain {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean salir = false;
		int op;
		
		do {
			System.out.println();
			System.out.println("Introduce una opción:");
			System.out.println();
			System.out.println("1. Suma de dos matrices");
			System.out.println("2. Producto de un escalar por una matriz");
			System.out.println("3. Producto de dos matrices");
			System.out.println("4. Transponer una matriz");
			System.out.println("5. Diagonal principal de una matriz");
			System.out.println("6. Comprobar si una matriz es simétrica");
			System.out.println("7. Potencia de una matriz cuadrada");
			System.out.println("8. Resta de dos matrices");
			System.out.println("9. Salir");
			System.out.println();
			
			op = scn.nextInt();
			System.out.println();
			
			switch (op) {
				case 1: {
					System.out.println("Suma de dos matrices");
					break;
				}
				
				case 2: {
					System.out.println("Producto de un escalar por una matriz");
					break;
				}
				
				case 3: {
					System.out.println("Producto de dos matrices");
					break;
				}
				
				case 4: {
					System.out.println("Transponer una matriz");
					break;
				}
				
				case 5: {
					System.out.println("Diagonal principal de una matriz");
					break;
				}
				
				case 6: {
					System.out.println("Comprobar si una matriz es simétrica");
					break;
				}
				
				case 7: {
					System.out.println("Potencia de una matriz cuadrada");
					break;
				}
	
				case 8: {
					System.out.println("Resta de dos matrices");
					break;
				}
				
				case 9: {
					System.out.println("Saliendo del programa...");
					salir = true;
					break;
				}
				
				default: {
					System.out.println("Introduce un número del 1 al 9");
					break;
				}
			}
		}while(!salir);
		
	}

}
