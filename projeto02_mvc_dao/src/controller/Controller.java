package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dao.Dao;
import entidades.Pato;
import view.View;

public class Controller {
	
	private View view;
	private Dao model;
	
	public Controller(Dao model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void init() {
		view.setAcaoAdicionarPato(new AcaoAdicionarPato());
		view.setAcaoListarTodosPatos(new AcaoListarTodosPatos());
		view.setAcaoListarPatosByNome(new AcaoListarPatosByNome());
		view.setAcaoMostraPatoById(new AcaoMostraPatoById());
		
		view.init();
		
	}
	
	
	class AcaoAdicionarPato implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Pato pato = view.getPatoAdicionar();
			if(pato==null) {
				return;
			}
			boolean is_adicionou = model.addPato(pato);
			if(!is_adicionou) {
				view.showMsg("Pato " + pato + " nao foi adicionado");
			}
		}
	}
	
	class AcaoListarTodosPatos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			List<Pato> patos = model.getTodosPatos();
			view.listaTodosPatos(patos);
		}
	}
	
	class AcaoListarPatosByNome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String keyNome = view.getKeyNome();
			List<Pato> patos = model.getPatosByNome(keyNome);
			view.listaPatosByNome(patos, keyNome);
		}
	}
	
	class AcaoMostraPatoById implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = view.getId();
			Pato pato = model.getPatoById(id);
			view.mostraPato(pato, id);
		}
	}
	


}
