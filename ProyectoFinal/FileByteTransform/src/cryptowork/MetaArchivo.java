package cryptowork;

public class MetaArchivo {
	private byte[] carga;
	private String nombre;
	
	public void setCarga(byte[] bytes){
		carga = bytes;
	}
	
	public byte[] getCarga(){
		return carga;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String string){
		nombre = string;
	}
}
