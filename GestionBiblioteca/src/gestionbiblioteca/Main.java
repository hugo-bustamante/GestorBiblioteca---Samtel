package gestionbiblioteca;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Bienvenido al sistema de gestión de biblioteca:\n");

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            consumirSaltoDeLinea(scanner); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el autor del libro:");
                    String autor = scanner.nextLine();
                    System.out.println("Ingrese el año de publicación del libro:");
                    int anioPublicacion = scanner.nextInt();
                    consumirSaltoDeLinea(scanner); // Consumir el salto de línea
                    biblioteca.agregarLibro(new Libro(titulo, autor, anioPublicacion));
                    System.out.println("Libro agregado al catálogo.\n");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Ingrese el identificador del usuario:");
                    int identificadorUsuario = scanner.nextInt();
                    consumirSaltoDeLinea(scanner); // Consumir el salto de línea
                    Usuario usuario = new Usuario(nombreUsuario, identificadorUsuario);
                    System.out.println("Ingrese el título del libro a prestar:");
                    String tituloPrestar = scanner.nextLine();
                    biblioteca.prestarLibro(usuario, tituloPrestar);
                    break;
                case 3:
                    System.out.println("Ingrese el título del libro a devolver:");
                    String tituloDevolver = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolver);
                    break;
                case 4:
                    biblioteca.mostrarCatalogo();
                    break;
                case 5:
                    biblioteca.mostrarLibrosPrestados();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.\n");
                    break;
            }
        } while (opcion != 6);

        scanner.close(); // Cerrar el scanner al finalizar
    }

    private static void mostrarMenu() {
        System.out.println("1. Agregar Nuevo Libro");
        System.out.println("2. Prestar Libro");
        System.out.println("3. Devolver Libro");
        System.out.println("4. Mostrar Catálogo");
        System.out.println("5. Mostrar Libros Prestados");
        System.out.println("6. Salir");
        System.out.print("Por favor, seleccione una opción: ");
    }

    private static void consumirSaltoDeLinea(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Consumir el salto de línea solo si hay algo en la línea
        }
    }
}
