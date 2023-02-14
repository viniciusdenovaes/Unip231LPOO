package ex03;

public class TesteAluno {
	
	public static void main(String[] args) {
		Cadastro cadastro01 = new Cadastro(
				new Nome("Fulano", "Silva"), 
				new Endereco("Amelia", 10));
		Aluno aluno01 = new Aluno("123", cadastro01, 7.0, 8.5);
		aluno01.relatorio();
		
		Cadastro cadastro02 = new Cadastro(
				new Nome("Beltrano", "Souza"), 
				new Endereco("Candido", 20));
		Aluno aluno02 = new Aluno("124", cadastro02, 4.0, 7.5);
		aluno02.relatorio();
	}

}
