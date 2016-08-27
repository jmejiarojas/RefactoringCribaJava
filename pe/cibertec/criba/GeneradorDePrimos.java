package pe.cibertec.criba;

/**

* Clase para generar todos los números primos de 1 hasta
* un número máximo especificado por el usuario. Como
* algoritmo se utiliza la criba de Eratóstenes.
* 
* Eratóstenes de Cirene (276 a.C., Cirene, Libia – 194
* a.C., Alejandría, Egipto) fue el primer hombre que
* calculó la circunferencia de la Tierra. También
* se le conoce por su trabajo con calendarios que ya
* incluían años bisiestos y por dirigir la mítica
* biblioteca de Alejandría.
* 
* El algoritmo es bastante simple: Dado un vector de
* enteros empezando en 2, se tachan todos los múltiplos
* de 2. A continuación, se encuentra el siguiente
* entero no tachado y se tachan todos sus múltiplos. El
* proceso se repite hasta que se pasa de la raíz cuadrada
* del valor máximo. Todos los números que queden sin
* tachar son números primos.
*
*/
public class GeneradorDePrimos {
	private static boolean esPrimo[];
	private static int primos[];
	
	/**
	 * Generar números primos de 1 a max
	 * @param max es el valor máximo
	 * @return Vector de números primos
	 */
	public static int[] generarPrimos(int max){
		
		if(max < 2){
			return new int[0]; //Vector vacío
		}else{
			inicializarCandidatos(max);
			eliminarMultiplos();
			obtenerCandidatosNoEliminados();
			
			return primos;
		}
	}

	private static void inicializarCandidatos(int max) {
		int i;
		esPrimo = new boolean[max+1];
		
		//Eliminamos el 0 y el 1, que no son primos
		esPrimo[0] = esPrimo[1] = false;
		
		//Inicializar el array
		for (i = 2; i < esPrimo.length; i++){
			esPrimo[i] = true;
		}
		
	}

	private static void eliminarMultiplos(){
		
		int i, j;
		
		for ( i = 0; i< Math.sqrt(esPrimo.length) + 1; i++) {
			if(esPrimo[i]){
				//Eliminamos los múltiplos de i
				for ( j=2*i ; j < esPrimo.length ; j += i){
					esPrimo[j] = false;
				}
			}
		}
	}
	
	private static void obtenerCandidatosNoEliminados(){
		
		int i,j,cuenta;
		cuenta = 0; //contador de Primos
		 for (i = 0; i < esPrimo.length; i++){
			 if(esPrimo[i]){
				 cuenta++;
			 }
		 }
		 
		 //Rellenamos el vector de números primos
		 primos = new int[cuenta];
		 
		 for ( i = 0 , j = 0; i < esPrimo.length; i++) {
			if(esPrimo[i]){
				primos[j++] = i;
			}
		}
	}
}















