/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.io.Serializable;

/**
 *
 * @author Patolinlp
 */
public class Puntuacion implements Serializable
{

   private String nombreJugador;
   private int puntuacion;

   public Puntuacion(String nombreJugador)
   {
      this.nombreJugador = nombreJugador;
      this.puntuacion = 0;
   }

   public String getNombreJugador()
   {
      return nombreJugador;
   }

   public void setNombreJugador(String nombreJugador)
   {
      this.nombreJugador = nombreJugador;
   }

   public int getPuntuacion()
   {
      return puntuacion;
   }

   public void setPuntuacion(int puntuacion)
   {
      this.puntuacion = puntuacion;
   }
}
