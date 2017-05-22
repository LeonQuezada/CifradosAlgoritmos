package filebytetransform;
/**
 * Clase encargada de convertir un archivo en un arreglo de Bytes
 * @author David del Real Sifuentes
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileByteTransform {
	
	/**
	 * Abre un archivo y regresa su contenido en forma de un arreglo de bytes
	 * @param string ruta Direccion del archivo en el sistema.
	 * @return array|byte[] Si se encuentra con una excepcion regresa null, si no, regresa el arreglo de bytes del archivo
	 */
	public byte[] convertir(String ruta){
		Path path;
		path = Paths.get(ruta);
		byte[] bytes;
		try {
			
			bytes = Files.readAllBytes(path);
			return bytes;
			
		} catch (IOException e) {
			
			System.err.println("Hubo un error al abrir el archivo, revise la pila de errores");
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	/**
	 * Escribe un arreglo de bytes al disco.
	 * @param bytes Arreglo de bytes
	 * @param direccion Direccion en disco.
	 */
	public void archivar(byte[] bytes, String direccion){
		
		Path path;
		path = Paths.get(direccion);
		
		try {
			
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			System.err.println("Hubo un error al escribir el archivo, revise la pila de errores");
			e.printStackTrace();
			
		}
	}
}
