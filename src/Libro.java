public class Libro {
    private String isbn;
    private String titulo;

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
