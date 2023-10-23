package modelo;

import java.io.IOException;

public class Serie extends Contenido{

    // Atributos
    private int temporadas; // Número de temporadas
    // Constructor que acepta una URL de imagen
    public Serie(int idSerie, String nombre, int anioProduccion, String genero, String directores, String actores,
            String descripcion, String urlImagen, int temporadas){
        this.setIdPelicula(idSerie);
    	this.setNombre(nombre);
        this.setAnioProduccion(anioProduccion);
        this.setGenero(genero);
        this.setDirectores(directores);
        this.setActores(actores);
        this.setDescripcion(descripcion);
        this.setImagen(urlImagen);
        this.temporadas = temporadas;
    }
    //CONSTRUCTOR
    public Serie() {
		this.setIdPelicula(0);
		this.setNombre("");
		this.setAnioProduccion(0);
		this.setGenero("");
		this.setDirectores("");
		this.setActores("");
		this.setDescripcion("");
		this.setImagen(Serie.ERROR_IMAGE);
		this.temporadas = 0;
	}
    //Metodo especial para transformar Serie en Pelicula, en caso de que fuera necesario
    public Contenido toPelicula() {
    	Pelicula pelicula = null;
		try {
			pelicula = new Pelicula();
			pelicula.setIdPelicula(this.getIdPelicula());
	    	pelicula.setNombre(this.getNombre());
	        pelicula.setAnioProduccion(this.getAnioProduccion());
	        pelicula.setGenero(this.getGenero());
	        pelicula.setDirectores(this.getDirectores());
	        pelicula.setActores(this.getActores());
	        pelicula.setDescripcion(this.getDescripcion());
	        pelicula.setImagen(this.getImagen());
	        return pelicula;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return this;
		}
    }
    // GETTERs
    public int getTemporadas() {
		return temporadas;
	}
	// SETTERS
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
}

