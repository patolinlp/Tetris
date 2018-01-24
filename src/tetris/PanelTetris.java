/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jorge
 */
public class PanelTetris extends JPanel
{

   private int rotar;
   private int abajo;
   private int abajoFondo;
   private int izquierda;
   private int derecha;
   private int pausar;
   private int hold;
   private Tablero tablero;
   private Image pixelAmarillo;
   private Image pixelRojo;
   private Image pixelAzul;
   private Image pixelVerde;
   private Image pixelNaranja;
   private Image pixelCeleste;
   private Image pixelMorado;
   private Image juegoTerminado;
   private Image pausa;
   private boolean juegoTermado;
   private boolean pause;

   public PanelTetris()
   {
      super.setSize(430, 550);
      super.setVisible(true);

      this.tablero = new Tablero();
      this.pixelAmarillo = new ImageIcon("imagenes/amarillo.png").getImage();
      this.pixelRojo = new ImageIcon("imagenes/rojo.png").getImage();
      this.pixelAzul = new ImageIcon("imagenes/azul.png").getImage();
      this.pixelVerde = new ImageIcon("imagenes/verde.png").getImage();
      this.pixelNaranja = new ImageIcon("imagenes/naranja.png").getImage();
      this.pixelCeleste = new ImageIcon("imagenes/celeste.png").getImage();
      this.pixelMorado = new ImageIcon("imagenes/morado.png").getImage();
      this.juegoTerminado = new ImageIcon("imagenes/juegoTerminado.png").getImage();
      this.pausa = new ImageIcon("imagenes/pausa.png").getImage();

      this.inicializarTeclas();
      this.pause = false;
   }

   public void inicializarTeclas()
   {
      try
      {
         Scanner scan = new Scanner(new File("configuracion/teclas.txt"));
         if(scan.hasNext())
         {
            this.rotar = scan.nextInt();
            this.abajo = scan.nextInt();
            this.abajoFondo = scan.nextInt();
            this.izquierda = scan.nextInt();
            this.derecha = scan.nextInt();
            this.pausar = scan.nextInt();
            this.hold = scan.nextInt();

            scan.close();
         }
      }

      catch(IOException ex)
      {

      }
   }

   public boolean getJuegoTerminado()
   {
      return this.juegoTermado;
   }

   public void setJuegoTerminado()
   {
      this.juegoTermado = this.tablero.getJuegoTerminado();
   }

   public boolean isPause()
   {
      return this.pause;
   }

   public int getLineasTotales()
   {
      return this.tablero.getLineasTotales();
   }

   public void setPause()
   {
      if(pause)
      {
         this.pause = false;
      }
      else
      {
         this.pause = true;
      }
   }

   @Override
   public void paint(Graphics g)
   {
      int pieza;
      Pieza piezaSiguiente = this.tablero.getPiezaSiguiente();
      Pieza piezaReserva = this.tablero.getPiezaReserva();
      for(int j = 4; j
              < 24; j++)
      {
         for(int i = 0; i
                 < 10; i++)
         {
            if(this.tablero.getTablero()[i][j] != 0)
            {
               pieza = this.tablero.getTablero()[i][j];
               if(pieza == 1)
               {
                  g.drawImage(pixelCeleste, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
               else if(pieza == 2)
               {
                  g.drawImage(pixelAmarillo, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
               else if(pieza == 3)
               {
                  g.drawImage(pixelNaranja, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
               else if(pieza == 4)
               {
                  g.drawImage(pixelAzul, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
               else if(pieza == 5)
               {
                  g.drawImage(pixelVerde, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
               else if(pieza == 6)
               {
                  g.drawImage(pixelMorado, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
               else
               {
                  g.drawImage(pixelRojo, (i * 22) + 22, (j * 22) - 66, 22, 22, this);
               }
            }
         }
      }

      for(int j = 0; j
              < 4; j++)
      {
         for(int i = 0; i
                 < 4; i++)
         {
            if(piezaSiguiente.getPieza()[i][j] != 0)
            {
               pieza = piezaSiguiente.getPieza()[i][j];
               if(pieza == 1)
               {
                  g.drawImage(pixelCeleste, (i * 22) + 290, (j * 22) + 50, 22, 22, this);
               }
               else if(pieza == 2)
               {
                  g.drawImage(pixelAmarillo, (i * 22) + 300, (j * 22) + 30, 22, 22, this);
               }
               else if(pieza == 3)
               {
                  g.drawImage(pixelNaranja, (i * 22) + 311, (j * 22) + 50, 22, 22, this);
               }
               else if(pieza == 4)
               {
                  g.drawImage(pixelAzul, (i * 22) + 311, (j * 22) + 50, 22, 22, this);
               }
               else if(pieza == 5)
               {
                  g.drawImage(pixelVerde, (i * 22) + 311, (j * 22) + 30, 22, 22, this);
               }
               else if(pieza == 6)
               {
                  g.drawImage(pixelMorado, (i * 22) + 311, (j * 22) + 30, 22, 22, this);
               }
               else
               {
                  g.drawImage(pixelRojo, (i * 22) + 311, (j * 22) + 30, 22, 22, this);
               }
            }
         }
      }

      if(piezaReserva != null)
      {
         for(int j = 0; j
                 < 4; j++)
         {
            for(int i = 0; i
                    < 4; i++)
            {
               if(piezaReserva.getPieza()[i][j] != 0)
               {
                  pieza = piezaReserva.getPieza()[i][j];

                  if(pieza == 1)
                  {
                     g.drawImage(pixelCeleste, (i * 22) + 290, (j * 22) + 220, 22, 22, this);
                  }
                  else if(pieza == 2)
                  {
                     g.drawImage(pixelAmarillo, (i * 22) + 300, (j * 22) + 200, 22, 22, this);
                  }
                  else if(pieza == 3)
                  {
                     g.drawImage(pixelNaranja, (i * 22) + 311, (j * 22) + 220, 22, 22, this);
                  }
                  else if(pieza == 4)
                  {
                     g.drawImage(pixelAzul, (i * 22) + 311, (j * 22) + 220, 22, 22, this);
                  }
                  else if(pieza == 5)
                  {
                     g.drawImage(pixelVerde, (i * 22) + 311, (j * 22) + 200, 22, 22, this);
                  }
                  else if(pieza == 6)
                  {
                     g.drawImage(pixelMorado, (i * 22) + 311, (j * 22) + 200, 22, 22, this);
                  }
                  else
                  {
                     g.drawImage(pixelRojo, (i * 22) + 311, (j * 22) + 200, 22, 22, this);
                  }
               }
            }
         }
      }

      g.drawString(Integer.toString(this.tablero.getPuntaje()), 300, 380);
      g.drawString(Integer.toString(this.tablero.getNivel()), 300, 440);

      if(this.tablero.getJuegoTerminado())
      {
         g.drawImage(juegoTerminado, 65, 125, 300, 150, this);
      }

      if(this.pause)
      {
         g.drawImage(pausa, 125, 185, 180, 90, this);
      }
   }

   public void juegoNuevo()
   {
      this.tablero.juegoNuevo();
   }

   public void press(int keyCode)
   {
      if((!this.pause) && !this.getJuegoTerminado())
      {
         if(keyCode == this.izquierda)
         {
            this.tablero.moverIzquierda();
            super.repaint();
         }
         else if(keyCode == this.derecha)
         {
            this.tablero.moverDerecha();
            super.repaint();
         }
         else if(keyCode == this.rotar)
         {
            this.tablero.girarPieza();
            super.repaint();
         }
         else if(keyCode == this.abajo)
         {
            this.tablero.bajarPieza();
            super.repaint();
         }
         else if(keyCode == this.abajoFondo)
         {
            this.tablero.bajarFondo();
            super.repaint();
         }
         else if(keyCode == this.hold && !this.tablero.getReserva())
         {
            this.tablero.ponerReserva();
            super.repaint();
         }
      }
   }

   public void bajarPieza()
   {
      this.tablero.bajarPieza();
      super.repaint();
   }

   public int getAbajo()
   {
      return abajo;
   }

   public void setAbajo(int abajo)
   {
      this.abajo = abajo;
   }

   public int getAbajoFondo()
   {
      return abajoFondo;
   }

   public void setAbajoFondo(int abajoFondo)
   {
      this.abajoFondo = abajoFondo;
   }

   public int getDerecha()
   {
      return derecha;
   }

   public void setDerecha(int derecha)
   {
      this.derecha = derecha;
   }

   public int getHold()
   {
      return hold;
   }

   public void setHold(int hold)
   {
      this.hold = hold;
   }

   public int getIzquierda()
   {
      return izquierda;
   }

   public void setIzquierda(int izquierda)
   {
      this.izquierda = izquierda;
   }

   public int getPausar()
   {
      return pausar;
   }

   public void setPausar(int pausar)
   {
      this.pausar = pausar;
   }

   public int getRotar()
   {
      return rotar;
   }

   public void setRotar(int rotar)
   {
      this.rotar = rotar;
   }
}
