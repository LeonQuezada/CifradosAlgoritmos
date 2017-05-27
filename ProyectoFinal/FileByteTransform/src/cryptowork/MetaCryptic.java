package cryptowork;

public class MetaCryptic {
	
	private byte[] llave;
	private MetaArchivo ma;
	
	public MetaArchivo getMa(){
		return ma;
	}
	
	public void setMa(MetaArchivo metaA){
		ma = metaA;
	}
	
	public byte[] getLlave(){
		return llave;
	}
	
	public void setLlave(byte[] cad){
		llave = cad;
	}
	
}
