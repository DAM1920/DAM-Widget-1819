package CobosRabanoCarlos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Una clase que nos permite reproducir un sonido en un nuevo hilo
 * @author ccobosr02
 *
 */
public class ReproduccionSonido extends Thread implements Serializable{
	File fich;//El fichero que va a reproducir
	boolean pausa;//Si est� pausado o reproduciendo
	Player apl;//Objeto de la clase Player de la librer�a javazoom
	BotonSampler boton;//Bot�n al que hemos asociado un objeto de esta clase

	public ReproduccionSonido(File fich, BotonSampler boton) {
		this.fich = fich;
		pausa = true;
		this.boton=boton;
		try {
			apl=new Player(new FileInputStream(fich));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reproduce el sonido cuya ruta le hemos pasado por par�metros
	 */
	public void run() {
		pausa=false;
		try {
			while (true) {
				if (!pausa) {
					if (!apl.play(1)) {
						break;
					}
					
				}
			}
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
		parar();
		boton.parar();
	}
	
	/**
	 * Nos devuelve un boolean que indica si el sonido est� pausado
	 * @return
	 */
	public boolean isPausado() {
		return pausa;
	}	

	/**
	 * Detiene la reproducci�n del sonido
	 */
	public void parar() {		
		pausa=true;
	}
}
