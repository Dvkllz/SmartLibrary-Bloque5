import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class SmartLibraryInterfaz extends JFrame {
    private Estudiante estudiante;
    private Prestamo prestamo;
    private final JLabel fechaVigente = new JLabel();
    private final JLabel cantidad = new JLabel();
    private final JTextField nuevaFecha = new JTextField("2026-10-15", 12);
    private final JTextArea mensajes = new JTextArea(5, 50);
    private final DefaultTableModel historial = new DefaultTableModel(
            new String[]{"Fecha de renovación", "Fecha anterior", "Nueva fecha"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };

    public SmartLibraryInterfaz() {
        super("SmartLibrary — Renovación de préstamos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contenido = new JPanel(new BorderLayout(12, 14));
        contenido.setBorder(BorderFactory.createEmptyBorder(22, 24, 22, 24));
        contenido.setBackground(Color.WHITE);
        setContentPane(contenido);

        JPanel cabecera = new JPanel(new GridLayout(0, 1, 0, 7));
        cabecera.setOpaque(false);
        JLabel titulo = new JLabel("SmartLibrary");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 25));
        cabecera.add(titulo);
        cabecera.add(new JLabel("Renovación de un préstamo · Taller Bloque 5"));
        cabecera.add(new JLabel("Estudiante: Ana    |    Libro: Introducción a Java    |    Ejemplar: EJ01"));
        cabecera.add(fechaVigente);
        cabecera.add(cantidad);
        contenido.add(cabecera, BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout(8, 12));
        centro.setOpaque(false);
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        acciones.setOpaque(false);
        acciones.add(new JLabel("Nueva devolución (AAAA-MM-DD):"));
        nuevaFecha.getAccessibleContext().setAccessibleName("Nueva fecha de devolución");
        acciones.add(nuevaFecha);
        JButton renovar = new JButton("Renovar");
        renovar.addActionListener(e -> renovar());
        acciones.add(renovar);
        JButton reiniciar = new JButton("Reiniciar ejemplo");
        reiniciar.addActionListener(e -> reiniciar());
        acciones.add(reiniciar);
        centro.add(acciones, BorderLayout.NORTH);
        JTable tabla = new JTable(historial);
        tabla.setRowHeight(28);
        tabla.getTableHeader().setReorderingAllowed(false);
        JScrollPane tablaScroll = new JScrollPane(tabla);
        tablaScroll.setBorder(BorderFactory.createTitledBorder("Historial de renovaciones"));
        centro.add(tablaScroll, BorderLayout.CENTER);
        contenido.add(centro, BorderLayout.CENTER);

        mensajes.setEditable(false);
        mensajes.setLineWrap(true);
        mensajes.setWrapStyleWord(true);
        mensajes.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
        JScrollPane avisos = new JScrollPane(mensajes);
        avisos.setBorder(BorderFactory.createTitledBorder("Resultado y notificación"));
        contenido.add(avisos, BorderLayout.SOUTH);
        reiniciar();
        setMinimumSize(new Dimension(840, 560));
        setSize(940, 620);
        setLocationRelativeTo(null);
    }

    private void reiniciar() {
        estudiante = new Estudiante("E001", "Ana", "ana@example.com", "EST01", "Ingenieria de Sistemas");
        Ejemplar ejemplar = new Ejemplar("EJ01", new Libro("LIB01", "Introduccion a Java"));
        prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 8));
        nuevaFecha.setText("2026-10-15");
        historial.setRowCount(0);
        mensajes.setText("Ejemplo listo. Renueva al 15 de octubre y luego intenta la misma fecha o una anterior.\n");
        actualizarEstado();
    }

    private void renovar() {
        try {
            LocalDate fecha = LocalDate.parse(nuevaFecha.getText().trim());
            prestamo.renovar(fecha);
            Renovacion registro = prestamo.getRenovaciones().get(prestamo.getRenovaciones().size() - 1);
            historial.addRow(new Object[]{registro.getFechaRenovacion(), registro.getFechaAnterior(), registro.getNuevaFecha()});
            estudiante.notificar("Su prestamo fue renovado.");
            mensajes.append("Renovación registrada: " + fecha + ".\nNotificación para " + estudiante.getNombre() + ": Su préstamo fue renovado.\n");
        } catch (DateTimeParseException e) {
            mensajes.append("Fecha inválida. Escribe una fecha real con formato AAAA-MM-DD.\n");
        } catch (IllegalArgumentException e) {
            mensajes.append("Renovación rechazada: " + e.getMessage() + "\nLa fecha vigente y el historial se conservan.\n");
        }
        actualizarEstado();
        mensajes.setCaretPosition(mensajes.getDocument().getLength());
    }

    private void actualizarEstado() {
        fechaVigente.setText("Fecha prevista de devolución: " + prestamo.getFechaPrevistaDevolucion());
        cantidad.setText("Renovaciones registradas: " + prestamo.getRenovaciones().size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
            catch (Exception e) { System.err.println("Se usará la apariencia predeterminada."); }
            new SmartLibraryInterfaz().setVisible(true);
        });
    }
}
