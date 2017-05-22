
package cryptowork;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptoWork {
	
	public MetaCryptic encrypt(byte[] bytes,String tipoEncripcion) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		MetaCryptic meta = new MetaCryptic();
		Security.addProvider(new BouncyCastleProvider());
		BouncyCastleProvider bcProvider = new BouncyCastleProvider();
		
		KeyGenerator genllave;
		genllave = KeyGenerator.getInstance(tipoEncripcion,bcProvider);
		genllave.init(new SecureRandom());
		
		SecretKey llave = genllave.generateKey();
		meta.setLlave(codificarLlave(llave));
		
		Cipher cipher = Cipher.getInstance(tipoEncripcion,bcProvider);
		cipher.init(Cipher.ENCRYPT_MODE, llave);
		
		meta.setCarga(cipher.doFinal(bytes));
		
		return meta;
	}
	
	
	public MetaCryptic decrypt(byte[] bytes,String tipoEncripcion,String llavePlana) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		MetaCryptic meta = new MetaCryptic();
		Security.addProvider(new BouncyCastleProvider());
		
		SecretKey llave = decodificarLlave(llavePlana,tipoEncripcion);
		
		Cipher cipher = Cipher.getInstance(tipoEncripcion,"BC");
		cipher.init(Cipher.ENCRYPT_MODE, llave);
		
		meta.setCarga(cipher.doFinal(bytes));
		
		return meta;
	}
	/*
	public MetaCryptic testDes(byte[] bytes){
		
		MetaCryptic meta = new MetaCryptic();
		
		
		try {
			//Creamos el generador de claves
			KeyGenerator keygen;
			keygen = KeyGenerator.getInstance("DES");
			
			//generamos llave secreta
			SecretKey myDesKey = keygen.generateKey();
			meta.setLlave(codificarLlave(myDesKey));
			
			//inicializamos cifrado
			Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			//ciframos
			meta.setCarga(desCipher.doFinal(bytes));
			
			return meta;
						
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

		
		
	}
	
public MetaCryptic testDesDec(byte[] bytes,String llave){
		
		MetaCryptic meta = new MetaCryptic();
		
		try {
			//regeneramos llave

			SecretKey myDesKey = decodificarLlave(llave);
			
			//inicializamos cifrado
			Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
			//ciframos
			meta.setCarga(desCipher.doFinal(bytes));
			
			return meta;
						
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

		
		
	}
	*/
	private SecretKey decodificarLlave(String llave,String tipoEncripcion){
		
		byte[] decodedKey = Base64.getDecoder().decode(llave);
		
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, tipoEncripcion); 

		return originalKey;
		
	}

	private String codificarLlave(SecretKey llave){
		
		String encodedKey = Base64.getEncoder().encodeToString(llave.getEncoded());
		return encodedKey;
		
	}
}
