public class Bibliotecario extends Usuario {
    private String codigoEmpleado;
    private String turno;

    public Bibliotecario(String identificacion, String nombre, String correo,
                        String codigoEmpleado, String turno) {
        super(identificacion, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }
}
