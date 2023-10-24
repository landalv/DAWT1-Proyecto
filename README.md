# Proyecto de Películas y Series 🎬📺

¡Bienvenido al proyecto de Películas y Series! Este es un sistema de gestión de contenido audiovisual desarrollado en Java.

## Descripción

Este proyecto incluye tres paquetes principales: `modelo`, `vista`, y `controlador`.

## Estructura del Proyecto

- `src/`
  - `modelo/`: Contiene las clases relacionadas con el modelo.
  - `vista/`: Incluye las clases relacionadas con la interfaz gráfica.
  - `controlador/`: Contiene la lógica de control de la aplicación.
  - `Main.java`: Punto de entrada del programa.

## Inicio Rápido

1. Clona el repositorio.
2. Abre el proyecto en tu IDE preferido.
3. Ejecuta `Main.java` para iniciar la aplicación.

## Clases y Métodos Principales
### Clase `BBDD`

La clase `BBDD` gestiona la conexión y operaciones con la base de datos MySQL. Proporciona métodos para conectar y desconectar, así como para ejecutar consultas de inserción y selección.

#### Atributos

- `driver` (`String`): Ruta del controlador de MySQL.
- `connection` (`Connection`): Objeto que representa la conexión a la base de datos.
- `consulta` (`Statement`): Objeto para realizar consultas a la base de datos.
- `resultado` (`ResultSet`): Objeto que contiene los resultados de una consulta.
- `host` (`String`): Dirección del host de la base de datos.
- `port` (`int`): Puerto de conexión a la base de datos.
- `bd` (`String`): Nombre de la base de datos.
- `user` (`String`): Nombre de usuario para acceder a la base de datos.
- `passwd` (`String`): Contraseña para acceder a la base de datos.
- `SQLintert` (`String`): Consulta SQL para la inserción de contenido en la base de datos.
- `SQLselect` (`String`): Consulta SQL para la selección de contenido de la base de datos.

#### Constructores

- `public BBDD()`: Constructor sin argumentos que inicializa los valores predeterminados para la conexión a la base de datos local.

- `public BBDD(String host, int port, String bd, String user, String passwd)`: Constructor que permite especificar los parámetros de conexión a la base de datos.

#### Métodos

- `public boolean conectar()`: Intenta establecer una conexión a la base de datos. Retorna `true` si la conexión es exitosa, y `false` en caso contrario.
- `public boolean desconectar()`: Cierra la conexión a la base de datos. Retorna `true` si la desconexión es exitosa, y `false` en caso contrario.
- `public boolean insert(Contenido pelicula)`: Inserta una película o serie en la base de datos. Retorna `true` si la inserción es exitosa, y `false` en caso contrario.
- `public boolean insert(Serie serie)`: Sobrecarga del método `insert` para insertar una serie en la base de datos.
- `public Contenido select(int idPelicula) throws SQLException`: Realiza una consulta para obtener información de una película o serie por su ID. Retorna un objeto `Contenido` que representa la película o serie encontrada.
### Clase `VistaPeliculaYSerie`

La clase `VistaPeliculaYSerie` es una ventana de interfaz gráfica que muestra información sobre películas y series. Permite navegar entre diferentes contenidos y visualizar sus detalles.

#### Atributos

- `contentPane` (`JPanel`): Panel principal de la ventana.
- `alturaVentana`, `anchoVentana`, `xInit`, `yInit` (`int`): Dimensiones y posición inicial de la ventana.
- `logo` (`Image`): Imagen de logo.
- `title` (`String`): Título de la ventana.
- `pantalla`, `tamanoPantalla` (`Toolkit`, `Dimension`): Herramientas para obtener información sobre la pantalla.
- `contenido` (`Contenido`): Objeto que representa la película o serie a mostrar.
- `lblNombre`, `txtDescription`, `ImgContainer`, `lblTitle`, `ButtonsField`, `btnAnterior`, `btnSiguiente` (`JLabel`, `JTextArea`, `JButton`, `Box`): Componentes gráficos de la ventana.

#### Constructores

- `public VistaPeliculaYSerie()`: Constructor que crea una ventana con contenido predeterminado.
- `public VistaPeliculaYSerie(String title, String logoName)`: Constructor que permite especificar el título y el nombre del logo.
- `public VistaPeliculaYSerie(Contenido contenido)`: Constructor que inicializa la ventana con un contenido específico.

#### Métodos

- `private void setMarcoPelicula(String title, String logoName, int alturaVentana, int anchoVentana)`: Configura la ventana con el título, logo y dimensiones especificadas.
- `public void mostrarPelicula(Contenido contenido)`: Actualiza la información de la ventana con el contenido proporcionado.
- `public static String createDescription(Contenido contenido)`: Crea una descripción formateada del contenido.
- `public static JLabel createImgContainer(byte[] imagen, int width, int heigth)`: Crea un contenedor de imagen a partir de un arreglo de bytes.
- `public static JLabel createImgContainer(String url, int width, int heigth)`: Crea un contenedor de imagen a partir de una URL.
- `public static Icon createImg(byte[] imagen, int width, int heigth) throws IOException`: Crea un icono a partir de un arreglo de bytes.
- `public static Icon createImg(String url, int width, int heigth)`: Crea un icono a partir de una URL.
- `public static Icon obtenerIcono(Object entrada)`: Obtiene un icono a partir de una entrada (byte[], String o ruta de archivo).
- `public static Icon obtenerIcono(Object entrada, int width, int height)`: Obtiene un icono con dimensiones específicas a partir de una entrada.

- `public int getIdPeliculaActual()`: Obtiene el ID de la película actual.
- `public void mostrarMensajeError(String msg)`: Muestra un mensaje de error en la ventana.

##### Métodos Privados

- `private void setMarcoSerie(String title, String logoName, int alturaVentana, int anchoVentana)`: Configura la ventana específicamente para una serie (actualmente comentada).
### Clase `CtrlPeliculas`

La clase `CtrlPeliculas` es un controlador que gestiona la lógica de presentación para la visualización y navegación de películas.

#### Atributos

- `vista` (`VistaPeliculaYSerie`): Ventana de interfaz gráfica para mostrar las películas.
- `bbdd` (`BBDD`): Objeto para la conexión y operaciones con la base de datos.

#### Constructor

- `public CtrlPeliculas(VistaPeliculaYSerie vista, BBDD bbdd)`: Constructor que inicializa la vista y la base de datos. También agrega ActionListeners a los botones de la vista y carga la primera película.

#### Métodos

- `private void mostrarPeliculaConId(int id)`: Muestra una película específica con el ID proporcionado.
- `private void mostrarSiguientePelicula()`: Muestra la siguiente película en la secuencia.
- `private void mostrarAnteriorPelicula()`: Muestra la película anterior en la secuencia.

#### Métodos Privados

- `private void mostrarPeliculaConId(int id)`: Obtiene y muestra una película de la base de datos según su ID.
- `private void mostrarSiguientePelicula()`: Muestra la siguiente película en la secuencia.
- `private void mostrarAnteriorPelicula()`: Muestra la película anterior en la secuencia.
### Clase `Contenido`

La clase `Contenido` representa un elemento multimedia, como una película o una serie.

#### Atributos

- `idPelicula` (`int`): Identificador único de la película.
- `nombre` (`String`): Nombre del contenido.
- `anioProduccion` (`int`): Año de producción del contenido.
- `actores` (`String`): Lista de actores del contenido.
- `directores` (`String`): Lista de directores del contenido.
- `descripcion` (`String`): Descripción del contenido.
- `genero` (`String`): Género del contenido.
- `imagen` (`byte[]`): Representación de la imagen asociada al contenido en formato de arreglo de bytes.

#### Constante

- `ERROR_IMAGE` (`String`): URL de una imagen predeterminada en caso de que la descarga de la imagen falle.

#### Constructor

- `public Contenido(int idPelicula, String nombre, int anioProduccion, String genero, String directores, String actores, String descripcion, String urlImagen) throws IOException`: Constructor que inicializa los atributos con los valores proporcionados y descarga la imagen desde una URL.
- `public Contenido()`: Constructor predeterminado que inicializa los atributos con valores por defecto y descarga una imagen de error.

#### Métodos

- `private byte[] descargarImagen(String urlImagen) throws IOException`: Descarga una imagen desde una URL y la convierte en un arreglo de bytes.
- `public String toString()`: Retorna una representación en forma de cadena de caracteres del objeto.

#### Métodos Getter

- `public byte[] getImagen()`: Retorna el arreglo de bytes que representa la imagen asociada al contenido.
- `public String getNombre()`: Retorna el nombre del contenido.
- `public int getAnioProduccion()`: Retorna el año de producción del contenido.
- `public String getActores()`: Retorna la lista de actores del contenido.
- `public String getDirectores()`: Retorna la lista de directores del contenido.
- `public String getDescripcion()`: Retorna la descripción del contenido.
- `public String getGenero()`: Retorna el género del contenido.
- `public int getIdPelicula()`: Retorna el identificador único de la película.
- `public int getTemporadas()`: Retorna el número de temporadas del contenido (si es una serie).

#### Métodos Setter

- `public void setImagen(String nuevaImagen)`: Establece una nueva imagen a partir de una URL.
- `public void setImagen(byte[] imagen)`: Establece la imagen a partir de un arreglo de bytes.
- `public void setNombre(String nombre)`: Establece el nombre del contenido.
- `public void setAnioProduccion(int anioProduccion)`: Establece el año de producción del contenido.
- `public void setActores(String actores)`: Establece la lista de actores del contenido.
- `public void setDirectores(String directores)`: Establece la lista de directores del contenido.
- `public void setDescripcion(String descripcion)`: Establece la descripción del contenido.
- `public void setGenero(String genero)`: Establece el género del contenido.
- `public void setIdPelicula(int idPelicula)`: Establece el identificador único de la película.
- `public void setTemporadas(int temporadas)`: Establece el número de temporadas del contenido (si es una serie).
### Clase `Serie`

#### Hereda de: `Contenido`

#### Atributos adicionales:

- `int temporadas`: Número de temporadas de la serie.

#### Constructores:

- `public Serie(int id, String titulo, String descripcion, int duracion, int temporadas, String genero)`: Constructor de la clase Serie.

#### Métodos adicionales:
Lo unico que añade la clase `Serie` con respecto a `Contenido` son las temporadas que esta tiene y sobreescribe los metodos getter y setter del atributo.
### Clase `Pelicula`

#### Hereda de: `Contenido`

Esta clase `Pelicula` no añade ninguna modificación con respecto a `Contenido`, pero nos sirve para modularizar, el tipo de contenido con el que estamos trabajando.
