/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Patolinlp
 */
public class DataBase implements Serializable{
    private ArrayList<Puntuacion> puntuaciones;

    public DataBase() {
        this.puntuaciones = new ArrayList<Puntuacion>();
    }

    public void addPuntuacion(Puntuacion puntuacion){
        this.puntuaciones.add(puntuacion);
    }

    /*
     * Este metodo ordena las puntuaciones de mayor a menor!!!
     */
    public void sort(){
    }

    public ArrayList<Puntuacion> getPuntuaciones(){
        return this.puntuaciones;
    }

    public void save(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("puntuaciones.txt")));
            out.writeObject(this);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DataBase open(DataBase dataBase){

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("puntuaciones.txt")));
            dataBase = (DataBase) in.readObject();
            in.close();
            return dataBase;
        } catch (IOException iOException) {
        } catch (ClassNotFoundException classNotFoundException) {
        }
        return dataBase;
    }
}
