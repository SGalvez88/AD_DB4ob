/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Mascota;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

 

public class Insertar {
    private final String BDMascotas = "DBMascotas.yap";
    
    
    public void insert(){
        
        ObjectContainer dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDMascotas);
        
        Mascota mascota1 = new Mascota("Chester", "perro", 7);
        Mascota mascota2 = new Mascota("Lucas", "perro", 9);
        Mascota mascota3 = new Mascota("Lola", "perro", 9);
        Mascota mascota4 = new Mascota("Mia", "perro", 2);
               
        
        dataBase.store(mascota1);
        dataBase.store(mascota2);
        dataBase.store(mascota3);
        dataBase.store(mascota4);
        
        dataBase.close();
    
    }
        
    
}
