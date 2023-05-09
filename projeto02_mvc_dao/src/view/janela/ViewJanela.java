package view.janela;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidades.Pato;
import view.View;

@SuppressWarnings("serial")
public class ViewJanela extends JFrame implements View{
	
	JButton botaoAddPato = new JButton("Adiciona Pato");
	JButton botaoListaPatos = new JButton("Mostra Patos");
	JButton botaoBuscaPatoNome = new JButton("Buscar Nome");
	JButton botaoBuscaPatoId= new JButton("Buscar Id");
	
	JTextField fieldAddPatoId = new JTextField(20);
	JTextField fieldAddPatoNome = new JTextField(20);
	JTextField fieldAddPatoIdade = new JTextField(20);
	JTextField fieldAddPatoPeso = new JTextField(20);

	JTextField fieldBuscaPatoNome = new JTextField(20);
	
	JTextField fieldBuscaPatoId = new JTextField(20);
	
	JLabel msgLabel = new JLabel(" ");
	
	
	public ViewJanela() {
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(msgLabel);
		
		
		add(new JLabel("id:"));
		add(fieldAddPatoId);
		add(new JLabel("nome:"));
		add(fieldAddPatoNome);
		add(new JLabel("idade:"));
		add(fieldAddPatoIdade);
		add(new JLabel("peso:"));
		add(fieldAddPatoPeso);
		add(botaoAddPato);
		
		add(botaoListaPatos);
		
		add(new JLabel("keyName:"));
		add(fieldBuscaPatoNome);
		add(botaoBuscaPatoNome);
		
		add(new JLabel("buscar id:"));
		add(fieldBuscaPatoId);
		add(botaoBuscaPatoId);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	
	@Override
	public void init() {
		setVisible(true);
	}

	@Override
	public void showMsg(String msg) {
		msgLabel.setText(msg);
		
	}

	@Override
	public void setAcaoAdicionarPato(ActionListener al) {
		botaoAddPato.addActionListener(al);
	}

	@Override
	public Pato getPatoAdicionar() {
		String id = fieldAddPatoId.getText();
		if(id.isEmpty()) {
			msgLabel.setText("id vazio");
			return null;
		}
		String nome = fieldAddPatoNome.getText();
		if(nome.isEmpty()) {
			msgLabel.setText("nome vazio");
			return null;
		}
		try {
			int idade = Integer.parseInt(fieldAddPatoIdade.getText());
			double peso = Double.parseDouble(fieldAddPatoPeso.getText());
			if(peso < 0 || idade < 0) {
				throw new NumberFormatException("peso ou idade menor que zero");
			}
			return new Pato(id, nome, idade, peso);
		}catch(NumberFormatException e) {
			msgLabel.setText("idade ou peso errado");
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void setAcaoListarTodosPatos(ActionListener al) {
		botaoListaPatos.addActionListener(al);
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
		botaoBuscaPatoNome.addActionListener(al);
	}

	@Override
	public String getKeyNome() {
		return fieldBuscaPatoNome.getText();
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
		botaoBuscaPatoId.addActionListener(al);
	}

	@Override
	public String getId() {
		return fieldBuscaPatoId.getText();
	}

	@Override
	public void mostraPato(Pato pato, String id) {
		System.out.println(pato);
	}

}
