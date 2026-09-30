public class Estudiante extends Usuario implements Notificable {
    private String codigoEstudiantil;
    private String programaAcademico;

    public Estudiante(String identificacion, String nombre, String correo,
                      String codigoEstudiantil, String programaAcademico) {
        super(identificacion, nombre, correo);
        this.codigoEstudiantil = codigoEstudiantil;
        this.programaAcademico = programaAcademico;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificacion para " + getNombre() + ": " + mensaje);
    }
}
