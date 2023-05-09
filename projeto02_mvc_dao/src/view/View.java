package view;

import java.awt.event.ActionListener;
import java.util.List;

import entidades.Pato;

/*
adicionar Pato
listar todos patos
listar todos patos por nome
encontrar pato pelo id
*/


public interface View{
	
	public void init();
	public void showMsg(String msg);
	
	public void setAcaoAdicionarPato(ActionListener al);
	public Pato getPatoAdicionar();
	
	public void setAcaoListarTodosPatos(ActionListener al);
	public void listaTodosPatos(List<Pato> patos);
	
	public void setAcaoListarPatosByNome(ActionListener al);
	public String getKeyNome();
	public void listaPatosByNome(List<Pato> patos, String keyNome);
	
	public void setAcaoMostraPatoById(ActionListener al);
	public String getId();
	public void mostraPato(Pato pato, String id);
	
	
	
}






