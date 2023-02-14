package ex02;

public class TesteAluno {
	
	public static void main(String[] args) {
		Aluno aluno01 = new Aluno("123", new Nome("fulano", "Silva"), 7.0, 8.5);
		aluno01.relatorio();
		
		Aluno aluno02 = new Aluno("124", new Nome("beltrano", "Souza"), 4.0, 7.5);
		aluno02.relatorio();
	}

}
