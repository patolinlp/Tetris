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
public class PanelSiguiente extends JPanel
{
   private Image borde;
   private Image relleno;
   
   public PanelSiguiente()
   {
      super.setLocation(286, 30);
      super.setSize(132, 132);
      super.setVisible(true);

      this.borde = new ImageIcon("src/imagenes/borde.png").getImage();
      this.relleno = new ImageIcon("src/imagenes/relleno2.png").getImage();
   }

   @Override
   public void paint(Graphics g)
   {
      int pixelX1 = 0;
      int pixelX2 = 100;
      int pixelY1 = 0;
      int pixelY2 = 100;

      //super.paintComponents(g);
      
      g.drawImage(relleno, 11, 11, 88, 88, this);

      for(int i = 0 ; i < 11 ; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 10, 10, this);
         g.drawImage(borde, pixelX1, pixelY2, 10, 10, this);

         pixelX1 += 10;
      }

      pixelX1 = 0;

      for(int i = 0 ; i< 10 ; i++)
      {
         g.drawImage(borde, pixelX1, pixelY1, 10, 10, this);
         g.drawImage(borde, pixelX2, pixelY1, 10, 10, this);

         pixelY1 += 10;
      }

   }
}
