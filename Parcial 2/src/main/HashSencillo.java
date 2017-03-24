package main;

import java.util.Scanner;
import hashing.HashCore;

public class HashSencillo {

	
	/*
	 * El Main arranca el programa.
	 * 1.- Pregunta por el nombre del archivo a hashear
	 * 2.- Pregunta por el archivo a verificar y el archivo .dat.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashCore hCore = new HashCore();
		Scanner sc = new Scanner(System.in);
		String entrada;
		while(true){
			System.out.println("1.- Obtener hash de un archivo: ");
			System.out.println("2.- Salir");
			entrada = sc.nextLine();
			
			if(entrada.trim().startsWith("1")){
				//llamar a HashCore.Hash();
				hCore = new HashCore();
				String direccion;
				System.out.println("Inserte la direccion de un archivo");
				direccion = sc.nextLine();
				hCore.hash(direccion);
			}
			else{
				System.exit(0);
			}
			
		}

	}

}
