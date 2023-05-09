package dao.csv;

import entidades.Pato;

public class TesteDadoCSV {
	
	public static void main(String[] args) {
		
		DaoCSV daoCSV = new DaoCSV("files");
		
		Pato novoPato01 = new Pato("111", "Donaldo", 2, 1);
		Pato novoPato02 = new Pato("112", "didon", 1, 2);
		Pato novoPato03 = new Pato("113", "val", 1, 2);
		
		System.out.println(daoCSV.getTodosPatos());
		
		System.out.println("adicionando novo pato " + novoPato01 + ": " + daoCSV.addPato(novoPato01));
		System.out.println("adicionando novo pato " + novoPato02 + ": " + daoCSV.addPato(novoPato02));
		System.out.println("adicionando novo pato " + novoPato03 + ": " + daoCSV.addPato(novoPato03));
		System.out.println("adicionando novo pato " + novoPato03 + ": " + daoCSV.addPato(novoPato03));
		
		System.out.println(daoCSV.getTodosPatos());
		
		
		System.out.println(daoCSV.getPatosByNome("don"));
		System.out.println(daoCSV.getPatoById("111"));
		
		
	}

}
