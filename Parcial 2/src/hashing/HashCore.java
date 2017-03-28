package hashing;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class HashCore {
	private File archivo;
	private byte[] arregloA;
	private byte[] arregloB;
	private byte[] arregloC;
	/*
	 * 1 Recibe la direccion de un archivo
	 * 2 Envia la direccion a abrirArchivo(); devuelve un objeto tipo archivo
	 * 3 Envia el objeto del archivo a serializa();
	 * 4 Devuelve un array de bytes.
	 * 5 divide el arreglo en 4
	 * 5.1 Si un arreglo tiene menos elementos, se rellena con ceros
	 * 6.- Se hace la operacion XOR entre el arreglo 1 y el arreglo 2, el resultado se guarda en arreglo 3.
	 * 7.- Se guarda el hash en un archivo .dat
	 */
	//1
	public void hash(String direccion) throws IOException{
		//2
		abrirArchivo(direccion);
		//3 - 4
		byte[] archivoBytes;
		archivoBytes = serializa();
		//5
		dividirArreglo(archivoBytes);
		xorArray();
		imprimirXOR();
		
		
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
	private void dividirArreglo(byte[] arreglo){
		int size;
		size = arreglo.length;
		if(size % 2 != 0){
			size++;
			byte[] arrayMid;
			arrayMid = new byte[size];
			arrayMid = Arrays.copyOfRange(arreglo, 0, size-1);
		}

		arregloA = new byte[size];
		arregloB = new byte[size];
		arregloC = new byte[size/2];
		
		arregloA = Arrays.copyOfRange(arreglo, 0, size/2);
		arregloB = Arrays.copyOfRange(arreglo, size/2, size);
		
		System.out.println("size:"+size+"\narrayA:"+arregloA.length+"\narrayB:"+arregloB.length);
	}
	
	//6
	private void xorArray(){
		System.out.println("vacio:"+arregloC.length);
		for(int i = 0; i < arregloC.length;i++){
			arregloC[i] = (byte) (arregloA[i] ^ arregloB[i]);
			//System.out.println("arregloC: "+arregloC[i]+"\narregloA: "+arregloA[i]+"\narregloB: "+arregloB[i]);
		}
		
	}
	
	//7
	private void imprimirXOR() throws IOException{
		try {
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\hash.dat");
			fos.write(arregloC);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
