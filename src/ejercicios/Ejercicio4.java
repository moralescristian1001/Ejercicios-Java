package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido, 
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**	 
	 * Para ejecutar el mÃ©todo main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application" 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("**** inicializando datos ****");
		
		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));
	
		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);
		
		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());
		
		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());
		
		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);
		
		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);
		
	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion
		
		int pares = 0;
		for (Integer n: lista1) {
			if (n % 2 == 0) {
				pares = pares + 1;
			}
		}

		//Salida numero 1
		System.out.println("... " + pares);
		//Respuesta salida1: Esta salida muestra la cantidad de numeros pares.(numeros pares dentro de la lista1).

		List<Integer> impares = new ArrayList<Integer>();
		for (Integer n: lista1) {
			if (n % 2 != 0) {
				impares.add(n);
			}
		}

		//Salida numero 2
		System.out.println("... " + impares.toString());
		//Respuesta salida2: Esta salida muestra una lista con los numeros impares. (numeros impares dentro de la lista 1).

		int p = lista1.size() / 2;

		//Salida numero 3
		System.out.println("..." + lista1.indexOf(p));
		/* Respuesta salida3: Esta salida muestra la poscion en la que se encuentra un valor dentro de una lista.
		En este caso, se dividio el tamanio de la lista1 entre 2, lo cual da un valor de 5 y el 5
		en la lista 1 esta en la posicion 2, teniendo en cuenta que los indices de la lista empieza
		desde 0*/


		int c = 0;
		for (Integer n: lista1) {
			if (n > numero) {
				c = c + 1;
			}
		}
		if (c > lista1.size() / 2) {

			//Salida numero 4
			System.out.println("...");
			/*Esta condicion solo pasara si la variable "c" que es este caso es
			la cantidad de numeros mayor a 10; es mayor que la longitud de la lista1
			dividida en 2, que en este caso es 5.
			Esta salida deberia mostrar un mensaje diciendo lo siguiente:
			Hay c numeros mayor a 10*/

		} else if (c > 0) {

			//Salida numero 5
			System.out.println("...");
			/*Esta condicion solo pasara si la variable "c" que es este caso es
			la cantidad de numeros mayor a 10; es mayor a 0.
			Esta salida deberia mostrar un mensaje diciendo lo siguiente:
			Hay entre 1 y 5 numeros mayores a 10. El numero exacto es c*/
		} else {
			
			//Salida numero 6
			System.out.println("...");
			/*Esta else solo pasara si la variable "c" que es este caso es
			la cantidad de numeros mayor a 10; es igual o menor que 0
			Esta salida deberia mostrar un mensaje diciendo lo siguiente:
			No hay numeros mayores a 10*/
		}
		
		/*La mejora que se le haria a este metodo, es realizar todo dentro de un mismo for, ya que
		  para realizar toda la logica de este metodo se utilizan 2 for innecesarios,
		  lo que se haría es un solo recorrido que haria los siguiente:
		  1. mostrar el total de numeros pares dentro de la lista (metodo numerosParesEnTotal)
		  2. mostrar una lista con los numeros impares (metodo numerosImpares)
		  3. mostrar la posicion de un elemento dentro de la lista (metodo posicionDentroDeLista)
		  4. realizar toda la logica de los numeros mayores a "c"
		  
		  Todas esos metodos se ejecutaran dentro de un solo for y dara la misma salida.
		  
		  Aparte de eso se pueden realizar mejoras en el codigo como lo son acumuladores
		  que son con la siguiente sintaxis: c += 1 o c-= 1*/
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente 
		
		List<Integer> union = new ArrayList<Integer>();
		Set<Integer> hs = new HashSet<Integer>();
		
		/*Se utiliza HashSet ya que tiene una ventaja y es que agrega los elementos de una
		 coleccion sin agregar elementros repetidos, lo cual evita iteraciones sobre los mismos
		 para verificar que no se agreguen elementos repetidos a la lista "union"; el HastSet
		 no garantiza el orden de los elementos de las colecciones ya que tiene un algortirmo de
		 ordenamiento interno.*/
		
		 hs.addAll(lista1);
		 hs.addAll(lista2);
		 union.addAll(hs);
		 
		 /*Sin embargo, por aca dejo otra implementacion
		  
		  En el primer for, se debe hacer el recorrido de la lista1 ya que si se realizan lo siguiente:
		  union.addAll(list1), no se esta garantizando que la lista 1 no contenga elementos repetidos
		  
		 for (Integer n : lista1) {
			 if (!union.contains(n)) {
					union.add(n);
			 }
		 }
		 for (Integer m : lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		 }*/
		
		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		List<Integer> interseccion = new ArrayList<Integer>();
		List<Integer> interseccionFinal = new ArrayList<Integer>();
		interseccion.addAll(lista1);
		interseccion.retainAll(lista2);
		for (Integer m : interseccion) {
			if (!interseccionFinal.contains(m)) {
				interseccionFinal.add(m);
			}
		 }
		return interseccionFinal;
	}

	/***
	 * @param lista1
	 * 
	 * retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		
		List<Integer> listaOrdenadaAsc = new ArrayList<Integer>();
		listaOrdenadaAsc.addAll(lista1);
		Collections.sort(listaOrdenadaAsc);
		return listaOrdenadaAsc;
	}

	/***
	 * @param lista2
	 * 
	 * retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		
		List<Integer> listaOrdenadaDes = new ArrayList<Integer>();
		listaOrdenadaDes.addAll(lista2);
		Collections.sort(listaOrdenadaDes);
		Collections.reverse(listaOrdenadaDes);
		return listaOrdenadaDes;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
	 * 
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		
		boolean mismoContenido = lista1.equals(lista2);
		return mismoContenido;
	}

}
