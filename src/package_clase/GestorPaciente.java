package package_clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorPaciente {

    private ArrayList<Paciente> listaPacientes;
    private final String RUTA_ARCHIVO = "pacientes.csv";

    public GestorPaciente() {
        listaPacientes = new ArrayList<>();
        cargarDesdeCSV(); // Carga los datos automáticamente al instanciar el gestor
    }

    // Registrar un nuevo paciente
    public void agregarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
        guardarEnCSV(); // Sincroniza con el archivo físico inmediatamente
    }

    // Obtener la lista completa en memoria
    public ArrayList<Paciente> obtenerPacientes() {
        return listaPacientes;
    }

    // Buscar paciente por número de documento (DNI / CE)
    public Paciente buscarPorDocumento(String numeroDocumento) {
        for (Paciente p : listaPacientes) {
            if (p.getNumeroDocumento().equals(numeroDocumento)) {
                return p; // Retorna el objeto completo si lo encuentra
            }
        }
        return null; // Retorna null si no existe
    }

    // Eliminar paciente de forma segura usando índices
    public boolean eliminarPaciente(String numeroDocumento) {
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i).getNumeroDocumento().equals(numeroDocumento)) {
                listaPacientes.remove(i);
                guardarEnCSV(); // Actualiza el archivo tras eliminar
                return true;
            }
        }
        return false;
    }

    // =========================================================================
    // MÉTODOS DE PERSISTENCIA (MANEJO DEL ARCHIVO CSV)
    // =========================================================================
    
    private void guardarEnCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Paciente p : listaPacientes) {
                bw.write(p.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo CSV: " + e.getMessage());
        }
    }

    private void cargarDesdeCSV() {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) {
            return; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            listaPacientes.clear();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 8) {
                    Paciente p = new Paciente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                    listaPacientes.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los datos desde el archivo CSV: " + e.getMessage());
        }
    }
}