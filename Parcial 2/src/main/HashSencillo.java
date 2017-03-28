package main;

import java.io.IOException;
import java.util.Scanner;
import hashing.HashCore;

public class HashSencillo {

	
	/*
	 * El Main arranca el programa.
	 * 1.- Pregunta por el nombre del archivo a hashear
	 * 2.- Pregunta por el archivo a verificar y el archivo .dat.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashCore hCore = new HashCore();
		Scanner sc = new Scanner(System.in);
		String entrada;
		while(true){
			System.out.println("1.- Obtener hash de un archivo: ");
			System.out.println("2.- Comparar dos hash");
			System.out.println("3.- Salir");
			entrada = sc.nextLine();
			
			if(entrada.trim().startsWith("1")){
				//llamar a HashCore.Hash();
				hCore = new HashCore();
				String direccion;
				System.out.println("Inserte la direccion de un archivo");
				direccion = sc.nextLine();
				hCore.hash(direccion);
			}
			else
			if(entrada.trim().startsWith("2")){
				//llamar a HashCore.Hash();
				hCore = new HashCore();
				String direccionHash1;
				String direccionHash2;
				System.out.println("Inserte la direccion del Primer Hash");
				direccionHash1 = sc.nextLine();
				System.out.println("Inserte la direccion del Segundo Hash");
				direccionHash2 = sc.nextLine();
				System.out.println(hCore.hashComparar(direccionHash1, direccionHash2));
			}
			{
				System.exit(0);
			}
			
		}

	}

}
