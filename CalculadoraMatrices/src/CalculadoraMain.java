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
					System.out.println();
					
					int[][] m1 = null;
					int[][] m2 = null;
					
					do {
						System.out.println("Creando primera matriz:");
						m1 = crearMatriz();
						System.out.println("Creando segunda matriz:");
						m2 = crearMatriz();
						
						if (m1.length != m2.length || m1[0].length != m2[0].length) {
							System.out.println();
							System.out.println("Las matrices no son iguales, vuelve a introducirlas.");
							System.out.println();
							m1 = null;
							m2 = null;
						}
					}while (m1 == null || m2 == null);
					
					int[][] resultado = sumaMatriz(m1, m2);
					System.out.println();
					System.out.println("Resultado de la suma:");
					imprimirMatriz(resultado);
					break;
				}
				
				case 2: {
					
					System.out.println("Producto de un escalar por una matriz");
					System.out.println();
					
					System.out.println("Creando matriz:");
					int[][] m = crearMatriz();
					
					System.out.println("Introduce el escalar:");
					int escalar = scn.nextInt();
					
					int[][] resultado = productoEscalarMatriz(m, escalar);
					System.out.println();
					System.out.println("Resultado del escalar por una matriz:");
					imprimirMatriz(resultado);
					
					break;
					
				}
				
				case 3: {
					
					System.out.println("Producto de dos matrices");
					System.out.println();
					
					int[][] m1 = null;
					int[][] m2 = null;
					
					do {
						System.out.println("Creando primera matriz:");
						m1 = crearMatriz();
						System.out.println("Creando segunda matriz:");
						m2 = crearMatriz();
						
						if (m1[0].length != m2.length) {
							System.out.println();
							System.out.println("Las columnas de la primera matriz no son iguales "
									+ "que las filas de la segunda matriz, vuelve a introducirlas.");
							System.out.println();
							m1 = null;
							m2 = null;
						}
					}while (m1 == null || m2 == null);
					
					int[][] resultado = productoDosMatriz(m1, m2);
					System.out.println();
					System.out.println("Resultado del producto:");
					imprimirMatriz(resultado);
					break;
					
				}
				
				case 4: {
					
					System.out.println("Transponer una matriz");
					System.out.println();
					
					System.out.println("Creando la matriz:");
					int[][] m = crearMatriz();
					
					int[][] resultado = transpuestaMatriz(m);
					System.out.println();
					System.out.println("Matriz transpuesta:");
					imprimirMatriz(resultado);
					
					break;
					
				}
				
				case 5: {
					
					System.out.println("Diagonal principal de una matriz");
					System.out.println();
					
					int[][] m = null;
					
					do {
						System.out.println("Creando una matriz:");
						m = crearMatriz();
						
						if (m.length != m[0].length) {
							System.out.println();
							System.out.println("La matriz no es cuadrada, vuelve a introducirla.");
							System.out.println();
							m = null;
						}
					}while (m == null);
					
					int[][] resultado = diagonalMatriz(m);
					System.out.println();
					System.out.println("Diagonal de la matriz:");
					imprimirMatriz(resultado);
					
					break;
					
				}
				
				case 6: {
					
					System.out.println("Comprobar si una matriz es simétrica");
					System.out.println();
					
					System.out.println("Creando una matriz:");
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
					System.out.println();
					
					int[][] m = null;
					
					do {
						System.out.println("Creando una matriz:");
						m = crearMatriz();
						
						if (m.length != m[0].length) {
							System.out.println();
							System.out.println("La matriz no es cuadrada, vuelve a introducirla.");
							System.out.println();
							m = null;
						}
					}while (m == null);
					
					System.out.println("Introduce la potencia:");
					int numPotencia = scn.nextInt();
					int[][] resultado = potenciaMatriz(m, numPotencia);
					System.out.println();
					System.out.println("Resultado de la potencia:");
					imprimirMatriz(resultado);
					
					break;
					
				}
	
				case 8: {
					
					System.out.println("Resta de dos matrices");
					System.out.println();
					
					int[][] m1 = null;
					int[][] m2 = null;
					
					do {
						System.out.println("Creando primera matriz:");
						m1 = crearMatriz();
						System.out.println("Creando segunda matriz:");
						m2 = crearMatriz();
						
						if (m1.length != m2.length || m1[0].length != m2[0].length) {
							System.out.println();
							System.out.println("Las matrices no son iguales, vuelve a introducirlas.");
							System.out.println();
							m1 = null;
							m2 = null;
						}
					}while (m1 == null || m2 == null);
					
					int[][] resultado = restaMatriz(m1, m2);
					System.out.println();
					System.out.println("Resultado de la resta:");
					imprimirMatriz(resultado);
					break;
					
				}
				
				case 9: {
					
					System.out.println("Has salido del programa.");
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
	
	/**
	* Este metodo crea una matriz en base a los valores que introduce el usuario por pantalla.
	* El usuario debe introducir el numero de filas y columnas y a continuacion los valores uno
	* a uno de las mismas.
	* @return int[][] devuelve la matriz creada.
	*/
	public static int[][] crearMatriz () {
		Scanner scn = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Introduce el numero de filas:");
		int filas = scn.nextInt();
		System.out.println();
		
		System.out.println("Introduce el numero de columnas:");
		int columnas = scn.nextInt();
		
		int[][] m = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			System.out.println();
			System.out.println("Valores de la fila " + (i + 1) + ":");
			for (int j = 0; j < columnas; j++) {
				int num = scn.nextInt();
				m[i][j] = num;
			}
		}
		return m;
	}
	
	public static int[][] sumaMatriz(int[][] m1, int[][] m2) {
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
	
	public static int[][] restaMatriz(int[][] m1, int[][] m2) {
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
	
	public static int[][] productoEscalarMatriz(int[][] m, int numEscalar){
		int filas = m.length;
		int columnas = m[0].length;
		
		int[][] res = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				res[i][j] = numEscalar * m[i][j];
			}
		}
		return res;
	}
	
	public static int[][] productoDosMatriz(int[][] m1, int[][] m2){
		//Filas matriz 1
		int filasA = m1.length;
		//Columnas matriz 1
		int columnasA = m1[0].length;
		
		//Columnas matriz 2
		int columnasB = m2[0].length;
		
		int [][] result = new int[filasA][columnasB];
		
		for (int i = 0; i < filasA; i++) {
			for (int j = 0; j < columnasB; j++) {
				for (int k = 0; k < columnasA; k++)
				result[i][j] += m1[i][k] * m2[k][j];
			}
		}	
		
		return result;
	}
	
	public static int[][] potenciaMatriz(int[][] m, int numPotencia) {
		int[][] resul = m;
		for (int i = 0; i < (numPotencia - 1); i++) {
			resul = productoDosMatriz(resul, m);
		}
		
		return resul;
	}
	
	public static int[][] diagonalMatriz(int[][] m){
		int filas = m.length;
		int columnas = m[0].length;
		
		int[][] diagonal = new int[1][columnas];
		for (int i = 0; i < filas; i++) {
			diagonal[0][i] = m[i][i];
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
		int filas = m.length;
		int columnas = m[0].length;
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
