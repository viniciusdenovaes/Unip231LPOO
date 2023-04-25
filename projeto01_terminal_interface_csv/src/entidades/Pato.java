package entidades;

public class Pato {
	
	private String id;
	private String nome;
	private int idade;
	private double peso;
	
	public Pato(String aId, String aNome, int aIdade, double aPeso) {
		this.id = aId;
		this.nome = aNome;
		this.idade = aIdade;
		this.peso = aPeso;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Pato [id=" + id + ", nome=" + nome + ", idade=" + idade + ", peso=" + peso + "]";
	}
	
	
	
	
	
	

}
