package gestionbiblioteca;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Libro> librosDisponibles;
    private List<Libro> librosPrestados;

    public Biblioteca() {
        librosDisponibles = new ArrayList<>();
        librosPrestados = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void prestarLibro(Usuario usuario, String tituloLibro) {
        Libro libro = buscarLibro(tituloLibro);
        if (libro != null) {
            librosDisponibles.remove(libro);
            librosPrestados.add(libro);
            System.out.println("Libro prestado correctamente a " + usuario.getNombre());
        } else {
            System.out.println("El libro no está disponible en la biblioteca");
        }
    }

    public void devolverLibro(String tituloLibro) {
        Libro libro = buscarLibro(tituloLibro);
        if (libro != null && librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
            librosDisponibles.add(libro);
            System.out.println("Libro devuelto correctamente");
        } else {
            System.out.println("El libro no está prestado actualmente");
        }
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de la biblioteca:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getAnioPublicacion());
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados actualmente:");
        for (Libro libro : librosPrestados) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getAnioPublicacion());
        }
    }

    private Libro buscarLibro(String tituloLibro) {
        for (Libro libro : librosDisponibles) {
            if (libro.getTitulo().equals(tituloLibro)) {
                return libro;
            }
        }
        return null;
    }
}
