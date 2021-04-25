import java.util.Arrays;
import java.util.Scanner;
public class CalculadoraMain {
	
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
					System.out.println("Suma de dos matrices: ");
					
					int[][] resultado = sumaMatriz();
					System.out.println();
					imprimirMatriz(resultado);
					
					break;
				}
				
				case 2: {
					System.out.println("Producto de un escalar por una matriz");
					break;
				}
				
				case 3: {
					System.out.println("Producto de dos matrices");
					
					int[][] resultado = productoDosMatriz();
					System.out.println();
					imprimirMatriz(resultado);
					
					break;
				}
				
				case 4: {
					System.out.println("Transponer una matriz");
					
					int[][] m = crearMatriz();
					int[][] resultado = transpuestaMatriz(m);
					System.out.println();
					imprimirMatriz(resultado);
					
					break;
				}
				
				case 5: {
					System.out.println("Diagonal principal de una matriz");
					
					int[][] resultado = diagonalMatriz();
					System.out.println();
					imprimirMatriz(resultado);
					
					break;
				}
				
				case 6: {
					System.out.println("Comprobar si una matriz es simétrica");
					
					int[][] m = crearMatriz();
					boolean resultado = simetriaMatriz(m);
					System.out.println();
					
					if (resultado) {
						System.out.println("Si que es una matriz simétrica.");
					}
					else {
						System.out.println("No es una matriz simétrica.");
					}
					
					break;
				}
				
				case 7: {
					System.out.println("Potencia de una matriz cuadrada");
					break;
				}
	
				case 8: {
					System.out.println("Resta de dos matrices");
					
					int[][] resultado = restaMatriz();
					System.out.println();
					imprimirMatriz(resultado);
					
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
	
	public static int[][] crearMatriz () {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Introduce el numero de filas:");
		int filas = scn.nextInt();
		System.out.println("Introduce el numero de columnas:");
		int columnas = scn.nextInt();
		
		int[][] m = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			System.out.println("Valores de la fila " + (i + 1) + ":");
			for (int j = 0; j < columnas; j++) {
				int num = scn.nextInt();
				m[i][j] = num;
			}
		}
		return m;
	}
	
	public static int[][] sumaMatriz() {
		int[][] m1 = crearMatriz();
		int[][] m2 = crearMatriz();
		
		int filas = m1.length;
		int columnas = m1[0].length;
		
		int[][] result = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				result[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		return result;
	}
	
	public static int[][] restaMatriz() {
		int[][] m1 = crearMatriz();
		int[][] m2 = crearMatriz();
		
		int filas = m1.length;
		int columnas = m1[0].length;
		
		int[][] result = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				result[i][j] = m1[i][j] - m2[i][j];
			}
		}
		
		return result;
	}
	
	public static int[][] productoDosMatriz(){
		int[][] m1 = crearMatriz();
		int[][] m2 = crearMatriz();
		
		//Filas matriz 1
		int filasA = m1.length;
		//Columnas matriz 1
		int columnasA = m1[0].length;
		
		//Filas matriz 2
		int filasB = m2.length;
		//Columnas matriz 2
		int columnasB = m2[0].length;
		
		int[][] result = null;
		
		if (columnasA == filasB) {
			result = new int[filasA][columnasB];
			
			for (int i = 0; i < filasA; i++) {
				for (int j = 0; j < columnasB; j++) {
					for (int k = 0; k < columnasA; k++)
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
			
		}
		else {
			System.out.println("Las matrices no son válidas");
		}
		
		return result;
	}
	
	
	public static int[][] diagonalMatriz(){
		int[][] m = crearMatriz();
		
		int filas = m.length;
		int columnas = m[0].length;
		
		int[][] diagonal = null;
		
		if (filas == columnas) {
			diagonal = new int[1][columnas];
			for (int i = 0; i < filas; i++) {
				diagonal[0][i] = m[i][i];
			}
		}
		else {
			System.out.println("Matriz no valida para realizar la diagonal.");
		}
		
		return diagonal;
	}
	
	public static int[][] transpuestaMatriz(int[][] m){
	
	int filas = m.length;
	int columnas = m[0].length;
	
	int[][] transpuesta = new int[columnas][filas];
	
	for (int i = 0; i < filas; i++) {
		for (int j = 0; j < columnas; j++) {
			transpuesta[j][i] = m[i][j];
		}
	}
		
	return transpuesta;
	}
	
	public static boolean simetriaMatriz(int[][] m) {
		boolean simetrica = false;
		
		if (Arrays.deepEquals(m, transpuestaMatriz(m))) {
			simetrica = true;
		}
		return simetrica;
	}
	
	public static void imprimirMatriz(int[][] m) {
		
		if (m != null) {
			int filas = m.length;
			int columnas = m[0].length;
			
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++){
					System.out.print(m[i][j] + " ");
				}
				System.out.println();
			}
			
		}
		else {
			System.out.println("No hay matriz disponible.");
		}
		
	}

}
