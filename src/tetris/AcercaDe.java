/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Patolinlp
 */

public class AcercaDe extends JDialog {

    private Image imagen;
    private JLabel fondo;
    private final JLabel label;

    public AcercaDe(JFrame parent)
    {
        super(parent,true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 350);
        this.label = new JLabel(new ImageIcon("imagenes/AcercaDe.png"));
        label.setSize(500,350);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = label.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
        this.add(this.label);
    }


}