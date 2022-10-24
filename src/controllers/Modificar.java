package controllers;

import classes.Mascota;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Modificar {

    private final String BDMascotas = "DBMascotas.yap";

    public void modificarDatos() {
        
        ObjectContainer dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDMascotas);
        
        Mascota mascota = new Mascota("Lola","perro",9);
        
        ObjectSet<Mascota> result = dataBase.queryByExample(mascota);
        
        if (result.isEmpty()) {
            System.out.println("No existen registros mascotas");
        } else {
                        
            Mascota mascotaModificada = (Mascota) result.next();
            
            System.out.println("El número de registro es: " + result.size());
            
            mascotaModificada.setEdad(8);
            dataBase.store(mascotaModificada);
            System.out.println("Datos modificados correctamente");
        }
        
        

    }

}
