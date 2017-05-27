package filebytetransform;
/**
 * Clase encargada de convertir un archivo en un arreglo de Bytes
 * @author David del Real Sifuentes
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import cryptowork.MetaArchivo;

import java.nio.file.Path;

public class FileByteTransform {
	
	/**
	 * Abre un archivo y regresa su contenido en forma de un arreglo de bytes
	 * @param string ruta Direccion del archivo en el sistema.
	 * @return array|byte[] Si se encuentra con una excepcion regresa null, si no, regresa el arreglo de bytes del archivo
	 */
	public MetaArchivo convertir(String ruta){
		MetaArchivo ma = new MetaArchivo();
		Path path;
		path = Paths.get(ruta);
		String nombre = "";
		byte[] bytes;
		try {
			
			bytes = Files.readAllBytes(path);
			nombre = path.getFileName().toString();
			ma.setCarga(bytes);
			ma.setNombre(nombre);
			return ma;
			
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
	public void archivar(MetaArchivo ma, String direccion,String param){
		
		Path path;
		path = Paths.get(direccion+"\\"+param+ma.getNombre());
		
		try {
			
			Files.write(path, ma.getCarga());
			
		} catch (IOException e) {
			
			System.err.println("Hubo un error al escribir el archivo, revise la pila de errores");
			e.printStackTrace();
			
		}
	}
	/**
	 * Metodo usado para imprimir las llaves a un archivo
	 * @param path Direccion de la llave
	 * @param llave Bytes de la llave
	 * @throws IOException
	 */
	public void archivarLlaves(String path, byte[] llave) throws IOException{
		File f = new File(path);
		f.getParentFile().mkdirs();
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(llave);
		fos.flush();
		fos.close();
	}
	
	/**
	 * Se encarga de leer las llaves de un archivo
	 * @param path Direccion del archivo de la llave
	 * @return Bytes de la llave
	 * @throws IOException
	 */
	public byte[] convertirLlaves(String path) throws IOException{
		byte[] bytesLlave = Files.readAllBytes(new File(path).toPath());
		return bytesLlave;
	}
	
	/**
	 * Se encarga de leer y convertir los bytes de la llave a una llave privada
	 * @param path Direccion de la llave
	 * @return La llave privada
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeySpecException
	 */
	public PrivateKey getPrivate(String path) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException{
		Security.addProvider(new BouncyCastleProvider());
		byte[] bytesLlave = Files.readAllBytes(new File(path).toPath());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytesLlave);
		KeyFactory kf = KeyFactory.getInstance("RSA", "BC");
		return kf.generatePrivate(spec);
	}

	/**
	 * Metodo que se encarga de leer los bytes de la llave publica y convertirla a objeto
	 * @param path Direccion de la llave publica
	 * @return La llave publica
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeySpecException
	 * @throws IOException
	 */
	public PublicKey getPublic(String path) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException{
		byte[] bytesLlave = Files.readAllBytes(new File(path).toPath());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(bytesLlave);
		KeyFactory kf = KeyFactory.getInstance("RSA", "BC");
		return kf.generatePublic(spec);
	}
}
