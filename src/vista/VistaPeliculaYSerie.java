package vista;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Contenido;
import modelo.Serie;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.JScrollPane;

public class VistaPeliculaYSerie extends JFrame {
	//ATRIBUTOS
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int alturaVentana, anchoVentana, xInit, yInit;
	private Image logo; 
	private String title;
	final private Toolkit pantalla = Toolkit.getDefaultToolkit();
	final private Dimension tamanoPantalla = pantalla.getScreenSize();
	private Contenido contenido;
	private JLabel lblNombre;
	private JTextArea txtDescription;
	private JLabel ImgContainer;
	private JLabel lblTitle;
	private Box ButtonsField;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPeliculaYSerie frame = new VistaPeliculaYSerie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public VistaPeliculaYSerie() {
		//setAlwaysOnTop(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 690, 464);
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		try {
			this.contenido = new Contenido(0,"", 0, "", "", "", "", "https://static.vecteezy.com/system/resources/previews/005/337/799/non_2x/icon-image-not-found-free-vector.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setMarcoPelicula("Carlos Landa Vazquez", "logo.jpg", alturaPantalla/2, anchoPantalla/2);
		setVisible(true);
	}
	public VistaPeliculaYSerie(String title, String logoName) {
		//setAlwaysOnTop(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 690, 464);
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		try {
			this.contenido = new Contenido(0,"", 0, "", "", "", "", "https://static.vecteezy.com/system/resources/previews/005/337/799/non_2x/icon-image-not-found-free-vector.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setMarcoPelicula(title, logoName, alturaPantalla/2, anchoPantalla/2);
		setVisible(true);
	}
	public VistaPeliculaYSerie(Contenido contenido){
		//setAlwaysOnTop(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 690, 464);
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		this.contenido = contenido;
		this.setMarcoPelicula("Carlos Landa Vazquez", "logo.jpg", alturaPantalla/2, anchoPantalla/2);
		setVisible(true);
	}
	
	//Constructores universal
	
	private void setMarcoPelicula(String title, String logoName, int alturaVentana, int anchoVentana) {
		this.title = title;
		this.logo = pantalla.getImage("src/vista/"+logoName);
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		this.alturaVentana = alturaVentana;
		this.anchoVentana = anchoVentana;
		this.xInit = (alturaPantalla/2)-(this.alturaVentana/2);
		this.yInit = (anchoPantalla/2)-(this.anchoVentana/2);
		
		this.setSize(anchoVentana,alturaVentana);
		this.setLocation(this.yInit, this.xInit);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setIconImage(logo);
		
		//Añadimos la distribución de laminas
		//Creamos Lamina
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.window);
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		//Titulo
		lblTitle = new JLabel("Peliculas y Series");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, BorderLayout.NORTH);
		//Campo Botone
		ButtonsField = Box.createHorizontalBox();
		contentPane.add(ButtonsField, BorderLayout.SOUTH);
		
		btnAnterior = new JButton("Anterior");
		ButtonsField.add(btnAnterior);
		
		Component glue = Box.createGlue();
		ButtonsField.add(glue);
		
		btnSiguiente = new JButton("Siguiente");
		ButtonsField.add(btnSiguiente);
		//Campo de Info del Contenido
		Box InfoField = Box.createHorizontalBox();
		InfoField.setBorder(new EmptyBorder(25, 25, 25, 25));
		contentPane.add(InfoField, BorderLayout.CENTER);
		//Imagen
		ImgContainer = new JLabel();
		try {
			ImgContainer = createImgContainer(this.contenido.getImagen(), (anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth()));
		}catch (Exception e) {
			e.printStackTrace();
			ImgContainer = createImgContainer("src/view/imagenNoDisponible.png", (anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth()));
		}
		ImgContainer.setToolTipText("Cartel");
		ImgContainer.setHorizontalAlignment(SwingConstants.CENTER);
		ImgContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		InfoField.add(ImgContainer);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setEnabled(false);
		InfoField.add(horizontalStrut);
		
		Component glue_1 = Box.createGlue();
		InfoField.add(glue_1);
		//A la derecha el nombre + Descripcion con datos
		Box verticalBox = Box.createVerticalBox();
		InfoField.add(verticalBox);
		
		lblNombre = new JLabel(this.contenido.getNombre());
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		verticalBox.add(lblNombre);
		
		txtDescription = new JTextArea((anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth()));
		txtDescription.setLineWrap(true);
		verticalBox.add(txtDescription);
		JScrollPane scrollPane = new JScrollPane(txtDescription, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		verticalBox.add(scrollPane);
		txtDescription.setText(createDescription(this.contenido));
		
		
	}
	public void mostrarPelicula(Contenido contenido) {
		this.contenido = contenido;
		System.out.println("Mostrando Contenido --> "+contenido.toString());
	    // Actualizar la información en la interfaz gráfica
	    lblNombre.setText(contenido.getNombre());
	    System.out.println("Actualizando Descripción: \n" + lblNombre.getText());
	    txtDescription.setText(createDescription(contenido));
	    System.out.println("Actualizando nombre: " + txtDescription.getText());
	    
	    // Actualizar la imagen
	    try {
	        ImgContainer.setIcon(createImg(contenido.getImagen(), (anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth())));
	    } catch (Exception e) {
	        e.printStackTrace();
	        ImgContainer.setIcon(createImg("src/view/imagenNoDisponible.png", (anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth())));
	    }
	    
	    // Otras actualizaciones que puedan ser necesarias
	}
	
	/*private void setMarcoSerie(String title, String logoName, int alturaVentana, int anchoVentana) {
		this.title = title;
		this.logo = pantalla.getImage("src/vista/"+logoName);
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		this.alturaVentana = alturaVentana;
		this.anchoVentana = anchoVentana;
		this.xInit = (alturaPantalla/2)-(this.alturaVentana/2);
		this.yInit = (anchoPantalla/2)-(this.anchoVentana/2);
		
		this.setSize(anchoVentana,alturaVentana);
		this.setLocation(this.yInit, this.xInit);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setIconImage(logo);
		
		//Añadimos la distribución de laminas
		//Creamos Lamina
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.window);
		this.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JLabel lblTitle = new JLabel("Peliculas y Series");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		Box ButtonsField = Box.createHorizontalBox();
		contentPane.add(ButtonsField, BorderLayout.SOUTH);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonsField.add(btnAnterior);
		
		Component glue = Box.createGlue();
		ButtonsField.add(glue);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonsField.add(btnSiguiente);
		
		Box InfoField = Box.createHorizontalBox();
		InfoField.setBorder(new EmptyBorder(25, 25, 25, 25));
		contentPane.add(InfoField, BorderLayout.CENTER);
		
		JLabel ImgContainer = new JLabel();
		try {
			ImgContainer = createImgContainer(this.serie.getImagen(), (anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth()));
		}catch (Exception e) {
			e.printStackTrace();
			ImgContainer = createImgContainer("src/view/imagenNoDisponible.png", (anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth()));
		}
		ImgContainer.setToolTipText("Cartel");
		ImgContainer.setHorizontalAlignment(SwingConstants.CENTER);
		ImgContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		InfoField.add(ImgContainer);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setEnabled(false);
		InfoField.add(horizontalStrut);
		
		Component glue_1 = Box.createGlue();
		InfoField.add(glue_1);
		
		Box verticalBox = Box.createVerticalBox();
		InfoField.add(verticalBox);
		
		JLabel lblNombre = new JLabel(this.serie.getNombre());
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		verticalBox.add(lblNombre);
		
		JTextArea txtDescription = new JTextArea((anchoVentana/3)-60, alturaVentana-(lblTitle.getWidth()+ButtonsField.getWidth()));
		txtDescription.setLineWrap(true);
		verticalBox.add(txtDescription);
		JScrollPane scrollPane = new JScrollPane(txtDescription, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		verticalBox.add(scrollPane);
		txtDescription.setText(createDescription(this.serie));
		
		
	}*/

	public static String createDescription(Contenido contenido) {
		String description = new String(); 
		
		String anio = Integer.toString(contenido.getAnioProduccion());
		description += "Año: ";
		description += anio;
		description += "\n";

		String genero = contenido.getGenero();
		description += "Genero: ";
		description += genero;
		description += "\n";
		
		String directores = contenido.getDirectores();
		description +="Director/es: ";
		description += directores;
		description += "\n";
		
		String actores = contenido.getActores();
		description +="Actor/es: ";
		description += actores;
		description += "\n";
		
		// Si es una Serie, agregar el número de temporadas
	    if (contenido instanceof Serie) {
	        Serie serie = (Serie) contenido;
	        String temporadas = Integer.toString(serie.getTemporadas());
	        description += "Nº Temporadas: ";
	        description += temporadas;
	        description += "\n";
	    }
		
		description += "Descripción: ";
		description += contenido.getDescripcion();
		description += "\n";
		return description;
	}
	public static JLabel createImgContainer(byte[] imagen, int width, int heigth) {
		//version con byte[]
		try {
			BufferedImage bufferedImage = null;
			InputStream inputStream = new ByteArrayInputStream(imagen);
			bufferedImage = ImageIO.read(inputStream);
			ImageIcon myIcon = new ImageIcon(bufferedImage.getScaledInstance(width, heigth, 0)); 
			JLabel imgContainer = new JLabel();
			imgContainer.setBounds(0, 0, width, heigth);
			imgContainer.setIcon(new ImageIcon(myIcon.getImage().getScaledInstance(imgContainer.getWidth(), imgContainer.getHeight(), Image.SCALE_SMOOTH)));
			return imgContainer;
		}catch (Exception e) {
			JLabel imgContainer = new JLabel();
			imgContainer.setBounds(0, 0, width, heigth);
			imgContainer.setText("No imagen");
			return imgContainer;
		}
	}
	public static JLabel createImgContainer(String url, int width, int heigth) {
		//version sin byte[]
		try {
			ImageIcon imagen = new ImageIcon (url);
			JLabel imgContainer = new JLabel();
			imgContainer.setBounds(0, 0, width, heigth);
			imgContainer.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imgContainer.getWidth(), imgContainer.getHeight(), Image.SCALE_SMOOTH)));
			return imgContainer;
		}catch (Exception e) {
			JLabel imgContainer = new JLabel();
			imgContainer.setBounds(0, 0, width, heigth);
			imgContainer.setText("No imagen");
			return imgContainer;
		}
	}
	public static Icon createImg(byte[] imagen, int width, int heigth) throws IOException {
	//version con byte[]
		BufferedImage bufferedImage = null;
		InputStream inputStream = new ByteArrayInputStream(imagen);
		bufferedImage = ImageIO.read(inputStream);
		ImageIcon myIcon = new ImageIcon(bufferedImage.getScaledInstance(width, heigth, 0)); 
		JLabel imgContainer = new JLabel();
		imgContainer.setBounds(0, 0, width, heigth);
		return new ImageIcon(myIcon.getImage().getScaledInstance(imgContainer.getWidth(), imgContainer.getHeight(), Image.SCALE_SMOOTH));
	}
	public static Icon createImg(String url, int width, int heigth) {
		//version sin byte[]
		ImageIcon imagen = new ImageIcon (url);
		JLabel imgContainer = new JLabel();
		imgContainer.setBounds(0, 0, width, heigth);
		imgContainer.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imgContainer.getWidth(), imgContainer.getHeight(), Image.SCALE_SMOOTH)));
		return new ImageIcon(imagen.getImage().getScaledInstance(imgContainer.getWidth(), imgContainer.getHeight(), Image.SCALE_SMOOTH));
	}
	public static Icon obtenerIcono(Object entrada) {
        ImageIcon icono = null;

        if (entrada instanceof byte[]) {
            // Si la entrada es un arreglo de bytes (byte[])
            byte[] bytes = (byte[]) entrada;
            icono = new ImageIcon(bytes);
        } else if (entrada instanceof String) {
            // Si la entrada es una URL como String
            String urlStr = (String) entrada;
            try {
                URL url = new URL(urlStr);
                icono = new ImageIcon(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (entrada instanceof String) {
            // Si la entrada es una ruta de archivo
            String rutaArchivo = (String) entrada;
            icono = new ImageIcon(rutaArchivo);
        }

        return icono;
    }
	public static Icon obtenerIcono(Object entrada, int width, int height) {
        ImageIcon icono = null;

        if (entrada instanceof byte[]) {
            byte[] bytes = (byte[]) entrada;
            Image img = new ImageIcon(bytes).getImage();
            Image nuevaImagen = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icono = new ImageIcon(nuevaImagen);
        } else if (entrada instanceof String) {
            String urlStr = (String) entrada;
            try {
                URL url = new URL(urlStr);
                Image img = ImageIO.read(url);
                Image nuevaImagen = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                icono = new ImageIcon(nuevaImagen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (entrada instanceof String) {
            String rutaArchivo = (String) entrada;
            Image img = new ImageIcon(rutaArchivo).getImage();
            Image nuevaImagen = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icono = new ImageIcon(nuevaImagen);
        }

        return icono;
    }
	public int getIdPeliculaActual() {
		return this.contenido.getIdPelicula();
	}
	public void mostrarMensajeError(String msg) {
		JOptionPane.showMessageDialog(contentPane, msg, "¡¡¡ERROR!!!", JOptionPane.ERROR_MESSAGE);
	}
	// GETTERS Botones

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	
}
