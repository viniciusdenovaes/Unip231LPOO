package view;

import java.util.Collection;
import java.util.Scanner;

import dados.Dados;
import dao.Dao;
import entidades.Pato;

public class View{
	
	Dao dao;
	Dados dados;
	
	public View() {
		dados = new Dados();
		dao = new Dao("files/patos.csv", dados);
	}
	
	public void init() {
		dao.loadPatos();
		controller();
	}
	
	public void controller() {
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
		System.out.println("salvando patos");
		dao.savePatos();
	}
	
	public void adicionaPato() {
		Pato pato = entraPato();
		if(pato==null) {
			return;
		}
		if(dados.addPato(pato)) {
			System.out.println("Adicionando Pato " + pato);
		}
		else {
			System.out.println("Falha ao adicionar pato " + pato);
		}
		
	}
	
	public void listaTodosPatos() {
		System.out.println("Listando todos os patos");
		for(Pato p: dados.getPatos()) {
			System.out.println(p);
		}
	}
	
	public void listaPatosByNome() {
		String nome = entraNome();
		listaPatosByNome(nome);
	}
	public void listaPatosByNome(String keyNome) {
		System.out.println("Listando todos os patos.nome contem \"" + keyNome+"\"");
		Collection<Pato> patos = dados.getPatosByNome(keyNome);
		if(patos.size()==0) {
			System.out.println("Nenhum pato em que nome contem " + keyNome);
		}
		System.out.println("   " + patos.size() + " patos encontrados");
		for(Pato p: patos) {
			System.out.println(p);
		}
		System.out.println();
	}
	
	public void encontraPatoById() {
		String id = entraId();
		encontraPatoById(id);
	}
	public void encontraPatoById(String keyId) {
		System.out.println("Procurando pato com id \"" + keyId +"\"");
		Pato p = dados.getPatoById(keyId);
		if(p==null) {
			System.out.println("Pato nao encontrado");
		}else {
			System.out.println("Pato encontrado:");
			System.out.println(p);
		}
	}
	
	
	
	public Pato entraPato() {
		String id = entraId();
		
		Pato temPato = dados.getPatoById(id);
		if(temPato!=null) {
			System.out.println("Já temos um pato com este id:");
			System.out.println(temPato);
			return null;
		}
		
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






