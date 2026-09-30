public abstract class Usuario {
    private String identificacion;
    private String nombre;
    private String correo;

    public Usuario(String identificacion, String nombre, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
}
