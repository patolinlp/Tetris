package tetris;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milo
 */
public class Ayuda extends JDialog
{
    JLabel fondo;

    JLabel rotar;
    JLabel izquierda;
    JLabel derecha;
    JLabel abajo;
    JLabel abajoFondo;
    JLabel pausar;
    JLabel hold;


    public Ayuda(int rotar, int abajo, int abajoFondo, int izquierda, int derecha, int pause, int hold, JFrame parent)
    {
        super(parent, true);
        this.setSize(800, 600);

        this.fondo = new JLabel(new ImageIcon("imagenes/Ayuda.png"));
        this.fondo.setSize(800, 600);

        this.rotar = new JLabel(KeyEvent.getKeyText(rotar));
        this.rotar.setSize(100, 20);
        this.rotar.setLocation(550, 60);

        this.izquierda = new JLabel(KeyEvent.getKeyText(izquierda));
        this.izquierda.setSize(100, 20);
        this.izquierda.setLocation(550, 130);

        this.derecha = new JLabel(KeyEvent.getKeyText(derecha));
        this.derecha.setSize(100, 20);
        this.derecha.setLocation(550, 200);

        this.abajo = new JLabel(KeyEvent.getKeyText(abajo));
        this.abajo.setSize(100, 20);
        this.abajo.setLocation(550, 270);

        this.abajoFondo = new JLabel(KeyEvent.getKeyText(abajoFondo));
        this.abajoFondo.setSize(100, 20);
        this.abajoFondo.setLocation(550, 340);

        this.pausar = new JLabel(KeyEvent.getKeyText(pause));
        this.pausar.setSize(100, 20);
        this.pausar.setLocation(550, 410);

        this.hold = new JLabel(KeyEvent.getKeyText(hold));
        this.hold.setSize(100, 20);
        this.hold.setLocation(550, 480);

        this.add(this.rotar);
        this.add(this.izquierda);
        this.add(this.derecha);
        this.add(this.abajo);
        this.add(this.abajoFondo);
        this.add(this.pausar);
        this.add(this.hold);

        this.add(this.fondo);

        this.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - super.getSize().width / 2,
              screenSize.height / 2 - super.getSize().height / 2);

    }
}