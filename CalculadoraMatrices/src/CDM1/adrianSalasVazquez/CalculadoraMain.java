package CDM1.adrianSalasVazquez;

import java.util.Arrays;

import java.util.Scanner;

/**
 * @author Adrián Salas Vázquez
 */
public class CalculadoraMain {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		boolean salir = false;
		int op;
		
		//Menu de la calculadora:
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
						
					}while (!comprobarMatricesIguales(m1,m2));
					
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
						
						//Comprueba si el número de columnas de la matriz 1 y de filas de la matriz 2 son iguales
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
					}while (!comprobarMatrizCuadrada(m));
					
					int[][] resultado = diagonalMatriz(m);
					System.out.println();
					System.out.println("Diagonal de la matriz:");
					imprimirMatriz(resultado);
					
					break;
					
				}
				
				case 6: {
					
					System.out.println("Comprobar si una matriz es simétrica");
					System.out.println();
					
					int[][] m = null;
					
					do {
						System.out.println("Creando una matriz:");
						m = crearMatriz();
					}while (!comprobarMatrizCuadrada(m));
					
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
					}while (!comprobarMatrizCuadrada(m));
					
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
						
					}while (!comprobarMatricesIguales(m1,m2));
					
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
	
	//Métodos de la calculadora:
	
	/**
	* Este método crea una matriz en base a los valores que introduce el usuario por pantalla.
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
	
	/**
	* Este método realiza la suma de dos matrices introducidas por parámetro (m1 + m2)
	* y devuelve el resultado de la misma.
	* @param int[][] m1 primera matriz de entrada para la suma.
	* @param int[][] m2 segunda matriz de entrada para la suma.
	* @return int[][] devuelve la matriz resultada de la suma.
	*/
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
	
	/**
	* Este método realiza la resta de dos matrices introducidas por parámetro (m1 - m2)
	* y devuelve el resultado de la misma.
	* @param int[][] m1 primera matriz de entrada para la resta.
	* @param int[][] m2 segunda matriz de entrada para la resta.
	* @return int[][] devuelve la matriz resultada de la resta.
	*/
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
	
	/**
	* Este método realiza el producto de una matriz por un escalar 
	* introducidos por parámetro (m * numEscalar), y devuelve el resultado.
	* @param int[][] m matriz de entrada para el producto.
	* @param int numEscalar numero para realizar el producto.
	* @return int[][] devuelve la matriz resultada del producto.
	*/
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
	
	/**
	* Este método realiza el producto de dos matrices introducidas por parámetro (m1 * m2), y devuelve el resultado.
	* @param int[][] m1 primera matriz de entrada para el producto.
	* @param int[][] m2 segunda matriz de entrada para el producto.
	* @return int[][] devuelve la matriz resultada del producto.
	*/
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
	
	/**
	* Este método realiza la potencia de una matriz introducida por parámetro (m^numPotencia), y devuelve el resultado.
	* @param int[][] m matriz de entrada para la potencia.
	* @param int numPotencia numero por el que se realiza la potencia.
	* @return int[][] devuelve la matriz resultada de la potencia.
	*/
	public static int[][] potenciaMatriz(int[][] m, int numPotencia) {
		int[][] resul = m;
		for (int i = 0; i < (numPotencia - 1); i++) {
			resul = productoDosMatriz(resul, m);
		}
		
		return resul;
	}
	
	/**
	* Este método localiza la diagonal principal de la matriz de entrada (m), y devuelve una matriz con la diagonal.
	* @param int[][] m matriz usada para calcular la diagonal.
	* @return int[][] devuelve la diagonal principal de (m).
	*/
	public static int[][] diagonalMatriz(int[][] m){
		int filas = m.length;
		int columnas = m[0].length;
		
		int[][] diagonal = new int[1][columnas];
		for (int i = 0; i < filas; i++) {
			diagonal[0][i] = m[i][i];
		}
		
		return diagonal;
	}
	
	/**
	* Este método transpone (intercambia filas por columnas) la matriz de entrada (m), y devuelve la matriz resultante.
	* @param int[][] m matriz usada para transponer.
	* @return int[][] devuelve la matriz transpuesta.
	*/
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
	
	/**
	* Este método identifica si una matriz es simetrica o no, comparando la matriz de entrada (m) 
	* con su propia transpuesta, y devuelve un valor booleano.
	* @param int[][] m matriz usada para comprobar la simetría.
	* @return boolean devuelve (true) si es simétrica, y (false) si no es simétrica.
	*/
	public static boolean simetriaMatriz(int[][] m) {
		boolean simetrica = false;
		
		if (Arrays.deepEquals(m, transpuestaMatriz(m))) {
			simetrica = true;
		}
		return simetrica;
	}
	
	/**
	* Este método comprueba si las matrices de entrada (m1,m2) son iguales o no, y devuelve un valor booleano
	* @param int[][] m1 Primera matriz usada para comparar.
	* @param int[][] m2 Segunda matriz usada para comparar.
	* @return boolean devuelve (true) si son iguales, y (false) si no lo son.
	*/
	public static boolean comprobarMatricesIguales(int[][] m1, int[][] m2) {
		boolean valor = true;
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			System.out.println();
			System.out.println("Las matrices no son iguales, vuelve a introducirlas.");
			System.out.println();
			valor = false;
		}
		return valor;
	}
	
	/**
	* Este método comprueba si la matriz de entrada (m) es cuadrada (mismas filas que columnas), y devuelve un valor booleano
	* @param int[][] m Matriz usada para comprobar.
	* @return boolean devuelve (true) si es cuadrada, y (false) si no lo es.
	*/
	public static boolean comprobarMatrizCuadrada(int[][] m) {
		boolean valor = true;
		if (m.length != m[0].length) {
			System.out.println();
			System.out.println("La matriz no es cuadrada, vuelve a introducirla.");
			System.out.println();
			valor = false;
		}
		return valor;
	}
	
	/**
	* Este método imprime por pantalla la matriz de entrada (m).
	* @param int[][] m matriz que se va a imprimir.
	*/
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
