import filebytetransform.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import cryptowork.CryptoWork;
import cryptowork.MetaArchivo;
import cryptowork.MetaCryptic;

public class Bootstrapper {
	public void start(String[] info) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, IOException {
		MetaCryptic meta;
		MetaArchivo ma = new MetaArchivo();
		
		FileByteTransform transform = new FileByteTransform();
		CryptoWork cryp = new CryptoWork();
		JOptionPane.showMessageDialog(null, "Encripcion: " + info[0] + "\n" + "Modo: " + info[1] + "\n" + "PathIn: "
				+ info[2] + "\n" + "PathOut: " + info[3] + "\n" + "Direccion Llave Privada: " + info[4]+"\n"
				+ "Direccion Llave Publica: " + info[5]+"\n"+ "Direccion Llave Secreta: " + info[6]);

		if (info[1].toUpperCase().equals("ENCRIPTAR")) {

			ma = transform.convertir(info[2]);
			meta = cryp.encrypt(ma, info[0],info[4]);
			transform.archivar(ma, info[3],"C");

		} else if (info[1].toUpperCase().equals("DESENCRIPTAR")) {
			ma = transform.convertir(info[2]);
			meta = cryp.decrypt(ma, info[0], info[5],info[6]);
			transform.archivar(meta.getMa(), info[3],"D");

		}
	}
	
	public void genLlaves() throws NoSuchAlgorithmException, NoSuchProviderException, IOException{
		int entrada;
		entrada = JOptionPane.showConfirmDialog(null, "De verdad quiere crear un nuevo par de llaves?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
		if(entrada == 0){
			CryptoWork cryp = new CryptoWork();
			cryp.generarParDeLlaves();
		}
		return;
	}
}
