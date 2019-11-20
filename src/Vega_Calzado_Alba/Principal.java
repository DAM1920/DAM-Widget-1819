package Vega_Calzado_Alba;

import java.awt.EventQueue;

/**
 * Clase principal.
 * 
 * @author Alba Vega Calzado
 *
 */
public class Principal {
	/**
	 * M�todo main
	 * @param args cadenas de par�metros del main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.inicializar();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
