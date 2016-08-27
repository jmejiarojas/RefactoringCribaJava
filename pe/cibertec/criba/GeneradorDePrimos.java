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
	
	private static int dim;
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
			inicializarCriba(max);
			cribar();
			rellenarPrimos();
			
			return primos;
		}
	}

	private static void inicializarCriba(int max) {
		int i;
		//Declaraciones
		dim = max + 1; //Tamaño del array
		esPrimo = new boolean[dim];
		
		//Inicializar el array
		for (i = 0; i < dim; i++){
			esPrimo[i] = true;
		}
		
		//Eliminamos el 0 y el 1, que no son primos
		esPrimo[0] = esPrimo[1] = false;
	}

	private static void cribar(){
		
		int i, j;
		
		for ( i = 0; i< Math.sqrt(dim) + 1; i++) {
			if(esPrimo[i]){
				//Eliminamos los múltiplos de i
				for ( j=2*i ; j < dim ; j += i){
					esPrimo[j] = false;
				}
			}
		}
	}
	
	private static void rellenarPrimos(){
		
		int i,j;
		
		//¿Cúantos primos hay?
		int cuenta = 0;
		 for (i = 0; i < dim; i++){
			 if(esPrimo[i]){
				 cuenta++;
			 }
		 }
		 
		 //Rellenamos el vector de números primos
		 primos = new int[cuenta];
		 
		 for ( i = 0 , j = 0; i < dim; i++) {
			if(esPrimo[i]){
				primos[j++] = i;
			}
		}
	}
}















