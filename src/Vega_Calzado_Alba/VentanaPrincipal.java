package Vega_Calzado_Alba;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * @author Alba Vega Calzado
 *
 */

public class VentanaPrincipal {
	JFrame ventana;
	JButton presentacion, siguiente, anterior;
	JGaleria galeria;
	
	/**
	 * Constructor de la ventana
	 */
	public VentanaPrincipal() {
		ventana=new JFrame();
		ventana.setBounds(100, 100, 800, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JGaleria getJGaleria() {
		return galeria;
	}
	
	/**
	 * M�todo para inicializar la ventana y sus componentes.
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
	}
	
	/**
	 * M�todo para inicializar los componentes
	 */
	public void inicializarComponentes() {
		ventana.setLayout(new GridBagLayout());
		
		//Inicializaci�n de la galer�a
		galeria = new JGaleria();
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx=0;
		settings.gridy=0;
		settings.gridwidth=4;
		settings.weightx=1;
		settings.weighty=1;
		settings.fill=GridBagConstraints.BOTH;
		
		ventana.add(galeria, settings);
		
		//Inicializaci�n del bot�n Anterior
		anterior = new JButton("Anterior");
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
		
		ventana.add(anterior,settings);
		
		//Inicializaci�n del bot�n Presentaci�n
		presentacion = new JButton("Presentaci�n");
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
		
		ventana.add(presentacion, settings);
		
		//Inicializaci�n del bot�n Siguiente
		siguiente = new JButton("Siguiente");
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.BOTH;
				
		ventana.add(siguiente,settings);
		
		//Inicializaci�n de la presentaci�n de la galer�a
		getJGaleria().iniciarGaleria();
	}
	
	public void inicializarListeners() {
		siguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				galeria.avanzar();
			}
		});
		
		anterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				galeria.retroceder();
			}
		});
		
		presentacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				galeria.presentacion();
			}
		});
	}
}
