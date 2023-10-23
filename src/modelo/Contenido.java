package modelo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Contenido {

    // Atributos
	private int idPelicula;
    private String nombre;
    private int anioProduccion;
    private String actores;
    private String directores;
    private String descripcion;
    private String genero;
    private byte[] imagen;
    public static String ERROR_IMAGE = "https://static.vecteezy.com/system/resources/previews/005/337/799/non_2x/icon-image-not-found-free-vector.jpg";

    // Constructor que acepta una URL de imagen
    public Contenido(int idPelicula, String nombre, int anioProduccion, String genero, String directores, String actores,
                    String descripcion, String urlImagen) throws IOException {
        this.idPelicula = idPelicula;
    	this.nombre = nombre;
        this.anioProduccion = anioProduccion;
        this.actores = actores;
        this.directores = directores;
        this.descripcion = descripcion;
        this.genero = genero;
        this.imagen = descargarImagen(urlImagen);
    }
    public Contenido() {
		this.idPelicula = 0;
		this.nombre = "";
		this.anioProduccion = 0;
		this.actores = "";
		this.directores = "";
		this.descripcion = "";
		this.genero = "";
		try {
			this.imagen = descargarImagen(Contenido.ERROR_IMAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    // Método para descargar una imagen de una URL y convertirla a byte[]
    private byte[] descargarImagen(String urlImagen) throws IOException {
        URL url = new URL(urlImagen);
        InputStream stream = url.openStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
	public String toString() {
		return "Pelicula "+"[id=" + idPelicula +", name=" + nombre + ", genero=" + genero + ", actores=" + actores
				+ ", directores=" + directores + ", anioProduccion=" + anioProduccion + ", Imagen=" + imagen.length + ", descripcion=" + descripcion + "]";
	}
    
    // GETTERs
    public byte[] getImagen() {
        return imagen;
    }
    public String getNombre() {
		return nombre;
	}
	public int getAnioProduccion() {
		return anioProduccion;
	}
	public String getActores() {
		return actores;
	}
	public String getDirectores() {
		return directores;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getGenero() {
		return genero;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public int getTemporadas() {
		return 0;
	}
	// SEETTERS
    public void setImagen(String nuevaImagen) {
        try {
			this.imagen = descargarImagen(nuevaImagen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAnioProduccion(int anioProduccion) {
		this.anioProduccion = anioProduccion;
	}
	public void setActores(String actores) {
		this.actores = actores;
	}
	public void setDirectores(String directores) {
		this.directores = directores;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public void setTemporadas(int temporadas) {
		
	}
}

