/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javazoom.jl.player.Player;

/**
 *
 * @author jorge
 */
public class VentanaTetris extends JFrame implements KeyListener, ActionListener, WindowListener
{

    private Ayuda help;
   private ConfigurarTeclas config;
   private AcercaDe acerca;
   private JPanel panel;
   private JMenuBar barraMenu;
   private JMenu menuJuego;
   private JMenu menuOpciones;
   private JMenu menuAyuda;
   private JMenuItem juegoNuevo;
   private JMenuItem pausa;
   private JMenuItem configurarTeclas;
   private JMenuItem ayuda;
   private JMenuItem acercaDe;
   private JMenuItem nivel;
   private SelectorNivel selectorNivel;
   private FondoTetris fondo;
   private PanelSiguiente siguiente;
   private PanelTetris panelTetris;
   private File musica;
   private Image imagen;
   private DataBase dataBase;
   private PanelDeInicio panelInicio;
   private Timer timer;
   private int level;
   private int ultimoLevel;

   public VentanaTetris()
   {
      super("Tetris");
      super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      this.imagen = new ImageIcon("imagenes/Icono.png").getImage();
      this.setIconImage(imagen);


      this.barraMenu = new JMenuBar();
      
      this.menuJuego = new JMenu("Juego");

      this.menuOpciones = new JMenu("Opciones");
      this.menuAyuda = new JMenu("Ayuda");
      this.menuAyuda.setMnemonic('A');
      this.configurarTeclas = new JMenuItem("Configurar Teclas");
      this.acercaDe = new JMenuItem("Acerca de");

      this.juegoNuevo = new JMenuItem("Juego nuevo");
      this.pausa = new JMenuItem("Pausa");
      this.nivel = new JMenuItem("Nivel");
      this.ayuda = new JMenuItem("Ayuda");

      this.juegoNuevo.addActionListener(this);
      this.pausa.addActionListener(this);
      this.configurarTeclas.addActionListener(this);
      this.acercaDe.addActionListener(this);
      this.nivel.addActionListener(this);
      this.ayuda.addActionListener(this);

      this.menuJuego.add(juegoNuevo);
      this.menuJuego.add(pausa);

      this.menuOpciones.add(this.configurarTeclas);
      this.menuOpciones.add(this.nivel);

      this.menuAyuda.add(this.acercaDe);
      this.menuAyuda.add(this.ayuda);

      //paneles a utilizar durante el juego
      this.fondo = new FondoTetris();
      this.panelInicio = new PanelDeInicio(this);
      //this.siguiente = new PanelSiguiente();
      this.panelTetris = new PanelTetris();

      this.addWindowListener(this);
      this.addKeyListener(this);

      //this.timer = new Timer(500, panelTetris);
      this.musica = new File("musica/tetrisSound.mp3");
      this.dataBase = new DataBase();
      this.dataBase = this.dataBase.open(this.dataBase);

      this.level = 600;
      this.ultimoLevel = 0;
      this.timer = new Timer(this.level, this);
      this.timer.start();

      super.setLayout(null);
      super.setSize(430, 550);

      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation(screenSize.width / 2 - super.getSize().width / 2,
              screenSize.height / 2 - super.getSize().height / 2);

      super.setResizable(false);
      super.setVisible(true);
      //crearVentana();
   }

   public void crearVentana()
   {
      this.menuJuego.setMnemonic('J');
      this.barraMenu.add(this.menuJuego);
      this.barraMenu.add(this.menuOpciones);
      this.barraMenu.add(this.menuAyuda);
      super.setJMenuBar(barraMenu);

      super.remove(this.panelInicio);
      super.add(this.panelTetris = new PanelTetris());
      super.add(fondo);

      this.start();

      this.requestFocus();
   }

   public void ventanaInicio()
   {
      this.setLayout(new BorderLayout());
      super.add(this.panelInicio, BorderLayout.CENTER);
      super.add(this.panelInicio);
   }

   public void pausar()
   {
      this.panelTetris.setPause();

      if(this.panelTetris.isPause())
      {
         this.timer.stop();
      }
      else
      {
         this.timer.start();
      }
   }

   public void avanzarJuego()
   {
      if(!this.panelTetris.getJuegoTerminado())
      {
         this.panelTetris.bajarPieza();
      }
   }

   public void level()
   {
      if(this.panelTetris.getJuegoTerminado())
      {
         this.level = 600;
         this.ultimoLevel = 0;

         this.timer.stop();
         this.timer = new Timer(this.level, this);
         this.timer.start();
      }
      
      else
      {
         if(this.panelTetris.getLineasTotales() >= this.ultimoLevel + 10 && this.level > 25)
         {
            this.timer.stop();

            this.ultimoLevel += 10;
            this.level -= 25;

            this.timer = new Timer(this.level, this);
            this.timer.start();
         }
      }
   }

   public void start()
   {
      playSound();
   }

   public void playSound()
   {
      try
      {
         final Player player = new Player(new FileInputStream(musica));
         new Thread()
         {

            @Override
            public void run()
            {
               try
               {
                  player.play();
               }
               catch(Exception e)
               {
               }
            }
         }.start();

      }
      catch(Exception ex)
      {
      }

   }

   @Override
   public void paint(Graphics grafico)
   {
      super.paintComponents(grafico);
      super.repaint();
   }

   public void keyTyped(KeyEvent e)
   {
   }

   public void keyPressed(KeyEvent e)
   {
      if(e.getKeyCode() == this.panelTetris.getPausar())
      {
         if(!this.panelTetris.getJuegoTerminado())
         {
            pausar();
         }
      }

      this.panelTetris.press(e.getKeyCode());
   }

   public void keyReleased(KeyEvent e)
   {
   }

   public void actionPerformed(ActionEvent e)
   {
      this.panelTetris.setJuegoTerminado();
      avanzarJuego();
      level();

      if(e.getSource() == this.juegoNuevo)
      {
         this.panelTetris.juegoNuevo();
      }
      else if(e.getSource() == this.pausa && !this.panelTetris.getJuegoTerminado())
      {
         pausar();
      }
      else if(e.getSource() == this.nivel && !this.panelTetris.getJuegoTerminado())
      {
         pausar();
         this.selectorNivel = new SelectorNivel(this);
         pausar();

      }
      else if(e.getSource() == this.configurarTeclas)
      {
         pausar();
         this.config = new ConfigurarTeclas(this.panelTetris.getRotar(),
                 this.panelTetris.getAbajo(),
                 this.panelTetris.getAbajoFondo(),
                 this.panelTetris.getIzquierda(),
                 this.panelTetris.getDerecha(),
                 this.panelTetris.getPausar(),
                 this.panelTetris.getHold(),
                 this);
         this.config.setVisible(true);
         if(this.config.isCambiar())
         {
            this.panelTetris.setRotar(this.config.getRotar());
            this.panelTetris.setAbajo(this.config.getAbajo());
            this.panelTetris.setAbajoFondo(this.config.getAbajoFondo());
            this.panelTetris.setIzquierda(this.config.getIzquierda());
            this.panelTetris.setDerecha(this.config.getDerecha());
            this.panelTetris.setPausar(this.config.getPause());
            this.panelTetris.setHold(this.config.hold);

            guardarTeclas();
         }

         pausar();
      }
      else if(e.getSource() == this.acercaDe)
      {
         pausar();
         this.acerca = new AcercaDe(this);
         this.acerca.setVisible(true);
         pausar();
      }
      else if(e.getSource() == this.ayuda)
      {
          pausar();
          this.help = new Ayuda(this.panelTetris.getRotar(),
                 this.panelTetris.getAbajo(),
                 this.panelTetris.getAbajoFondo(),
                 this.panelTetris.getIzquierda(),
                 this.panelTetris.getDerecha(),
                 this.panelTetris.getPausar(),
                 this.panelTetris.getHold(),
                 this);
          this.help.setVisible(true);
          pausar();
      }
   }

   public void guardarTeclas()
   {
      try
      {
         PrintWriter write = new PrintWriter("configuracion/teclas.txt");

         write.println(Integer.toString(this.config.getRotar()));
         write.println(Integer.toString(this.config.getAbajo()));
         write.println(Integer.toString(this.config.getAbajoFondo()));
         write.println(Integer.toString(this.config.getIzquierda()));
         write.println(Integer.toString(this.config.getDerecha()));
         write.println(Integer.toString(this.config.getPause()));
         write.println(Integer.toString(this.config.getHold()));

         write.close();
      }
      catch(IOException ex)
      {
      }
   }

   public void windowOpened(WindowEvent e)
   {
   }

   public void windowClosing(WindowEvent e)
   {
      this.dataBase.save();
   }

   public void close()
   {
      this.dataBase.save();
      this.dispose();
   }

   public void windowClosed(WindowEvent e)
   {
   }

   public void windowIconified(WindowEvent e)
   {
   }

   public void windowDeiconified(WindowEvent e)
   {
   }

   public void windowActivated(WindowEvent e)
   {
   }

   public void windowDeactivated(WindowEvent e)
   {
   }
}
