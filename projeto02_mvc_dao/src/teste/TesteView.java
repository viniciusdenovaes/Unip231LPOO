package teste;

import controller.Controller;
import dao.csv.DaoCSV;
import view.view_terminal.ViewTerminal;


public class TesteView {
	
	public static void main(String[] args) {
		new Controller(new DaoCSV("files"), new ViewTerminal()).init();
	}

}
