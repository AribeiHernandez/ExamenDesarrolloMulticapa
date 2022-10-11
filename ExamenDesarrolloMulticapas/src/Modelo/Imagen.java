package Modelo;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Imagen {
	private int ancho;
	private int alto;
	public boolean esImagen = false;
	BufferedImage bimg;
	public Imagen(File Imagen){
		
		try {
			this.bimg = ImageIO.read(Imagen);
			setAncho(bimg.getWidth());
			setAlto(bimg.getHeight());
			this.esImagen =true;
		}catch(Exception e){
			this.esImagen =false;
		}
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
}
