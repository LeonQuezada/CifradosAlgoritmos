
package cryptowork;

import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import filebytetransform.FileByteTransform;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.dsig.Transform;

public class CryptoWork {
	/**
	 * Metodo que encripta el archivo, tambien encripta la llave usando rsa
	 * @param ma El meta objeto del archivo a encriptar, tiene los bytes del archivo y el nombre
	 * @param tipoEncripcion String que dice que algoritmo se usara
	 * @param path Direccion de la llave privada
	 * @return meta Meta objeto donde se guarda la llava (si se va a desencriptar) y el meta objeto del archivp
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws IOException
	 */
	public MetaCryptic encrypt(MetaArchivo ma,String tipoEncripcion,String path) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException{
		MetaCryptic meta = new MetaCryptic();
		
		Security.addProvider(new BouncyCastleProvider());
		BouncyCastleProvider bcProvider = new BouncyCastleProvider();
		
		KeyGenerator genllave;
		genllave = KeyGenerator.getInstance(tipoEncripcion,bcProvider);
		genllave.init(new SecureRandom());
		
		SecretKey llave = genllave.generateKey();
		encriptarLlave(path, llave.getEncoded());
		
		Cipher cipher = Cipher.getInstance(tipoEncripcion,bcProvider);
		cipher.init(Cipher.ENCRYPT_MODE, llave);
		
		ma.setCarga(cipher.doFinal(ma.getCarga()));
		meta.setMa(ma);
		
		return meta;
	}
	
	/**
	 * Se encarga de desencriptar el archivo, primero desencripta la llave usando rsa
	 * @param ma Meta objeto que representa al archivo
	 * @param tipoEncripcion String que dice cual algoritmo se va a usar
	 * @param path Direccion de la llave Publica
	 * @param path2 Direccion de la llave encriptada para el archivo
	 * @return meta Meta objeto que contiene los bytes del archivo desencriptado
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeySpecException
	 * @throws IOException
	 */
	public MetaCryptic decrypt(MetaArchivo ma,String tipoEncripcion,String path,String path2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException{
		MetaCryptic meta = new MetaCryptic();
		Security.addProvider(new BouncyCastleProvider());
		SecretKey llave = decodificarLlave(desencriptarLlave(path,path2));
		
		Cipher cipher = Cipher.getInstance(tipoEncripcion,"BC");
		cipher.init(Cipher.DECRYPT_MODE, llave);
		ma.setCarga(cipher.doFinal(ma.getCarga()));
		meta.setMa(ma);
		
		return meta;
	}
	
	private SecretKey decodificarLlave(byte[] llave){
		
		//byte[] decodedKey = Base64.getDecoder().decode(llave);
		
		SecretKey originalKey = new SecretKeySpec(llave, 0, llave.length, "RSA");

		return originalKey;
		
	}
	/**
	 * utilizado para codificar la llave secreta de un archivo en bytes y luego a String
	 * @deprecated
	 */
	private String codificarLlave(SecretKey llave){
		
		String encodedKey = Base64.getEncoder().encodeToString(llave.getEncoded());
		return encodedKey;
		
	}
	
	/**
	 * Este metodo genera un par de llaves, publica y privada para usar en RSA y luego los imprime a sus respectivos archivos
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public void generarParDeLlaves() throws NoSuchAlgorithmException, NoSuchProviderException, IOException{
		KeyPairGenerator generador;
		KeyPair par;
		PrivateKey llavePrivada;
		PublicKey llavePublica;
		Security.addProvider(new BouncyCastleProvider());
		
		generador = KeyPairGenerator.getInstance("RSA", "BC");
		generador.initialize(1024);
		
		par = generador.generateKeyPair();
		llavePrivada = par.getPrivate();
		llavePublica = par.getPublic();
		FileByteTransform transform = new FileByteTransform();
		transform.archivarLlaves("Par/publica", llavePublica.getEncoded());
		transform.archivarLlaves("Par/privada", llavePrivada.getEncoded());
	}
	
	/**
	 * Aqui se encripta la llave secreta del archivo que se esta encriptando,
	 * y luego la imprime a un archivo.
	 * @param path Direccion de la llave privada
	 * @param input Bytes de la llave a encriptar
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeySpecException
	 * @throws IOException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public void encriptarLlave(String path,byte[]input) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		FileByteTransform transform = new FileByteTransform();
		PrivateKey llavePrivada = transform.getPrivate(path);
		Security.addProvider(new BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance("RSA","BC");
		cipher.init(Cipher.ENCRYPT_MODE,llavePrivada);
		transform.archivarLlaves(System.getProperty("user.dir")+"/llave-encriptada", cipher.doFinal(input));
	}
	
	/**
	 * Aqui se desencripta la llave del archivo a desencriptar
	 * @param path Direccion de la llave publica
	 * @param path2 Direccion de la llave del archivo
	 * @return byte[] Bytes de la llave del archivo a descifrar
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeySpecException
	 * @throws IOException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] desencriptarLlave(String path, String path2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		FileByteTransform transform = new FileByteTransform();
		byte[] input = transform.convertirLlaves(path2);
		PublicKey llavePublica = transform.getPublic(path);
		Security.addProvider(new BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance("RSA","BC");
		cipher.init(Cipher.DECRYPT_MODE,llavePublica);
		return cipher.doFinal(input);
	}
	
}
