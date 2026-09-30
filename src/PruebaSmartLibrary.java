import java.time.LocalDate;

public class PruebaSmartLibrary {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("E001", "Ana", "ana@example.com",
                "EST01", "Ingenieria de Sistemas");
        Bibliotecario bibliotecario = new Bibliotecario("B001", "Luis", "luis@example.com",
                "EMP01", "Manana");
        Libro libro = new Libro("LIB01", "Introduccion a Java");
        Ejemplar ejemplar = new Ejemplar("EJ01", libro);
        Prestamo prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 8));
        LocalDate fechaEjecucion = LocalDate.now();

        System.out.println("Fecha de ejecucion: " + fechaEjecucion);
        System.out.println("Bibliotecario: " + bibliotecario.getNombre());
        System.out.println("Prueba 1: renovacion valida");
        prestamo.renovar(LocalDate.of(2026, 10, 15));
        estudiante.notificar("Su prestamo fue renovado.");
        Renovacion renovacion = prestamo.getRenovaciones().get(0);
        comprobar(renovacion.getFechaRenovacion().equals(fechaEjecucion), "Fecha de renovacion incorrecta.");
        comprobar(renovacion.getFechaAnterior().equals(LocalDate.of(2026, 10, 8)), "Fecha anterior incorrecta.");
        comprobar(renovacion.getNuevaFecha().equals(LocalDate.of(2026, 10, 15)), "Nueva fecha incorrecta.");
        comprobar(prestamo.getFechaPrevistaDevolucion().equals(renovacion.getNuevaFecha()), "El prestamo no se actualizo.");
        comprobar(prestamo.getRenovaciones().size() == 1, "El historial debe tener una renovacion.");
        System.out.println("Fecha anterior: " + renovacion.getFechaAnterior());
        System.out.println("Fecha de renovacion: " + renovacion.getFechaRenovacion());
        System.out.println("Nueva fecha: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getRenovaciones().size());

        System.out.println("Prueba 2: renovacion invalida");
        probarRechazo(prestamo, LocalDate.of(2026, 10, 15));
        probarRechazo(prestamo, LocalDate.of(2026, 10, 14));
        System.out.println("Fecha despues de los rechazos: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Renovaciones despues de los rechazos: " + prestamo.getRenovaciones().size());
        System.out.println("Resultado: pruebas correctas.");
    }

    private static void probarRechazo(Prestamo prestamo, LocalDate fecha) {
        LocalDate fechaAnterior = prestamo.getFechaPrevistaDevolucion();
        int cantidadAnterior = prestamo.getRenovaciones().size();
        boolean rechazada = false;
        try {
            prestamo.renovar(fecha);
        } catch (IllegalArgumentException e) {
            rechazada = true;
            System.out.println("Intento " + fecha + ": " + e.getMessage());
        }
        comprobar(rechazada, "Se acepto una renovacion invalida.");
        comprobar(prestamo.getFechaPrevistaDevolucion().equals(fechaAnterior), "El rechazo cambio la fecha.");
        comprobar(prestamo.getRenovaciones().size() == cantidadAnterior, "El rechazo cambio el historial.");
    }

    private static void comprobar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }
}
