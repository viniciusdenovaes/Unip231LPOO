package view.view_terminal;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import entidades.Pato;
import view.View;

@SuppressWarnings("resource")
public class ViewTerminal implements View{
	
	private ActionListener acaoAdicionarPato;
	private ActionListener acaoListarTodosPatos;
	private ActionListener acaoListarPatosByNome;
	private ActionListener acaoMostraPatoById;
	
	public void init() {
		int opcao = 0;
		do {
			opcao = getOpcao();
			switch(opcao) {
			case 1: adicionaPato();     break;
			case 2: listaTodosPatos();  break;
			case 3: listaPatosByNome(); break;
			case 4: encontraPatoById(); break;
			case 0: sair();             break;
			}
		}while(opcao!=0);
		System.exit(0);

	}
	
	public void showMsg(String msg) {
		System.out.println(msg);
	}
	
	
	@Override
	public Pato getPatoAdicionar() {
		return entraPato();
	}
	
	@Override
	public void setAcaoAdicionarPato(ActionListener al) {
		this.acaoAdicionarPato = al;
	}

	@Override
	public void setAcaoListarTodosPatos(ActionListener al) {
		this.acaoListarTodosPatos = al;
	}

	@Override
	public void listaTodosPatos(List<Pato> patos) {
		System.out.println("" + patos.size() + " encontrados");
		for(Pato p: patos) {
			System.out.println(p);
		}
	}

	@Override
	public void setAcaoListarPatosByNome(ActionListener al) {
		this.acaoListarPatosByNome = al;
	}

	@Override
	public String getKeyNome() {
		return entraNome();
	}

	@Override
	public void listaPatosByNome(List<Pato> patos, String keyNome) {
		System.out.println("Listando todos os patos com " + keyNome + " no nome:");
		System.out.println("" + patos.size() + " encontrados");
		for(Pato p: patos) {
			System.out.println(p);
		}

	}

	@Override
	public void setAcaoMostraPatoById(ActionListener al) {
		this.acaoMostraPatoById = al;
	}

	@Override
	public String getId() {
		return entraId();
	}
	
	@Override
	public void mostraPato(Pato pato, String id) {
		System.out.println("Procurando pato com id \"" + id +"\"");
		if(pato==null) {
			System.out.println("Pato nao encontrado");
		}else {
			System.out.println("Pato encontrado:");
			System.out.println(pato);
		}
	}

	
	
	public int getOpcao() {
		
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Escolha a opcao:");
		System.out.println("1 - para adicionar Pato");
		System.out.println("2 - listar todos patos");
		System.out.println("3 - listar todos patos por nome");
		System.out.println("4 - encontrar pato pelo id");
		System.out.println("0 - para sair do programa");
		System.out.println("--------------------------------");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		String linha = in.nextLine();
		
		try {
			return Integer.parseInt(linha);
		}catch (NumberFormatException e) {
			System.out.println("O valor entrado : " + linha + " nao eh valido");
			System.out.println("   a opcao deve ser um numero inteiro\n");
			return getOpcao();
		}
		
	}
	
	public void sair() {
		System.out.println("saindo do programa");
	}
	
	public void adicionaPato() {
		this.acaoAdicionarPato.actionPerformed(null);
	}
	
	public void listaTodosPatos() {
		System.out.println("Listando todos os patos");
		this.acaoListarTodosPatos.actionPerformed(null);
	}
	
	public void listaPatosByNome() {
		this.acaoListarPatosByNome.actionPerformed(null);
	}
	
	public void encontraPatoById() {
		acaoMostraPatoById.actionPerformed(null);
	}
	
	public Pato entraPato() {
		String id = entraId();
		
		String nome = entraNome();
		int idade = entraIdade();
		double peso = entraPeso();
		return new Pato(id, nome, idade, peso);
	}
	
	public String entraId() {
		System.out.println("Entre com o Id do pato");
		Scanner in = new Scanner(System.in);
		
		String id = in.nextLine();
		
		return id.trim();
	}
	
	public String entraNome() {
		System.out.println("Entre com o nome do pato");
		Scanner in = new Scanner(System.in);
		return in.nextLine().trim();
	}
	
	public int entraIdade() {
		System.out.println("Entre com a idade do pato");
		Scanner in = new Scanner(System.in);
		String idadeLine = in.nextLine();
		try {
			int idade = Integer.parseInt(idadeLine);
			if(idade<0) {
				throw new NumberFormatException("Idade negativa");
			}
			return idade;
		}catch (NumberFormatException e) {
			System.out.println("Entrada invalida: " + idadeLine);
			System.out.println("    Deve ser um inteiro positivo");
			return entraIdade();
		}
	}
	
	public double entraPeso() {
		System.out.println("Entre com o peso do pato");
		Scanner in = new Scanner(System.in);
		String pesoLine = in.nextLine();
		try {
			double peso = Double.parseDouble(pesoLine);
			if(peso<0) {
				throw new NumberFormatException("Peso negativo");
			}
			return peso;
		}catch (NumberFormatException e) {
			System.out.println("Entrada invalida: " + pesoLine);
			System.out.println("    Deve ser um real positivo");
			return entraPeso();
		}
	}


	
}






