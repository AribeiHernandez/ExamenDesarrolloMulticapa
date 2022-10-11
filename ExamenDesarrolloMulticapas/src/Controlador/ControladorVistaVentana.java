/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaVentana;
import Modelo.Imagen;
import Controlador.ControladorImagen;
//import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author ilsea
 */
public class ControladorVistaVentana implements MouseListener{
    private VistaVentana VistaVentana;//no es el original
    private Imagen Imagen;
	private ControladorImagen ControladorImagen; 

    public ControladorVistaVentana(VistaVentana VistaVentana) {
        this.VistaVentana = VistaVentana;
        this.VistaVentana.setVisible(true);//es necesario ponerla para hacer visible el formulario
        //si no se le pone la instrucción no se ve la venta
        oyentes();
    }

    private void oyentes() {
       
        
        VistaVentana.BtnSTART.addMouseListener((MouseListener) this);
        VistaVentana.BtnBUSCAR.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
           if(e.getSource()== VistaVentana.BtnBUSCAR)
           {
               try {
                   abrirExploradorDeArchivos();
               } catch (IOException ex) {
                   System.out.println(e);               }
           }
           else if(e.getSource()== VistaVentana.BtnSTART) {
        	   String Modo = VistaVentana.ComboBox.getSelectedItem().toString();
        	   try {
				this.ControladorImagen = new ControladorImagen(this.VistaVentana, this.Imagen, this.Imagen.getAncho(), this.Imagen.getAlto(), Modo);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    //----------------------METODOS-----------------------//
    
      public void abrirExploradorDeArchivos() throws IOException
    {
    //Process p = new ProcessBuilder("Explorer.exe", "/select,C:\\directory\\selectedFile").start();
      //  System.out.println("Entró al explorador");
        
        JFileChooser jf= new JFileChooser();
        jf.showOpenDialog(VistaVentana);
        

    	File archivo= jf.getSelectedFile();
    	this.Imagen = new Imagen(archivo);	
    	if(this.Imagen.esImagen == true)
        {
        	VistaVentana.NombreIMG.setText(archivo.getName());
        	VistaVentana.BtnSTART.setEnabled(true);
        }
        if(this.Imagen.esImagen == false){
        	VistaVentana.BtnSTART.setEnabled(false);
        	VistaVentana.NombreIMG.setText("---------------------------");
        }
        
        
    }
 
    
}
