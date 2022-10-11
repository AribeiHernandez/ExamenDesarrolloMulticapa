package Controlador;
import Modelo.Imagen;
import Vista.VistaVentana;
import Modelo.AlgoritmosHilos;

//Clase donde se van a llamar los hilos para modificar la imagen
public class ControladorImagen {
	
	public ControladorImagen(VistaVentana VistaVentana, Imagen Imagen, int ancho, int alto, String Modo) throws InterruptedException{
		if (Modo =="Secuencial") {
			System.out.println(Modo);
			AlgoritmosHilos AlgoritmosSec = new AlgoritmosHilos(Imagen, ancho, alto);
			long startTime = System.currentTimeMillis();
			AlgoritmosSec.alg1();
			VistaVentana.IMG1.setIcon(AlgoritmosSec.getIcon());
			AlgoritmosSec.alg2();
			VistaVentana.IMG2.setIcon(AlgoritmosSec.getIcon());
			AlgoritmosSec.alg3();
			VistaVentana.IMG3.setIcon(AlgoritmosSec.getIcon());
			AlgoritmosSec.alg4();
			VistaVentana.IMG4.setIcon(AlgoritmosSec.getIcon());
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println("El tiempo en milisegundos fue de: " + endTime);
		}else {
			System.out.println(Modo);
			AlgoritmosHilos Algoritmo1 = new AlgoritmosHilos(1, Imagen, ancho, alto);
			AlgoritmosHilos Algoritmo2 = new AlgoritmosHilos(2, Imagen, ancho, alto);
			AlgoritmosHilos Algoritmo3 = new AlgoritmosHilos(3, Imagen, ancho, alto);
			AlgoritmosHilos Algoritmo4 = new AlgoritmosHilos(4, Imagen, ancho, alto);
			long startTime = System.currentTimeMillis();
			Algoritmo1.start();
			Algoritmo2.start();
			Algoritmo3.start();
			Algoritmo4.start();
			
			while(Algoritmo1.isAlive() || Algoritmo2.isAlive() || Algoritmo3.isAlive() || Algoritmo4.isAlive());
			
			long endTime = System.currentTimeMillis() - startTime;			
			
			VistaVentana.IMG1.setIcon(Algoritmo1.getIcon());
			VistaVentana.IMG2.setIcon(Algoritmo2.getIcon());
			VistaVentana.IMG3.setIcon(Algoritmo3.getIcon());
			VistaVentana.IMG4.setIcon(Algoritmo4.getIcon());

			System.out.println("El tiempo en milisegundos fue de: " + endTime);
                        VistaVentana.LblValorTIEMPO.setText(String.valueOf( endTime));
			
			
		}
	}
}
