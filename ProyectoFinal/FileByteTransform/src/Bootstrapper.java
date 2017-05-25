import filebytetransform.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import cryptowork.CryptoWork;
import cryptowork.MetaCryptic;

public class Bootstrapper {
	public void start(String[] info) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		byte[] arreglo;
		MetaCryptic meta;
		FileByteTransform transform = new FileByteTransform();
		CryptoWork cryp = new CryptoWork();
		JOptionPane.showMessageDialog(null, "Encripcion: " + info[0] + "\n" + "Modo: " + info[1] + "\n" + "PathIn: "
				+ info[2] + "\n" + "PathOut: " + info[3] + "\n" + "Contraseña: " + info[4]);

		if (info[1].toUpperCase().equals("ENCRIPTAR")) {

			arreglo = transform.convertir(info[2]);
			meta = cryp.encrypt(arreglo, info[0]);
			transform.archivar(arreglo, info[3]);
			JTextArea text = new JTextArea("Tu Constraseña es:" + meta.getLlave());
			JOptionPane.showMessageDialog(null,text);

		} else if (info[1].toUpperCase().equals("DESENCRIPTAR")) {

			arreglo = transform.convertir(info[2]);
			meta = cryp.decrypt(arreglo, info[0], info[4]);
			transform.archivar(arreglo, info[3]);

		}
	}
}
