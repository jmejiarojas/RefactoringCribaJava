package pe.cibertec.criba;

/**

* Clase para generar todos los n�meros primos de 1 hasta
* un n�mero m�ximo especificado por el usuario. Como
* algoritmo se utiliza la criba de Erat�stenes.
* 
* Erat�stenes de Cirene (276 a.C., Cirene, Libia � 194
* a.C., Alejandr�a, Egipto) fue el primer hombre que
* calcul� la circunferencia de la Tierra. Tambi�n
* se le conoce por su trabajo con calendarios que ya
* inclu�an a�os bisiestos y por dirigir la m�tica
* biblioteca de Alejandr�a.
* 
* El algoritmo es bastante simple: Dado un vector de
* enteros empezando en 2, se tachan todos los m�ltiplos
* de 2. A continuaci�n, se encuentra el siguiente
* entero no tachado y se tachan todos sus m�ltiplos. El
* proceso se repite hasta que se pasa de la ra�z cuadrada
* del valor m�ximo. Todos los n�meros que queden sin
* tachar son n�meros primos.
*
*/
public class GeneradorDePrimos {
	
	private static int dim;
	private static boolean esPrimo[];
	private static int primos[];
	
	/**
	 * Generar n�meros primos de 1 a max
	 * @param max es el valor m�ximo
	 * @return Vector de n�meros primos
	 */
	public static int[] generarPrimos(int max){
		
		if(max < 2){
			return new int[0]; //Vector vac�o
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
		dim = max + 1; //Tama�o del array
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
				//Eliminamos los m�ltiplos de i
				for ( j=2*i ; j < dim ; j += i){
					esPrimo[j] = false;
				}
			}
		}
	}
	
	private static void rellenarPrimos(){
		
		int i,j;
		
		//�C�antos primos hay?
		int cuenta = 0;
		 for (i = 0; i < dim; i++){
			 if(esPrimo[i]){
				 cuenta++;
			 }
		 }
		 
		 //Rellenamos el vector de n�meros primos
		 primos = new int[cuenta];
		 
		 for ( i = 0 , j = 0; i < dim; i++) {
			if(esPrimo[i]){
				primos[j++] = i;
			}
		}
	}
}















