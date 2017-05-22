package cryptowork;

public class MetaCryptic {
	
	private String llave;
	private byte[] carga;
	
	public String getLlave(){
		return llave;
	}
	
	public byte[] getCarga(){
		return carga;
	}
	
	public void setLlave(String cad){
		llave = cad;
	}
	
	public void setCarga(byte[] bytes){
		carga = bytes;
	}
	
	
}
