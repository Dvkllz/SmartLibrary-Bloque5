public class Ejemplar {
    private String codigo;
    private Libro libro;

    public Ejemplar(String codigo, Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El ejemplar debe tener un libro.");
        }
        this.codigo = codigo;
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }
}
