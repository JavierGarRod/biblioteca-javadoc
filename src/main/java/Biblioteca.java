/**
 * La clase Biblioteca representa una biblioteca con un nombre, una ciudad y una
 * capacidad maxima de libros. Permite agregar y retirar libros,
 * respetando los limites de capacidad. Tambien tiene metodos para consultar el
 * espacio disponible, el porcentaje de ocupacion y si la biblioteca esta llena.
 * Ademas, proporciona informacion basica mediante getters y un metodo
 * toString() que resume su estado actual.
 * @author Javier Garcia Rodriguez
 * @version 1.0
 * @since 27/04/2026
 */

public class Biblioteca {
    private String nombre; /**Representa el nombre de la biblioteca*/
    private String ciudad; /**Representa en que ciudad se situa la biblioteca*/
    private int capacidad; /**Representa la capacidad maxima que presenta la biblioteca*/
    private int librosActuales; /**Representa la cantidad de libros que tiene la biblioteca*/

    /**
     * Crea una nueva biblioteca con un nombre, una ciudad y una capacidad máxima.
     * @param nombre nombre de la biblioteca
     * @param ciudad ciudad donde se ubica la biblioteca
     * @param capacidad capacidad máxima de libros que puede almacenar
     */
    public Biblioteca(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.librosActuales = 0;
    }

    /**
     * Agrega una cantidad de libros a la biblioteca si hay espacio disponible.
     * @param cantidad número de libros a agregar
     * @return true si los libros se agregaron correctamente, false en caso contrario
     */
    public boolean agregarLibro(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (librosActuales + cantidad > capacidad) {
            return false;
        }
        librosActuales += cantidad;
        return true;
    }

    /**
     * Retira una cantidad de libros de la biblioteca si es posible.
     * @param cantidad número de libros a retirar
     * @return true si los libros se retiraron correctamente, false en caso contrario
     */
    public boolean retirarLibro(int cantidad) {
        if (cantidad <= 0 || cantidad > librosActuales) {
            return false;
        }
        librosActuales -= cantidad;
        return true;
    }

    /**
     * Obtiene el espacio disponible para almacenar más libros.
     * @return cantidad de espacio libre en la biblioteca
     */
    public int getEspacioDisponible() {
        return capacidad - librosActuales;
    }

    /**
     * Calcula el porcentaje de ocupacion de la biblioteca.
     * @return porcentaje de ocupación en formato decimal (0.0 a 100.0)
     */
    public double getPorcentajeOcupacion() {
        if (capacidad == 0) return 0.0;
        return (librosActuales * 100.0) / capacidad;
    }

    /**
     * Indica si la biblioteca está llena.
     * @return true si no queda espacio disponible, false en caso contrario
     */
    public boolean estaLlena() {
        return librosActuales >= capacidad;
    }

    /**
     * Obtiene el nombre de la biblioteca.
     * @return nombre de la biblioteca
     */
    public String getNombre()        { return nombre; }

    /**
     * Obtiene la ciudad donde se encuentra la biblioteca.
     * @return ciudad de la biblioteca
     */
    public String getCiudad()        { return ciudad; }

    /**
     * Obtiene la capacidad maxima de libros de la biblioteca.
     * @return capacidad total
     */
    public int getCapacidad()        { return capacidad; }

    /**
     * Obtiene la cantidad actual de libros almacenados.
     * @return número de libros actuales
     */
    public int getLibrosActuales()   { return librosActuales; }

    /**
     * Devuelve una representación en texto de la biblioteca.
     * @return cadena con el formato "Nombre (Ciudad) - librosActuales/capacidad libros"
     */
    @Override
    public String toString() {
        return nombre + " (" + ciudad + ") - " + librosActuales + "/" + capacidad + " libros";
    }
}