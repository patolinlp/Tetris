/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Milo
 */

public class PanelDeInicio extends JPanel implements ActionListener
{

    VentanaTetris ventana;
    JButton jugar;
    JButton puntuaciones;
    JButton salir;
    JLabel fondo;

    public PanelDeInicio(VentanaTetris ventana)
    {
        this.setLayout(null);
        this.setSize(430, 550);
        this.ventana = ventana;

        this.fondo = new JLabel(new ImageIcon("imagenes/Panel de Inicio.png"));
        fondo.setSize(430, 550);

        this.jugar = new JButton("Jugar");
        this.puntuaciones = new JButton("Puntuaciones");
        this.salir = new JButton("Salir");

        this.jugar.setIcon(new ImageIcon("imagenes/S1.png"));
        this.jugar.setPressedIcon(new ImageIcon("imagenes/S2.png"));
        this.jugar.setHorizontalAlignment(JButton.LEFT);
        this.add(this.jugar);
        this.jugar.setSize(300, 300);
        this.jugar.setLocation(0, 300);
        this.jugar.addActionListener(this);

        this.puntuaciones.setIcon(new ImageIcon("imagenes/T1.png"));
        this.puntuaciones.setPressedIcon(new ImageIcon("imagenes/T2.png"));
        this.puntuaciones.setHorizontalAlignment(JButton.LEFT);
        this.add(this.puntuaciones);
        this.puntuaciones.setSize(170, 44);
        this.puntuaciones.setLocation(0, 354);
        this.puntuaciones.addActionListener(this);

        this.salir.setIcon(new ImageIcon("imagenes/L1.png"));
        this.salir.setPressedIcon(new ImageIcon("imagenes/L2.png"));
        this.salir.setHorizontalAlignment(JButton.LEFT);
        this.add(this.salir);
        this.salir.setSize(170, 44);
        this.salir.setLocation(0, 408);
        this.salir.addActionListener(this);


        this.add(this.fondo);

        super.setVisible(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.jugar)
        {
            this.ventana.crearVentana();
        }

        else if(e.getSource() == this.puntuaciones)
        {
           JOptionPane.showMessageDialog(this, "Esta opcion sera implementada en la proxima version", "Conflicto", JOptionPane.ERROR_MESSAGE);
        }

        else if(e.getSource() == this.salir)
        {
            System.exit(0);
        }
    }


}
