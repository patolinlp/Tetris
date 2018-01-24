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
public class PiezaS extends Pieza
{

   public PiezaS()
   {
      super();

      crearPieza();
   }

   @Override
   public void crearPieza()
   {
      super.pieza[0][3] = 5;
      super.pieza[1][2] = 5;
      super.pieza[1][3] = 5;
      super.pieza[2][2] = 5;

      super.maximoDerecha = 2;
      super.maximoIzquierda = 0;
      super.altura = 3;

      super.color = Color.RED;
   }

   @Override
   public void rotarPieza()
   {
      if (super.rotacion == 1)
      {
         super.piezaNueva();

         super.pieza[0][1] = 5;
         super.pieza[0][2] = 5;
         super.pieza[1][2] = 5;
         super.pieza[1][3] = 5;

         super.maximoDerecha = 1;
         super.maximoIzquierda = 0;
         super.altura = 3;

         super.rotacion = 2;
      }

      else if (super.rotacion == 2)
      {
         super.piezaNueva();

         super.pieza[0][2] = 5;
         super.pieza[1][2] = 5;
         super.pieza[1][1] = 5;
         super.pieza[2][1] = 5;

         super.maximoDerecha = 2;
         super.maximoIzquierda = 0;
         super.altura = 2;

         super.rotacion = 3;
      }

      else if (super.rotacion == 3)
      {
         super.piezaNueva();

         super.pieza[1][1] = 5;
         super.pieza[1][2] = 5;
         super.pieza[2][2] = 5;
         super.pieza[2][3] = 5;

         super.maximoDerecha = 2;
         super.maximoIzquierda = 1;
         super.altura = 3;

         super.rotacion = 4;
      }

      else
      {
         super.piezaNueva();
         this.crearPieza();

         super.rotacion = 1;
      }
   }

   public void imprimir()
   {
      for(int j = 0 ; j < 4 ; j++)
      {
         for(int i = 0 ; i < 4 ; i++)
         {
            System.out.print(super.pieza[i][j]);
         }
         System.out.println();
      }
   }
}
