/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.Color;

/**
 *
 * @author jorge
 */
public class Barra extends Pieza
{

   public Barra()
   {
      super();

      crearPieza();
   }

   @Override
   public void crearPieza()
   {
      super.pieza[2][0] = 1;
      super.pieza[2][1] = 1;
      super.pieza[2][2] = 1;
      super.pieza[2][3] = 1;

      super.maximoDerecha = 2;
      super.maximoIzquierda = 2;
      super.altura = 3;

      super.color = Color.CYAN;
   }

   @Override
   public void rotarPieza()
   {
      if (super.rotacion == 1)
      {
         super.piezaNueva();

         super.pieza[0][1] = 1;
         super.pieza[1][1] = 1;
         super.pieza[2][1] = 1;
         super.pieza[3][1] = 1;

         super.maximoDerecha = 3;
         super.maximoIzquierda = 0;
         super.altura = 1;

         super.rotacion = 2;
      }
      else
      {
         super.piezaNueva();
         this.crearPieza();

         super.rotacion = 1;
      }
   }

   
}
