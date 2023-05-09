package dao;

import java.util.List;
/*
adicionar Pato
listar todos patos
listar todos patos por nome
encontrar pato pelo id
*/

import entidades.Pato;


public interface Dao {
	
	public boolean addPato(Pato p);
	public List<Pato> getTodosPatos();
	public List<Pato> getPatosByNome(String keyName);
	public Pato getPatoById(String id);

}
