package CobosRabanoCarlos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Una clase que nos permite gestionar los botones personalizados
 * @author ccobosr02
 *
 */
public class BotonSampler extends JButton implements MouseListener, Serializable {
	private ReproduccionSonido sonido;//Nos permitir� reproducir un sonido al hacer click
	private File fichero;//Es el fichero que queremos reproducir cuando hagamos click en ese bot�n
	private String descripcion;//Es el texto que mostrar� el bot�n, que debe identificar el sonido

	public BotonSampler() {
		super();
		addMouseListener(this);
	}
	
	/**
	 * Abre un JFileChooser para elegir el fichero mp3 que queremos reproducir con ese bot�n
	 */
	private void ejegirFichero() {
		int select;
		JFileChooser chooser=new JFileChooser("./sonidos");
		chooser.setFileFilter(new FiltroExt(".mp3"));
		select=chooser.showOpenDialog(this);
		if(select==JFileChooser.APPROVE_OPTION) {
			fichero=chooser.getSelectedFile();
			descripcion=JOptionPane.showInputDialog(this,"Escribe una descripci�n del sonido");
			setText(descripcion);
			sonido=new ReproduccionSonido(fichero, this);
		}
	}
	
	/**
	 * Comienza a reproducir el fichero mediante la clase ReproduccionSonido y cambia el fondo del bot�n
	 */
	private void sonar() {
		sonido.start();
		setBackground(new Color(85, 238, 172));
	}
	
	/**
	 * Para la reproducci�n del sonido y cambia el fondo del bot�n
	 */
	public void parar() {
		sonido.parar();
		setBackground(new Color(59, 89, 182));
		sonido=new ReproduccionSonido(fichero, this);
	}

	/**
	 * Devuelve el objeto File
	 * @return el objeto de la clase File asociado al fichero
	 */
	public File getFichero() {
		return fichero;
	}

	/**
	 * Establece un nuevo objeto File
	 * @param fichero
	 */
	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	/**
	 * Devuelve un String con la descripci�n del bot�n
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripci�n del bot�n
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		setText(descripcion);
	}	
	
	/**
	 * Devuelve el objeto de la clase ReproduccionSonido
	 * @return
	 */
	public ReproduccionSonido getSonido() {
		return sonido;
	}

	/**
	 * Establece un nuevo ReproduccionSonido
	 * @param sonido
	 */
	public void setSonido(ReproduccionSonido sonido) {
		this.sonido = sonido;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Si hacemos click derecho, podremos elegir un nuevo fichero {@see elegirFichero()} y detiene si est� sonando
	 * Si hacemos click izquierdo, pone en marcha o pausa en funci�n de si ya est� reproduciendo el objeto ReproduccionSonido
	 */
	@Override
	public void mousePressed(MouseEvent e) {		
		if (SwingUtilities.isRightMouseButton(e)) {
			ejegirFichero();
			parar();
		}else {
			if (sonido.isPausado()){
				sonar();
			}else {
				parar();
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
}
