package controllers;

import classes.Mascota;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Lectura {

    private final String BDMascotas = "DBMascotas.yap";

    public void LecturaDatos() {

        ObjectContainer dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDMascotas);
        
        Mascota mascota = new Mascota();
        
        ObjectSet<Mascota> result = dataBase.queryByExample(mascota);
        
        if (result.isEmpty()) {
            System.out.println("No existen registros personas");
        } else {
            System.out.println("El número de registro es: " + result.size());

            while (result.hasNext()) {
                Mascota mascotaSiguiente = result.next();
                System.out.println("Nombre: " + mascotaSiguiente.getNombre() + ", Raza: " + mascotaSiguiente.getRaza()
                        + ", Edad: " + mascotaSiguiente.getEdad());
            }
        }
           
        dataBase.close();
    }

}
