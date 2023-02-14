package ex02;

public class Nome {
	
	String primeiroNome;
	String sobreNome;
	
	public Nome(String aPrimeiroNome, String aSobrenome) {
		this.primeiroNome = aPrimeiroNome;
		this.sobreNome = aSobrenome;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += this.primeiroNome + " " + this.sobreNome;
		return res;
	}
	

}
