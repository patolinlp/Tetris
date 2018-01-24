/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milo
 */
public class ConfigurarTeclas extends JDialog implements KeyListener, ActionListener
{
    boolean cambiar;
    ArrayList<Integer> teclas;

    int rotar;
    int abajo;
    int abajoFondo;
    int izquierda;
    int derecha;
    int pause;
    int hold;

    JLabel lblRotar;
    JLabel lblAbajo;
    JLabel lblAbajoFondo;
    JLabel lblIzquierda;
    JLabel lblDerecha;
    JLabel lblPause;
    JLabel lblHold;

    JTextField txtRotar;
    JTextField txtAbajo;
    JTextField txtAbajoFondo;
    JTextField txtIzquierda;
    JTextField txtDerecha;
    JTextField txtPause;
    JTextField txtHold;

    JPanel panel;
    JButton guardar;
    JButton cancelar;

    public ConfigurarTeclas(int rotar, int abajo, int abajoFondo, int izquierda, int derecha, int pause, int hold, JFrame parent)
    {
        super(parent, true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(200, 200);
        this.setLayout(new GridLayout(8,2));

        this.cambiar = false;

        this.teclas = new ArrayList<Integer>();

        this.rotar = rotar;
        this.abajo = abajo;
        this.abajoFondo = abajoFondo;
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.pause = pause;
        this.hold = hold;

        this.lblRotar = new JLabel("Rotar");
        this.lblAbajo = new JLabel("Bajar Suave");
        this.lblAbajoFondo = new JLabel("Bajar Fondo");
        this.lblIzquierda = new JLabel("Mover Izquierda");
        this.lblDerecha = new JLabel("Mover Derecha");
        this.lblPause = new JLabel("Pausa");
        this.lblHold = new JLabel("Hold");

        this.teclas.add(rotar);
        this.teclas.add(abajo);
        this.teclas.add(abajoFondo);
        this.teclas.add(izquierda);
        this.teclas.add(derecha);
        this.teclas.add(pause);
        this.teclas.add(hold);

        this.txtRotar = new JTextField(KeyEvent.getKeyText(rotar));
        this.txtAbajo = new JTextField(KeyEvent.getKeyText(abajo));
        this.txtAbajoFondo = new JTextField(KeyEvent.getKeyText(abajoFondo));
        this.txtIzquierda = new JTextField(KeyEvent.getKeyText(izquierda));
        this.txtDerecha = new JTextField(KeyEvent.getKeyText(derecha));
        this.txtPause = new JTextField(KeyEvent.getKeyText(pause));
        this.txtHold = new JTextField(KeyEvent.getKeyText(hold));

        this.guardar = new JButton("Guardar");
        this.cancelar = new JButton("Cancelar");

        this.add(this.lblRotar);
        this.add(this.txtRotar);
        this.add(this.lblAbajo);
        this.add(this.txtAbajo);
        this.add(this.lblAbajoFondo);
        this.add(this.txtAbajoFondo);
        this.add(this.lblIzquierda);
        this.add(this.txtIzquierda);
        this.add(this.lblDerecha);
        this.add(this.txtDerecha);
        this.add(this.lblPause);
        this.add(this.txtPause);
        this.add(this.lblHold);
        this.add(this.txtHold);
        this.add(this.guardar);
        this.add(this.cancelar);

        this.txtRotar.setEditable(false);
        this.txtAbajo.setEditable(false);
        this.txtAbajoFondo.setEditable(false);
        this.txtIzquierda.setEditable(false);
        this.txtDerecha.setEditable(false);
        this.txtPause.setEditable(false);
        this.txtHold.setEditable(false);

        this.txtRotar.addKeyListener(this);
        this.txtAbajo.addKeyListener(this);
        this.txtAbajoFondo.addKeyListener(this);
        this.txtIzquierda.addKeyListener(this);
        this.txtDerecha.addKeyListener(this);
        this.txtPause.addKeyListener(this);
        this.txtHold.addKeyListener(this);
        this.cancelar.addActionListener(this);
        this.guardar.addActionListener(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - super.getSize().width/2,
                    screenSize.height/2 - super.getSize().height/2);
    }

    public ArrayList<Integer> config()
    {
        return this.teclas;
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getSource() == this.txtRotar)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtRotar.setText(e.getKeyText(e.getKeyCode()));
                this.rotar = e.getKeyCode();
                this.teclas.set(0,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == this.txtAbajo)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtAbajo.setText(e.getKeyText(e.getKeyCode()));
                this.abajo = e.getKeyCode();
                this.teclas.set(1,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == this.txtAbajoFondo)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtAbajoFondo.setText(e.getKeyText(e.getKeyCode()));
                this.abajoFondo = e.getKeyCode();
                this.teclas.set(2,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == this.txtIzquierda)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtIzquierda.setText(e.getKeyText(e.getKeyCode()));
                this.izquierda = e.getKeyCode();
                this.teclas.set(3,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(e.getSource() == this.txtDerecha)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtDerecha.setText(e.getKeyText(e.getKeyCode()));
                this.derecha = e.getKeyCode();
                this.teclas.set(4,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(e.getSource() == this.txtPause)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtPause.setText(e.getKeyText(e.getKeyCode()));
                this.pause = e.getKeyCode();
                this.teclas.set(5,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(e.getSource() == this.txtHold)
        {
            if(!this.teclas.contains(e.getKeyCode()))
            {
                this.txtHold.setText(e.getKeyText(e.getKeyCode()));
                this.hold = e.getKeyCode();
                this.teclas.set(6,e.getKeyCode());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tecla ya en uso", "Conflicto", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.guardar)
        {
            this.cambiar = true;
            this.dispose();
        }
        else if (e.getSource() == this.cancelar)
        {
            this.dispose();
        }
    }

    public int getAbajo()
    {
        return abajo;
    }

    public int getRotar()
    {
        return rotar;
    }

    public int getDerecha()
    {
        return derecha;
    }

    public int getIzquierda()
    {
        return izquierda;
    }

    public boolean isCambiar()
    {
        return cambiar;
    }

    public int getAbajoFondo()
    {
        return abajoFondo;
    }

    public int getHold()
    {
        return hold;
    }

    public int getPause()
    {
        return pause;
    }

}