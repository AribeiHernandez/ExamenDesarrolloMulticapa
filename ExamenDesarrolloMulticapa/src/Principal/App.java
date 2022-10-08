/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Controlador.ControladorVistaVentana;
import Vista.VistaVentana;
/**
 *
 * @author ilsea
 */
public class App {
    
      public static void main(String[] args) {
        VistaVentana VistaV= new VistaVentana();//Objeto original 
        ControladorVistaVentana CVV= new  ControladorVistaVentana(VistaV);//Objeto Original
    }
    
}
