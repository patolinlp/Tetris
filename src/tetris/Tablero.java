/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jorge
 */
public class Tablero
{

   private int[][] tablero;
   private ArrayList<Pieza> piezas;
   private int lineasTotales;
   private int lineasParciales;
   private int puntaje;
   private int nivel;
   private boolean reserva;
   private boolean juegoTerminado;

   public Tablero()
   {
      this.tablero = new int[10][24];
      this.piezas = new ArrayList<Pieza>(3);

      this.piezas.add(0, new Barra());
      this.piezas.add(1, new Barra());
      this.piezas.add(2, null);

      this.lineasTotales = 0;
      this.lineasParciales = 10;
      this.puntaje = 0;
      this.nivel = 1;
      this.reserva = false;
      this.juegoTerminado = false;

      completarTablero();


   }

   public int[][] getTablero()
   {
      return this.tablero;
   }

   public Pieza getPiezaSiguiente()
   {
      return this.piezas.get(0);
   }

   public Pieza getPiezaReserva()
   {
      return this.piezas.get(2);
   }

   public int getLineasTotales()
   {
      return this.lineasTotales;
   }

   public int getPuntaje()
   {
      return this.puntaje;
   }

   public boolean getReserva()
   {
      return this.reserva;
   }

   public boolean getJuegoTerminado()
   {
      return this.juegoTerminado;
   }

   public int getNivel()
   {
      return this.nivel;
   }

   public void setJuegoTerminado(boolean juegoTerminado)
   {
      this.juegoTerminado = juegoTerminado;
   }

   public void setNivel(int nivel)
   {
      this.nivel = nivel;
   }

   public void completarTablero()
   {
      for(int i = 0; i < 10; i++)
      {
         for(int j = 0; j < 24; j++)
         {
            this.tablero[i][j] = 0;
         }
      }

      siguientePieza();
      agregarPieza();
   }

   public void siguientePieza()
   {
      Random rn = new Random();
      int numeroPieza = rn.nextInt(14);

      if(numeroPieza == 0 || numeroPieza == 1)
      {
         this.piezas.set(0, new Cuadrado());
      }
      else if(numeroPieza == 2 || numeroPieza == 3)
      {
         this.piezas.set(0, new Barra());
      }
      else if(numeroPieza == 4 || numeroPieza == 5)
      {
         this.piezas.set(0, new LIzquierda());
      }
      else if(numeroPieza == 6 || numeroPieza == 7)
      {
         this.piezas.set(0, new LDerecha());
      }
      else if(numeroPieza == 8 || numeroPieza == 9)
      {
         this.piezas.set(0, new PiezaS());
      }
      else if(numeroPieza == 10 || numeroPieza == 11)
      {
         this.piezas.set(0, new PiezaZ());
      }
      else if(numeroPieza == 12 || numeroPieza == 13)
      {
         this.piezas.set(0, new PiezaT());
      }
   }

   public void agregarPieza()
   {
      if(!juegoTerminado())
      {
         this.piezas.set(1, this.piezas.get(0));
         siguientePieza();

         for(int j = 0; j < 4; j++)
         {
            for(int i = 3; i < 7; i++)
            {
               if(this.piezas.get(1).getPieza()[i - 3][j] != 0)
               {
                  this.tablero[i][j] = this.piezas.get(1).getPieza()[i - 3][j];
               }
            }
         }        
      }
   }

   public void bajarPieza()
   {
      if(permitirAbajo(this.piezas.get(1)))
      {
         borrarPieza();

         int coordenadaX = this.piezas.get(1).getCoordenadaAnterior()[0][0];
         int coordenadaY = this.piezas.get(1).getCoordenadaAnterior()[1][0];
         int piezaX = 0;
         int piezaY = 0;
         int maximoA = this.piezas.get(1).getAltura();

         for(int j = coordenadaY + 1; j < (coordenadaY + 5); j++)
         {
            for(int i = coordenadaX; (i < (coordenadaX + 4)) && (i <= 9); i++)
            {
               if(this.piezas.get(1).getPieza()[piezaX][piezaY] != 0)
               {
                  this.tablero[i][j] = this.piezas.get(1).getPieza()[piezaX][piezaY];
               }

               piezaX++;
            }

            piezaX = 0;
            piezaY++;
         }

         this.piezas.get(1).setCoordenadaAnterior(coordenadaX, coordenadaY + 1);
      }
      else
      {
         lineaCompleta();
         agregarPieza();

         this.reserva = false;
      }
   }

   public void moverDerecha()
   {
      if(permitirDerecha(this.piezas.get(1)))
      {
         int coordenadaX = this.piezas.get(1).getCoordenadaAnterior()[0][0];
         int coordenadaY = this.piezas.get(1).getCoordenadaAnterior()[1][0];
         int maximoD = this.piezas.get(1).getMaximoDerecha();
         int piezaX = 0;
         int piezaY = 0;
         // if (coordenadaX + maximoD + 1 <= 9)
         {
            borrarPieza();

            for(int j = coordenadaY; j < (coordenadaY + 4); j++)
            {
               for(int i = coordenadaX + 1; i <= (coordenadaX + 1 + maximoD); i++)
               {
                  if(this.piezas.get(1).getPieza()[piezaX][piezaY] != 0)
                  {
                     this.tablero[i][j] = this.piezas.get(1).getPieza()[piezaX][piezaY];
                  }

                  piezaX++;
               }
               piezaX = 0;
               piezaY++;
            }

            this.piezas.get(1).setCoordenadaAnterior(coordenadaX + 1, coordenadaY);
         }
      }
   }

   public void moverIzquierda()
   {
      if(permitirIzquierda(this.piezas.get(1)))
      {
         int coordenadaX = this.piezas.get(1).getCoordenadaAnterior()[0][0];
         int coordenadaY = this.piezas.get(1).getCoordenadaAnterior()[1][0];
         int maximoI = this.piezas.get(1).getMaximoIzquierda();
         int maximoD = this.piezas.get(1).getMaximoDerecha();
         int piezaX = 0;
         int piezaY = 0;
         {
            borrarPieza();

            for(int j = coordenadaY; j < (coordenadaY + 4); j++)
            {
               for(int i = (coordenadaX - 1); i < (coordenadaX + maximoD); i++)
               {
                  if(this.piezas.get(1).getPieza()[piezaX][piezaY] != 0)
                  {
                     this.tablero[i][j] = this.piezas.get(1).getPieza()[piezaX][piezaY];
                  }

                  piezaX++;
               }
               piezaX = 0;
               piezaY++;
            }

            this.piezas.get(1).setCoordenadaAnterior(coordenadaX - 1, coordenadaY);
         }
      }
   }

   public void girarPieza()
   {
      permitirRotar(this.piezas.get(1));

      int coordenadaX = this.piezas.get(1).getCoordenadaAnterior()[0][0];
      int coordenadaY = this.piezas.get(1).getCoordenadaAnterior()[1][0];
      int piezaX = 0;
      int piezaY = 0;

      for(int j = coordenadaY; j < (coordenadaY + 4); j++)
      {
         for(int i = coordenadaX; i < (coordenadaX + 4); i++)
         {
            if(this.piezas.get(1).getPieza()[piezaX][piezaY] != 0)
            {
               this.tablero[i][j] = this.piezas.get(1).getPieza()[piezaX][piezaY];
            }

            piezaX++;
         }

         piezaX = 0;
         piezaY++;
      }

      this.piezas.get(1).setCoordenadaAnterior(coordenadaX, coordenadaY);

   }

   public void bajarFondo()
   {
      for(int i = 0; i < 23 && permitirAbajo(this.piezas.get(1)); i++)
      {
         bajarPieza();
      }
   }

   public void borrarPieza()
   {
      int coordenadaX = this.piezas.get(1).coordenadaAnterior[0][0];
      int coordenadaY = this.piezas.get(1).coordenadaAnterior[1][0];
      int maximoI = this.piezas.get(1).maximoIzquierda;
      int maximoD = this.piezas.get(1).maximoDerecha;
      int piezaX = maximoI;
      int piezaY = 0;

      for(int j = coordenadaY; j < (coordenadaY + 4); j++)
      {
         for(int i = (coordenadaX + maximoI); i <= (coordenadaX + maximoD); i++)
         {
            if(this.piezas.get(1).getPieza()[piezaX][piezaY] != 0)
            {
               this.tablero[i][j] = 0;
            }

            piezaX++;
         }

         piezaX = maximoI;
         piezaY++;
      }
   }

   public boolean permitirIzquierda(Pieza pieza)
   {
      int coordenadaX = pieza.getCoordenadaAnterior()[0][0];
      int coordenadaY = pieza.getCoordenadaAnterior()[1][0];
      int maximoI = pieza.getMaximoIzquierda();
      int maximoD = pieza.getMaximoDerecha();
      int piezaX = 0;
      int piezaY = 0;
      boolean bandera = true;

      for(int j = coordenadaY; j < (coordenadaY + 4); j++)
      {
         for(int i = coordenadaX; i <= (coordenadaX + maximoD); i++)
         {
            if(pieza.getPieza()[piezaX][piezaY] != 0)
            {
               if((i - 1) < 0 || this.tablero[i - 1][j] != 0)
               {
                  bandera = false;
               }

               break;
            }

            piezaX++;
         }

         if(!bandera)
         {
            break;
         }

         piezaX = 0;
         piezaY++;
      }

      return bandera;
   }

   public boolean permitirDerecha(Pieza pieza)
   {
      int coordenadaX = pieza.getCoordenadaAnterior()[0][0];
      int coordenadaY = pieza.getCoordenadaAnterior()[1][0];
      int maximoI = pieza.getMaximoIzquierda();
      int maximoD = pieza.getMaximoDerecha();
      int piezaX = maximoD;
      int piezaY = 0;
      boolean bandera = true;

      for(int j = coordenadaY; j < (coordenadaY + 4); j++)
      {
         for(int i = (coordenadaX + maximoD); i > coordenadaX; i--)
         {
            if(pieza.getPieza()[piezaX][piezaY] != 0)
            {
               if(i + 1 > 9 || this.tablero[i + 1][j] != 0)
               {
                  bandera = false;
               }

               break;
            }

            piezaX--;
         }

         if(!bandera)
         {
            break;
         }

         piezaX = maximoD;
         piezaY++;
      }

      return bandera;
   }

   public boolean permitirAbajo(Pieza pieza)
   {
      int coordenadaX = pieza.getCoordenadaAnterior()[0][0];
      int coordenadaY = pieza.getCoordenadaAnterior()[1][0];
      int maximoI = pieza.getMaximoIzquierda();
      int maximoD = pieza.getMaximoDerecha();
      int maximoA = pieza.getAltura();
      int piezaX = maximoI;
      int piezaY = maximoA;
      boolean bandera = true;

      for(int i = (coordenadaX + maximoI); i <= (coordenadaX + maximoD); i++)
      {
         for(int j = (coordenadaY + maximoA); j > 0; j--)
         {
            if(pieza.getPieza()[piezaX][piezaY] != 0)
            {
               if((j + 1) > 23 || this.tablero[i][j + 1] != 0)
               {
                  bandera = false;
               }
               break;
            }

            piezaY--;
         }

         if(!bandera)
         {
            break;
         }

         piezaY = maximoA;
         piezaX++;
      }

      return bandera;
   }

   public void permitirRotar(Pieza pieza)
   {
      int coordenadaX = pieza.getMaximoIzquierda();

      borrarPieza();
      pieza.rotarPieza();

      if(pieza.getCoordenadaAnterior()[0][0] + pieza.getMaximoDerecha() > 9)
      {
         if(permitirIzquierda(pieza))
         {
            pieza.setCoordenadaAnterior((pieza.getCoordenadaAnterior()[0][0] - 1), pieza.getCoordenadaAnterior()[1][0]);

            if(!superPosicion(pieza))
            {
               pieza.setCoordenadaAnterior((pieza.getCoordenadaAnterior()[0][0] + 1), pieza.getCoordenadaAnterior()[1][0]);

               for(int i = 0; i < 3; i++)
               {
                  pieza.rotarPieza();
               }
            }


         }
         else
         {
            for(int i = 0; i < 3; i++)
            {
               pieza.rotarPieza();
            }
         }
      }
      else if(pieza.getCoordenadaAnterior()[0][0] + pieza.getMaximoIzquierda() < 0)
      {
         if(permitirDerecha(pieza))
         {
            pieza.setCoordenadaAnterior(pieza.getCoordenadaAnterior()[0][0] + coordenadaX, pieza.getCoordenadaAnterior()[1][0]);

            if(!superPosicion(pieza))
            {
               pieza.setCoordenadaAnterior(pieza.getCoordenadaAnterior()[0][0] - coordenadaX, pieza.getCoordenadaAnterior()[1][0]);

               for(int i = 0; i < 3; i++)
               {
                  pieza.rotarPieza();
               }
            }
         }
         else
         {
            for(int i = 0; i < 3; i++)
            {
               pieza.rotarPieza();
            }
         }
      }
      else if(!superPosicion(pieza))
      {
         for(int i = 0; i < 3; i++)
         {
            pieza.rotarPieza();
         }
      }
   }

   public boolean superPosicion(Pieza pieza)
   {
      int coordenadaX = pieza.getCoordenadaAnterior()[0][0];
      int coordenadaY = pieza.getCoordenadaAnterior()[1][0];

      for(int j = 0; j < 4; j++)
      {
         for(int i = pieza.getMaximoIzquierda(); i < 4 - (3 - pieza.getMaximoDerecha()); i++)
         {
            if(this.tablero[coordenadaX + i][coordenadaY + j] != 0 && pieza.getPieza()[i][j] != 0)
            {
               return false;
            }
         }
      }
      return true;
   }

   public void lineaCompleta()
   {
      boolean bandera = true;
      int lineasBorradas = 0;

      for(int j = 23; j > 3; j--)
      {
         for(int i = 0; i <= 9 && bandera; i++)
         {
            if(this.tablero[i][j] == 0)
            {
               bandera = false;
            }
         }

         if(bandera)
         {
            for(int i = 0; i < 9; i++)
            {
               this.tablero[i][j] = 0;
            }

            bajarLinea(j);
            lineasBorradas++;
            j++;
         }

         bandera = true;
      }

      puntaje(lineasBorradas);
   }

   public void bajarLinea(int linea)
   {
      for(int j = linea; j > 3; j--)
      {
         for(int i = 0; i <= 9; i++)
         {
            this.tablero[i][j] = this.tablero[i][j - 1];
         }
      }
   }

   public void puntaje(int lineasBorradas)
   {
      this.puntaje += 100 * lineasBorradas;
      this.lineasTotales += lineasBorradas;

      if(this.lineasTotales >= this.lineasParciales)
      {
         this.lineasParciales += 10;
         setNivel(getNivel() + 1);
      }
   }

   public void ponerReserva()
   {
      this.reserva = true;

      borrarPieza();

      if(this.piezas.get(2) == null)
      {
         this.piezas.set(2, this.piezas.get(1));
         this.piezas.get(2).piezaNueva();
         this.piezas.get(2).crearPieza();
         agregarPieza();
      }
      else
      {
         Pieza pieza = this.piezas.get(2);
         this.piezas.set(2, this.piezas.get(1));
         this.piezas.get(2).piezaNueva();
         this.piezas.set(1, pieza);
         this.piezas.get(1).setCoordenadaAnterior(3, 0);

         this.piezas.get(2).crearPieza();
      }
   }

   public boolean juegoTerminado()
   {
      for(int j = 0; j < 4; j++)
      {
         for(int i = 3; i < 7; i++)
         {
            if(this.tablero[i][j] != 0)
            {
               setJuegoTerminado(true);
               break;
            }
         }
      }

      return this.juegoTerminado;
   }

   public void juegoNuevo()
   {
      setJuegoTerminado(false);
      completarTablero();
      this.puntaje = 0;
      this.lineasTotales = 0;
      this.lineasParciales = 10;
      this.piezas.set(2, null);
      setNivel(1);
   }

   public void imprimir()
   {
      for(int j = 0; j < 24; j++)
      {
         for(int i = 0; i < 10; i++)
         {
            System.out.print(tablero[i][j] + " ");
         }

         System.out.println();
      }
   }
}
