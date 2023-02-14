package ex01;

public class TesteAluno {
	
	public static void main(String[] args) {
		Aluno aluno01 = new Aluno("123", "fulano", 7.0, 8.5);
		aluno01.relatorio();
		
		Aluno aluno02 = new Aluno("124", "beltrano", 4.0, 7.5);
		aluno02.relatorio();
	}

}
