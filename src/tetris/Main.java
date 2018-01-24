/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.Random;
import javax.swing.UIManager;

/**
 *
 * @author jorge
 */
public class Main
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      try
      {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch (Exception e)
      {
      }

      Inicio inicio = new Inicio();

      //VentanaTetris ventanaTetris = new VentanaTetris();

      //ventanaTetris.start();
     
      //Tablero tablero = new Tablero();
      //Cuadrado cuadrado = new Cuadrado();
      //PiezaS piezaS = new PiezaS();
      //piezaS.rotarPieza();
      //piezaS.imprimir();
      //cuadrado.imprimir();
      //tablero.agregarPieza();
      //tablero.imprimir();
      //System.out.println();
      //tablero.bajarPieza();
      //tablero.moverIzquierda();
      //tablero.moverDerecha();

      //tablero.borrarPieza();
      //ablero.girarPieza();

      /*int i = 0;
      while(i < 100)
      {
      tablero.bajarPieza();
      i++;
      }*/

      /* tablero.agregarPieza();

      i = 0;
      int j = new Random().nextInt(6);
      while(i < 25)
      {
      tablero.bajarPieza();
      i++;
      }*/


      //tablero.bajarPieza();
      /*int i = 0;
      while (i < 20)
      {
      Random rn = new Random();
      switch(rn.nextInt(4))
      {
      case(0):
      {
      tablero.bajarPieza();
      break;
      }
      case(1):
      {
      tablero.moverDerecha();
      break;
      }
      case(2):
      {
      tablero.moverIzquierda();
      break;
      }
      case(3):
      {
      tablero.girarPieza();
      break;
      }
      default:
      {

      }
      }
      //tablero.moverIzquierda();
      i++;
      }*/


      //tablero.imprimir();
   }
}
