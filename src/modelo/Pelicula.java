package modelo;

import java.io.IOException;

public class Pelicula extends Contenido {
	// Constructor para Películas
	public Pelicula(int idPelicula, String nombre, int anioProduccion, String genero, String directores, String actores,
            String descripcion, String urlImagen) throws IOException {
		super(idPelicula, nombre, anioProduccion, genero, directores, actores, descripcion, urlImagen);
    }
	public Pelicula() throws IOException {
		super();
	}
}
