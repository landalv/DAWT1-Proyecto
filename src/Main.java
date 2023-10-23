import modelo.*;
import vista.*;

import java.io.IOException;

import controlador.*;

public class Main {

	public static void main(String[] args) {
		Pelicula spidermanFFH, bladeRunner;
		Serie upload;
		
		///*creamos unas cuantas entradas para la BBDDs
				int id = 1;
				String nombre = "Spider-Man: Far from Home";
				int anio = 2019;
				int temporadas = 0;
				String genero = "acción";
				String directores = "Jon Watts";
				String actores = "Tom Holland,Samuel L. Jackson,Jake Gyllenhaal,Marisa Tomei,Jon Favreau,Zendaya";
				String descripcion = "Peter Parker decide irse junto a MJ, Ned y el resto de sus amigos a pasar unas vacaciones a Europa. Sin embargo, el plan de Parker por dejar de lado sus superpoderes durante unas semanas se ven truncados cuando Nick Fury contacta con él para solicitarle ayuda para frenar el ataque de unas criaturas elementales que están causando el caos en el continente. En ese momento, Parker vuelve a ponerse el traje de Spider-Man para cumplir con su labor.";
				String imagen = "https://pics.filmaffinity.com/spider_man_far_from_home-339542528-large.jpg";
		try {
			spidermanFFH = new Pelicula(id,nombre,anio,genero,directores,actores,descripcion,imagen);
			System.out.println ("Spiderman: "+spidermanFFH.toString());
			insetarContenido(spidermanFFH);
			id = 2;
			nombre = "Blade Runner 2049";
			anio = 2017;
			temporadas = 0;
			genero = "Ciencia ficción | Cyberpunk";
			directores = "Denis Villeneuve";
			actores = "Ryan Gosling, Harrison Ford, Ana de Armas, Jared Leto";
			descripcion = "Treinta años después de los eventos del primer film, un nuevo blade runner, K (Ryan Gosling) descubre un secreto profundamente oculto que podría acabar con el caos que impera en la sociedad. El descubrimiento de K le lleva a iniciar la búsqueda de Rick Deckard (Harrison Ford), un blade runner al que se le perdió la pista hace 30 años. (FILMAFFINITY)";
			imagen = "https://pics.filmaffinity.com/blade_runner_2049-681477614-mmed.jpg";
			bladeRunner = new Pelicula(id,nombre,anio,genero,directores,actores,descripcion,imagen);
			System.out.println ("Spiderman: "+bladeRunner.toString());
			insetarContenido(bladeRunner);
			id = 3;
			nombre = "Upload";
			anio = 2020;
			temporadas = 3;
			genero = "Ciencia ficción| Internet / Informática";
			directores = "Greg Daniels (Creador), Jeffrey Blitz";
			actores = "Robbie Amell, Andy Allo, Chris Williams, Kevin Bigley";
			descripcion = "Serie de TV (2020-). 3 temporadas. Ambientada en un futuro en el que los seres humanos son capaces de transferirse a la otra vida que prefieran. Cuando Nathan muere prematuramente, es recibido por Nora en su versión del cielo. Nathan se acostumbra a la vida lejos de sus seres queridos y Nora lucha por mantenerse a flote trabajando junto a Nathan en el más allá. (FILMAFFINITY)";
			imagen = "https://pics.filmaffinity.com/upload-810637910-mmed.jpg";
			upload = new Serie(id,nombre,anio,genero,directores,actores,descripcion,imagen,temporadas);
			System.out.println ("Spiderman: "+upload.toString());
			insetarContenido(upload);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//*/
		
		//Iniciamos el programa		
		BBDD bbdd = new BBDD(); // Puedes personalizar los parámetros según tus necesidades
        VistaPeliculaYSerie vista = new VistaPeliculaYSerie("DAW_T1_Practica","logo.jpg");
        CtrlPeliculas controlador = new CtrlPeliculas(vista, bbdd);		
				
		
	}
	public static void insetarContenido(Contenido contenido) {
		BBDD insert = new BBDD();
		insert.conectar();
		boolean resultInsert = insert.insert(contenido);
		System.out.println("Inserción "+resultInsert+" de -->"+contenido.toString());
		
	}
}
