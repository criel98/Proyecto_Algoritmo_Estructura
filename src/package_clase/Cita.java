package package_clase;

public class Cita {

    //atributos
    private String dni;
    private String nombre;
    private String telefono;
    private String especialidad;
    private String medico;
    private String fecha;
    private String hora;

    //constructores
    public Cita() {}
    
    public Cita(String dni, String nombre, String telefono,
            String especialidad, String medico,
            String fecha, String hora) {

        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    // getter y setter

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
