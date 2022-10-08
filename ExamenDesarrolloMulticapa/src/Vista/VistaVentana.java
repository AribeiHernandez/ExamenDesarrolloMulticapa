/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;



import java.awt.Frame;



import java.awt.Color;
import java.awt.Cursor;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;



/**
 *
 * @author ilsea
 */
public class VistaVentana extends JFrame
{
     //variables globales 
  
             //botones
           public JButton BtnSTART= new JButton("Start");
           public JButton BtnBUSCAR= new JButton("Buscar imagen");
          
           
           //Labels
           public  JLabel Lbl1 = new JLabel("EXAMEN DESARROLLO MULTICAPA");
           public  JLabel IMG1 = new JLabel("IMG1");
           public  JLabel IMG2 = new JLabel("IMG2");
           public  JLabel IMG3 = new JLabel("IMG3");
           public  JLabel IMG4 = new JLabel("IMG4");
           public  JLabel NombreIMG = new JLabel("---------------------------");
           
           //Combo box 
           public JComboBox ComboBox= new JComboBox();
     

    public VistaVentana()
    {
        config();
        objetos();
    }
           
           
   

    private void config() {//Procedure 
        //es private, solo va a funcionar dentro de la misma clase 
       
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Ponemos en alerta al destructor para que 
        //revise cuando yo le de click a la x y valla a destruir la ventana 
        this.setSize(600,400);
        //this.setLocation(300,200);//indica donde aparece en la pantalla
        this.setLocationRelativeTo(null);//coloca al jframe al centro
        this.setTitle("INTERFACE CONTADORA");
       // getContentPane().setBackground(Color.BLACK);//primero obtenemos el contenedor
       this.getContentPane().setBackground(new Color(130,180,245));
       this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//para asignarle un tipo de cursor
       this.setResizable(false);//para que no cambie el tamaño de la ventana 
       this.setEnabled(true);//es un vurus, si es false, si es true si nunca se puede cerrar la ventana jeje
       
        //       Para el Layout 

        this.setLayout(null);//Es el grid libre 
       
    }

 

    private void objetos() {
       
        //BOTONES 
        BtnSTART.setBounds(230, 190, 100, 40);
        this.add(BtnSTART);
        BtnBUSCAR.setBounds(220, 50, 130, 40);
        this.add(BtnBUSCAR);
        //Combo box 
        ComboBox.addItem("Secuencial");
        ComboBox.addItem("Concurrente");
        ComboBox.setBounds(210, 140, 150, 40);
        this.add(ComboBox);
         //Labels 
        Lbl1.setBounds(190, 10, 300, 40);
        this.add(Lbl1);
        NombreIMG.setBounds(230, 80, 300, 40);
        NombreIMG.setForeground(Color.white);
        this.add(NombreIMG);
        //lbl img
        IMG1.setBounds(10, 240, 100, 100);
        IMG1.setBackground(Color.WHITE);
        IMG1.setOpaque(true);
        this.add(IMG1);
        
        IMG2.setBounds(170, 240, 100, 100);
        IMG2.setBackground(Color.WHITE);
        IMG2.setOpaque(true);
        this.add(IMG2);
        
        IMG3.setBounds(340, 240, 100, 100);
        IMG3.setBackground(Color.WHITE);
        IMG3.setOpaque(true);
        this.add(IMG3);
        
        IMG4.setBounds(500, 240, 100, 100);
        IMG4.setBackground(Color.WHITE);
        IMG4.setOpaque(true);
        this.add(IMG4);
        
       
    }
    
  
    
}
