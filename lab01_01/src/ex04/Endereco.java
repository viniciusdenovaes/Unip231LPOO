package ex04;

public class Endereco {
	
	public String rua;
	public int numero;
	
	public Endereco(String aRua, int aNumero) {
		this.rua = aRua;
		this.numero = aNumero;
	}

	@Override
	public String toString() {
		return rua + ", " + numero;
	}
	
	
	

}
