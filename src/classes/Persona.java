
package classes;

import java.util.ArrayList;

public class Persona {
    
    private int id;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    

    public Persona() {
    }

    public Persona(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
    
    
    
    
 
}
