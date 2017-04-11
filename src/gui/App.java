package gui;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		// w swingu dzialanie powinno byc zawarte w watku obslugi zdarzen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
				
			}
		});	
	}

}
