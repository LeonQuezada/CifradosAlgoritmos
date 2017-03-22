package hashing;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class HashCore {
	private File archivo;
	/*
	 * 1 Recibe la direccion de un archivo
	 * 2 Envia la direccion a abrirArchivo(); devuelve un objeto tipo archivo
	 * 3 Envia el objeto del archivo a serializa();
	 * 4 Devuelve un array de bytes.
	 * 5 divide el arreglo en 4
	 * 5.1 Si un arreglo tiene menos elementos, se rellena con ceros
	 * 6.- Se hace la operacion XOR entre el arreglo 1 y el arreglo 2, luego el arreglo 3 con el arreglo 4
	 * 7.- Se guarda el hash en un archivo .dat
	 */
	//1
	public void hash(String direccion){
		//2
		abrirArchivo(direccion);
		//3 - 4
		byte[] archivoBytes;
		archivoBytes = serializa();
		//5
		
		
	}
	//2
	private void abrirArchivo(String direccion){
		try{
			archivo = new File(direccion);
		}catch(Exception w){
			w.printStackTrace();
		}
	}
	
	//3 - 4
	private byte[] serializa(){
		byte[] archivoBytes;
		archivoBytes = new byte[(int)archivo.length()];
		try {
			FileInputStream fis = new FileInputStream(archivo);
			fis.read(archivoBytes);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return archivoBytes;
	}
	
	//5
	private void dividirArreglo(){
		
	}
	
	//6
	private void xorArray(){
		
	}
	
	//7
	private void imprimirXOR(){}

}
