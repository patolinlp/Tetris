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
public abstract class Pieza
{
   protected int [][] pieza;
   protected int [][] coordenadaAnterior;
   protected int  maximoIzquierda;
   protected int maximoDerecha;
   protected int altura;
   protected int rotacion;
   protected Color color;

   public Pieza()
   {
      this.pieza = new int [4][4];
      this.coordenadaAnterior = new int [2][1];
      this.maximoIzquierda = 0;
      this.maximoDerecha = 0;
      this.altura = 0;
      this.rotacion = 1;
      this.color = new Color(0);

      this.coordenadaAnterior [0][0] = 3;
      this.coordenadaAnterior [1][0] = 0;

      piezaNueva();
   }

   public int getAltura()
   {
      return altura;
   }

   public int[][] getCoordenadaAnterior()
   {
      return coordenadaAnterior;
   }

   public int getMaximoDerecha()
   {
      return maximoDerecha;
   }

   public int getMaximoIzquierda()
   {
      return maximoIzquierda;
   }

   public int[][] getPieza()
   {
      return pieza;
   }

   public Color getColor()
   {
      return color;
   }

   public int getRotacion()
   {
      return rotacion;
   }

   public void piezaNueva()
   {
      for(int i = 0 ; i < 4 ; i++)
      {
         for(int j = 0 ; j < 4 ; j++)
         {
            this.pieza[i][j] = 0;
         }
      }
   }

   public abstract void rotarPieza();

   public abstract void crearPieza();

   public void setCoordenadaAnterior(int coordenadaX, int coordenadaY)
   {
      this .coordenadaAnterior[0][0] = coordenadaX;
      this.coordenadaAnterior[1][0] = coordenadaY;
   }

}

