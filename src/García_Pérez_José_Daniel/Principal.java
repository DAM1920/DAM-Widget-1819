package Garc�a_P�rez_Jos�_Daniel;

import java.awt.EventQueue;

public class Principal {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				VentanaPrincipal vp = new VentanaPrincipal();

				vp.inicializar();

			}
		});

	}

}
