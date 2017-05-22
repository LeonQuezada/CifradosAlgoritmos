import filebytetransform.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.TransferHandler.TransferSupport;

import cryptowork.*;

public class Main {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Scanner scan;
		MetaCryptic meta;
		FileByteTransform transform;
		CryptoWork cryp;
		scan = new Scanner(System.in);
		cryp = new CryptoWork();

		transform = new FileByteTransform();
		byte[] arreglo;
		String input, path, pathSalida, password, type;
		int input2;
		
		System.out.println("Introduzca:\n1.-AES\n2.-DES\n3.-IDEA");
		input2 = scan.nextInt();
		
		if(input2 == 1){
			type = "AES";
		}
		else if(input2 == 2){
			type = "DES";
		}
		else {
			type = "IDEA";
		}
		
		System.out.println("Introduzca E para encriptar y D para desencriptar:");
		input = scan.nextLine();

		do {
			if (input.toUpperCase().equals("E")) {
				System.out.println("Introduzca direccion del archivo a encriptar:");
				path = scan.nextLine();
				System.out.println("introduzca direccion de salida para el archivo encriptado:");
				pathSalida = scan.nextLine();

				arreglo = transform.convertir(path);
				meta = cryp.encrypt(arreglo, type);
				transform.archivar(arreglo, pathSalida);

				System.out.println("Lo guarde en: " + pathSalida);
				System.out.println("La contraseña es: " + meta.getLlave());
			} else if (input.toUpperCase().equals("D")) {
				System.out.println("Introduzca direccion del archivo a desencriptar:");
				path = scan.nextLine();
				System.out.println("Introduzca direccion de salida para el archivo desencriptado:");
				pathSalida = scan.nextLine();
				System.out.println("Introduzca la contraseña:");
				password = scan.nextLine();

				arreglo = transform.convertir(path);
				meta = cryp.decrypt(arreglo, type, password);
				transform.archivar(arreglo, pathSalida);

				System.out.println("Lo guarde en: " + pathSalida);
			}
			System.out.println("Introduzca E para encriptar y D para desencriptar:");
			input = scan.nextLine();
		} while (true);

		/*
		 * try{ if(args[0].toUpperCase().equals("E")){
		 * 
		 * arreglo = transform.convertir(args[1]); meta = cryp.encrypt(arreglo,
		 * "AES"); transform.archivar(meta.getCarga(), args[2]);
		 * System.out.println("Lo guarde en: "+args[2]);
		 * System.out.println("Tu llave es:"+meta.getLlave()); } else
		 * if(args[0].toUpperCase().equals("D")){
		 * 
		 * arreglo = transform.convertir(args[1]); meta = cryp.decrypt(arreglo,
		 * "AES", args[3]); transform.archivar(meta.getCarga(), args[2]);
		 * System.out.println("Lo guarde en: "+args[2]);
		 * 
		 * }
		 * 
		 * }catch (Exception w){
		 * 
		 * System.err.println("No recibi los dos parametros :c");
		 * w.printStackTrace();
		 * 
		 * }
		 */
	}

}
