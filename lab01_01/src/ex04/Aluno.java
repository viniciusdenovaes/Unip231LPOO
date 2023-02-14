package ex04;

public class Aluno {
	
	public String ra;
	public Cadastro cadastro;
	public Boletim boletim;
	
	public Aluno(String aRa, Cadastro aCadastro, 
			Boletim aBoletim) {
		super();
		this.ra = aRa;
		this.cadastro = aCadastro;
		this.boletim = aBoletim;
	}
	
	public void relatorio() {
		System.out.println(this);
		if(this.boletim.passou()) {
			System.out.println("O aluno passou");
		}else {
			System.out.println("O aluno nao passou");
		}
		System.out.println();
	}

	@Override
	public String toString() {
		String res = "";
		res += this.cadastro + "\n";
		res += "RA: " + this.ra + "\n";
		res += this.boletim;
		return res;
	}
	
	
	
	

}
