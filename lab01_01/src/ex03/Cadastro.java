package ex03;

public class Cadastro {
	
	Nome nome;
	Endereco endereco;
	
	public Cadastro(Nome aNome, Endereco aEndereco) {
		this.nome = aNome;
		this.endereco = aEndereco;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "Cadastro: \n";
		res += "Nome: " + this.nome + "\n";
		res += "Endereco: " + this.endereco;
		return res;
	}
	
	

}
