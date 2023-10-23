package controlador;


import java.sql.SQLException;

import modelo.*;
import vista.*;

public class CtrlPeliculas{
	//ATRIBUTOS
	private VistaPeliculaYSerie vista;
    private BBDD bbdd;
	//CONSTRUCTOR
    public CtrlPeliculas(VistaPeliculaYSerie vista, BBDD bbdd) {
        this.vista = vista;
        this.bbdd = bbdd;

        // Agregar ActionListeners a los botones
        vista.getBtnSiguiente().addActionListener(e -> mostrarSiguientePelicula());
        vista.getBtnAnterior().addActionListener(e -> mostrarAnteriorPelicula());

        // Cargar la primera película
        mostrarPeliculaConId(1);
    }
    
    private void mostrarPeliculaConId(int id) {
        // Llamar a la base de datos para obtener la película con el ID proporcionado
        Contenido pelicula;
        try {
			pelicula = bbdd.select(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vista.mostrarMensajeError("Fallo de Conexión con BBDDs ");
			pelicula = null;
		}

        if (pelicula != null) {
            // Mostrar la película en la vista
            vista.mostrarPelicula(pelicula);
        } else {
            // Manejar el caso en el que no se pudo obtener la película
            vista.mostrarMensajeError("No se pudo cargar la película con ID: " + id);
        }
    }
    
    private void mostrarSiguientePelicula() {
        // Obtener el ID de la película actualmente mostrada
        int idActual = vista.getIdPeliculaActual();

        // Mostrar la siguiente película (sumar 1 al ID actual)
        System.out.println("Actualizando Pelicula: " + (idActual+ 1));
        mostrarPeliculaConId(idActual + 1);
    }

    private void mostrarAnteriorPelicula() {
        // Obtener el ID de la película actualmente mostrada
        int idActual = vista.getIdPeliculaActual();

        // Mostrar la película anterior (restar 1 al ID actual)
        System.out.println("Actualizando Pelicula: " + (idActual-1));
        mostrarPeliculaConId(idActual - 1);
    }
    
}
