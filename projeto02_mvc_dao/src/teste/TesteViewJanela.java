package teste;

import controller.Controller;
import dao.csv.DaoCSV;
import view.janela.ViewJanela;
import view.view_terminal.ViewTerminal;

public class TesteViewJanela {
	
	public static void main(String[] args) {
		new Controller(new DaoCSV("files"), new ViewJanela()).init();

	}

}
