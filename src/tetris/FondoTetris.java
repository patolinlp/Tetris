/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jorge
 */
public class FondoTetris extends JPanel
{

   private Image borde;
   private Image relleno;
   private Image relleno2;
   private Image fondo;
   private Image fondoPuntaje;
   private Image piezaGuardada;
   private Image SiguientePieza;

   public FondoTetris()
   {
      super.setSize(600, 600);
      super.setVisible(true);

      this.borde = new ImageIcon("imagenes/borde.png").getImage();
      this.relleno = new ImageIcon("imagenes/rellenoc.png").getImage();
      this.fondo = new ImageIcon("imagenes/fondo.png").getImage();
      this.relleno2 = new ImageIcon("imagenes/relleno2b.png").getImage();
      this.fondoPuntaje = new ImageIcon("imagenes/fondoPuntaje.png").getImage();
      this.piezaGuardada = new ImageIcon("imagenes/piezaGuardada.png").getImage();
      this.SiguientePieza = new ImageIcon("imagenes/siguientePieza.png").getImage();
   }

   @Override
   public void paint(Graphics g)
   {
      int pixelX1 = 0;
      int pixelX2 = 242;
      int pixelY1 = 0;
      int pixelY2 = 462;

      g.drawImage(fondo, 0, 0, 746, 538, this);
      g.drawImage(relleno, 23, 22, 219, 439, this);
      g.drawImage(this.SiguientePieza, 275, 0, 150, 50, this);
      g.drawImage(this.piezaGuardada, 275, 160, 150, 50, this);
      g.drawImage(this.fondoPuntaje, 270, 330, 150, 180, this);

      //g.drawImage(relleno2, 290, 40, 109, 109, this);

      for(int i = 0; i < 22; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 22, 22, this);
         g.drawImage(borde, pixelX2, pixelY1, 22, 22, this);

         pixelY1 += 22;
      }

      pixelX1 = 0;
      pixelY1 = 0;

      for(int i = 0; i < 12; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 22, 22, this);
         g.drawImage(borde, pixelX1, pixelY2, 22, 22, this);

         pixelX1 += 22;
      }

      pixelX1 = 280;
      pixelX2 = 400;
      pixelY1 = 30;
      pixelY2 = 150;


      for(int i = 0; i < 13; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 10, 10, this);
         g.drawImage(borde, pixelX1, pixelY2, 10, 10, this);

         pixelX1 += 10;
      }

      pixelX1 = 280;

      for(int i = 0; i < 13; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 10, 10, this);
         g.drawImage(borde, pixelX2, pixelY1, 10, 10, this);

         pixelY1 += 10;
      }

      pixelY1 = 200;
      pixelY2 = 320;

      for(int i = 0; i < 13; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 10, 10, this);
         g.drawImage(borde, pixelX1, pixelY2, 10, 10, this);

         pixelX1 += 10;
      }

      pixelX1 = 280;

      for(int i = 0; i < 13; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 10, 10, this);
         g.drawImage(borde, pixelX2, pixelY1, 10, 10, this);

         pixelY1 += 10;
      }
   }
}
