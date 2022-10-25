/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Mascota;
import classes.Persona;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author IFC
 */
public class MainAsociarClases {

    private static final String BDMascotas = "DBMascotas.yap";

    public static void main(String[] args) {

//        ObjectContainer dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDMascotas);
//
//        Persona persona1 = new Persona(1);
//        Persona persona2 = new Persona(2);
//
//        Mascota mascota = new Mascota("Chester", "Braco", 7);
//  /*añadimos */
//        dataBase.store(mascota);
//        dataBase.store(persona1);
//        dataBase.store(persona2);
        LecturaDatos();
//        modificarDatos();

    }

    public static void LecturaDatos() {

        ObjectContainer dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDMascotas);

//        Mascota mascota = new Mascota();

        Persona persona = new Persona();
        ObjectSet<Persona> result = dataBase.queryByExample(persona);
//        ObjectSet<Mascota> result = dataBase.queryByExample(mascota);

        if (result.isEmpty()) {

            System.out.println("No existen registros persona");

        } else {
            System.out.println("El número de registro es: " + result.size());

            while (result.hasNext()) {
//                Mascota mascotaSiguiente = result.next();
                Persona personaSiguiente = result.next();
                System.out.println("id: " + personaSiguiente.getId()+" -- "+personaSiguiente.getMascotas().toString());
//                System.out.println("Nombre: " + mascotaSiguiente.getNombre() + ", Raza: " + mascotaSiguiente.getRaza()
//                        + ", Edad: " + mascotaSiguiente.getEdad());
            }
        }

        dataBase.close();
    }

    public static void modificarDatos() {

        ObjectContainer dataBase = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDMascotas);
        System.out.println("obteniendo mascota....");
        /*query*/
        Mascota mascotaChester = new Mascota("Chester", null, 0);
        
        Mascota mascotaModificada = null;

        ObjectSet<Mascota> resultMascota = dataBase.queryByExample(mascotaChester);
        
//        if(resultMascota.size()){}

        if (resultMascota.isEmpty()) {
            System.out.println("No existen registros mascotas");
        } else {

            mascotaModificada = (Mascota) resultMascota.next();

            System.out.println("El número de registro es: " + resultMascota.size());
            
            System.out.println("mascota: "+mascotaModificada.toString());
            
            System.out.println("Datos modificados correctamente");
        }
        System.out.println("obteniendo persona....");
        Persona persona = new Persona(1);

        ObjectSet<Persona> resultPersona = dataBase.queryByExample(persona);

        if (resultPersona.isEmpty()) {
            System.out.println("No existen registros mascotas");
        } else {

            Persona personaModificada = (Persona) resultPersona.next();
            System.out.println("El número de registro es: " + resultPersona.size());

            personaModificada.getMascotas().add(mascotaModificada);

            dataBase.store(personaModificada);
            System.out.println("Datos modificados correctamente");
        }
        
        dataBase.close();
    }
}
