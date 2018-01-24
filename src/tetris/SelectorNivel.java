/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Milo
 */

public class SelectorNivel extends JDialog implements ActionListener
{
    JTextField nivel;
    JButton guardar;
    JButton cancelar;
    boolean guardarCambios;

   public SelectorNivel(JFrame jFrame)
   {
      super(jFrame, true);
      super.setSize(200, 300);
      this.setLayout(null);

      this.guardarCambios = false;

      this.nivel = new JTextField();
      this.guardar = new JButton("Guardar");
      this.cancelar = new JButton("Cancelar");

      this.add(nivel);
      this.nivel.setSize(100, 30);
      this.nivel.setLocation(25, 100);
      

      this.add(guardar);
      this.guardar.setSize(66, 30);
      this.guardar.setLocation(22, 150);
      

      this.add(cancelar);
      this.cancelar.setSize(66, 30);
      this.cancelar.setLocation(100, 150);
      

      this.setResizable(false);
      this.guardar.addActionListener(this);
      this.cancelar.addActionListener(this);

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation(screenSize.width / 2 - super.getSize().width / 2,
              screenSize.height / 2 - super.getSize().height / 2);

      super.setVisible(true);      
   }

   public void actionPerformed(ActionEvent e)
   {
       if(e.getSource() == this.guardar)
       {
            JOptionPane.showMessageDialog(this, "Esta opcion sera implementada en la proxima version", "Conflicto", JOptionPane.ERROR_MESSAGE);
       }
       else if(e.getSource() == this.cancelar)
       {
           this.dispose();
       }
   }
}
