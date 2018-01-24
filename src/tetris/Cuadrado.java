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
public class Cuadrado extends Pieza
{

   public Cuadrado()
   {
      super();

      crearPieza();
   }

   @Override
   public void crearPieza()
   {
      super.pieza[1][2] = 2;
      super.pieza[2][2] = 2;
      super.pieza[1][3] = 2;
      super.pieza[2][3] = 2;

      super.maximoDerecha = 2;
      super.maximoIzquierda = 1;
      super.altura = 3;

      super.color = Color.YELLOW;
   }

   public void imprimir()
   {
      for (int j = 0; j < 4; j++)
      {
         for (int i = 0; i < 4; i++)
         {
            System.out.print(super.pieza[i][j]);
         }
         System.out.println();
      }
   }

   @Override
   public void rotarPieza()
   {
      if (super.coordenadaAnterior[0][0] == 7)
      {
        /* super.piezaNueva();

         super.pieza[2][2] = 1;
         super.pieza[3][2] = 1;
         super.pieza[2][3] = 1;
         super.pieza[3][3] = 1;

         super.maximoDerecha = 3;
         super.maximoIzquierda = 2;*/

        // super.coordenadaAnterior[0][0] = 8;
      }
   }
}
