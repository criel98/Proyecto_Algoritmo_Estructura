package package_clase;

import java.util.ArrayList;

public class GestorCita {
    
    private ArrayList<Cita> listaCitas;

    public GestorCita() {
        listaCitas = new ArrayList<>();
    }

    // agregar cita
    public void agregarCita(Cita cita) {
        listaCitas.add(cita);
    }

    // mostrar cita
    public ArrayList<Cita> obtenerCitas() {
        return listaCitas;
    }

    // buscar por dni
    public Cita buscarPorDni(String dni) {

        for (Cita c : listaCitas) {

            if (c.getDni().equals(dni)) {
                return c;
            }

        }

        return null;
    }

    // eliminar cita
    public boolean eliminarCita(String dni) {

        for (Cita c : listaCitas) {

            if (c.getDni().equals(dni)) {
                listaCitas.remove(c);
                return true;
            }

        }

        return false;
    }
}
    

