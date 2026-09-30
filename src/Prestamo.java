import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar,
                    LocalDate fechaPrevistaDevolucion) {
        if (estudiante == null || ejemplar == null || fechaPrevistaDevolucion == null) {
            throw new IllegalArgumentException("El prestamo requiere estudiante, ejemplar y fecha.");
        }
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        if (nuevaFecha == null || !nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException("La nueva fecha debe ser posterior a la fecha prevista vigente.");
        }
        Renovacion renovacion = new Renovacion(
                LocalDate.now(), fechaPrevistaDevolucion, nuevaFecha);
        renovaciones.add(renovacion);
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public List<Renovacion> getRenovaciones() {
        return Collections.unmodifiableList(renovaciones);
    }
}
