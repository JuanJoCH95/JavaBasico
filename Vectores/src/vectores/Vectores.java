package vectores;

import java.util.Scanner;

/*
 * Algoritmo para crear un Vector y ordenarlo por pares e impares (pares en orden ascendente e impares en orden descendente)
 */
public class Vectores {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int cantidad, contadorPares = 0, contadorImpares = 0, aux;
		
		//Acá se define el tamaño del vector
		System.out.print("Ingrese el tamaño del vector: ");
		cantidad = teclado.nextInt();
		
		int vector[] = new int[cantidad];
		
		//Se llena el vector
		for(int i = 0; i < vector.length; i++) {
			System.out.print("Ingrese numero: ");
			vector[i] = teclado.nextInt();
		}
		
		//Se cuenta cuantos pares e impares hay en el vector
		for(int i = 0; i < vector.length; i++) {
			if(vector[i] % 2 == 0) {
				contadorPares = contadorPares + 1;
			} else {
				contadorImpares = contadorImpares + 1;
			}
		}
		
		int pares[] = new int[contadorPares]; //Se crea un vector aparte con la cantidad de pares
		int impares[] = new int[contadorImpares]; // Se crea un vector aparte con la cantidad de impares
		int j = 0; 
		int k = 0;
		
		//Se llena el vector de pares con los pares que hay en el vector original
		while(j < pares.length) {
			for(int i = 0; i < vector.length; i++) {
				if(vector[i] % 2 == 0) {
					pares[j] = vector[i];
					j = j +1;
				}
			}
		}
		
		//Se llena el vector de impares con los impares que hay en el vector original
		while(k < impares.length) {
			for(int i = 0; i < vector.length; i++) {
				if(vector[i] % 2 != 0) {
					impares[k] = vector[i];
					k = k + 1;
				}
			}
		}
		
		//Se ordenan los pares de menor a mayor
		for(int i = 0; i < pares.length; i++) {
			for(int x = i + 1; x < pares.length; x++) {
				if(pares[i] > pares[x]) {
					aux = pares[i];
					pares[i] = pares[x];
					pares[x] = aux;
				}
			}
		}
		
		//Se ordenan los impares de mayor a menor
		for(int i = 0; i < impares.length; i++) {
			for(int x = i + 1; x < impares.length; x++) {
				if(impares[i] < impares[x]) {
					aux = impares[i];
					impares[i] = impares[x];
					impares[x] = aux;
				}
			}
		}
		
		System.out.print("[");
		for(int i = 0; i < pares.length; i++) {
			System.out.print(pares[i] + ", ");
		}

		for(int i = 0; i < impares.length; i++) {
			System.out.print(impares[i] + ", ");
		}
		System.out.print("]");
	}
}
