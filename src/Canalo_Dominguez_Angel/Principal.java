package Canalo_Dominguez_Angel;

import java.awt.EventQueue;

public class Principal {
	/**
	 * 
	 * @author �ngel Canalo Dom�nguez
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.inicializar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}