/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author Patolinlp
 */
public class Inicio extends JWindow{

    public Inicio()
    {
        super(new Frame());
        int waitTime = 1000;
        JLabel l = new JLabel(new ImageIcon("imagenes/ventanaDeCargapng.png"));
        JLabel l2 = new JLabel("Cargando ... ");

        getContentPane().add(l, BorderLayout.CENTER);
        getContentPane().add(l2, BorderLayout.SOUTH);

        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));


        // tiempo que estara visible la ventana, en milisegundos
        final int pause = waitTime;

        // Este es el objeto que cierra la ventana
        final Runnable closerRunner = new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                    dispose();
                    VentanaTetris ventanaTetris;

                    ventanaTetris = new VentanaTetris();
                    ventanaTetris.ventanaInicio();
                }
            };

        // Este es el objeto que pone a dormir a closerRunner
        // y captura las excepciones;
        Runnable waitRunner = new Runnable()
            {
                public void run()
                {
                    try
                        {
                            Thread.sleep(pause);
                            SwingUtilities.invokeAndWait(closerRunner);
                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                }
            };
        setVisible(true);
        // aqui creamos y lanzamos el hilo
        Thread inicioThread = new Thread(waitRunner, "inicioThread");
        inicioThread.start();
    }
}
