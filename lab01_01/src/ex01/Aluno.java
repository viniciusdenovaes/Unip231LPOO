package ex01;

public class Aluno {
	
	public String ra;
	public String nome;
	public double notaNP1;
	public double notaNP2;
	
	public Aluno(String aRa, String aNome, 
			double aNotaNP1, double aNotaNP2) {
		super();
		this.ra = aRa;
		this.nome = aNome;
		this.notaNP1 = aNotaNP1;
		this.notaNP2 = aNotaNP2;
	}
	
	public void relatorio() {
		System.out.println(this);
		double media = (this.notaNP1 + this.notaNP2)/2.0;
		if(media>=7) {
			System.out.println("O aluno passou");
		}else {
			System.out.println("O aluno nao passou");
		}
		System.out.println();
	}

	@Override
	public String toString() {
		String res = "";
		res += "Nome: " + this.nome + "\n";
		res += "RA: " + this.ra + "\n";
		res += "NotaNP1: " + this.notaNP1 + "\n";
		res += "NotaNP2: " + this.notaNP2;
		return res;
	}
	
	
	
	

}
