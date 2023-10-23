package modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class BBDD {
	//ATRIBUTOS
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static Connection connection;
	private static Statement consulta;
	private static ResultSet resultado;
	
	private static String host;
	private static int port;
	private static String bd;
	private static String user;
	private static String passwd;
	
	private static final String SQLintert = "INSERT INTO peliculas "
			+ "(nombrePelicula, generoPelicula, actoresPelicula, directoresPelicula, anioPelicula, temporadasPelicula, descripcionPelicula, ImagenPelicula)"
			+ "VALUES (?,?,?,?,?,?,?,?)";
	
	private static final String SQLselect = "SELECT * FROM peliculas WHERE idPelicula =?";
	
	//CONSTUCTOR
	public BBDD() {
		this.bd = "test";
		this.user = "root";
		this.passwd = "";
		this.host = "localhost";
		this.port = 3306;
	}
	public BBDD(String host, int port, String bd, String user, String passwd) {
		this.bd = bd;
		this.user = user;
		this.passwd = passwd;
		this.host = host;
		this.port = port;
	}
	
	//CONECTAR
	public boolean conectar() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(
					"jdbc:mysql://"+host+":"+Integer.toString(port)+"/"+bd, user, passwd);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	//DESCONECTAR
	public boolean desconectar() {
		try {
			this.connection.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	//QUERYs
	public boolean insert (Contenido pelicula) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SQLintert);
			ps.setString(1, pelicula.getNombre());
			ps.setString(2, pelicula.getGenero());
			ps.setString(3, pelicula.getActores());
			ps.setString(4, pelicula.getDirectores());
			ps.setInt(5, pelicula.getAnioProduccion());
			if (pelicula instanceof Serie) {
				ps.setInt(6, pelicula.getTemporadas());
			}else {
				ps.setNull(6, Types.INTEGER);
			}
			ps.setString(7, pelicula.getDescripcion());
			ps.setBytes(8, pelicula.getImagen());
			//ps.setString(8, pelicula.getImagen());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean insert(Serie serie) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(SQLintert);
			ps.setString(1, serie.getNombre());
			ps.setString(2, serie.getGenero());
			ps.setString(3, serie.getActores());
			ps.setString(4, serie.getDirectores());
			ps.setInt(5, serie.getAnioProduccion());
			
			ps.setString(7, serie.getDescripcion());
			ps.setBytes(8, serie.getImagen());
			//ps.setString(8, serie.getImagen());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Contenido select(int idPelicula) throws SQLException {
		PreparedStatement ps = null;
		Serie pelicula = new Serie();
		try {
			ps=connection.prepareStatement(SQLselect);
			ps.setInt(1, idPelicula); //para añadir el WHERE
			resultado = ps.executeQuery();
			
			if(resultado.next()) {
				pelicula.setIdPelicula(Integer.parseInt(resultado.getString("idPelicula")));
				pelicula.setNombre(resultado.getString("nombrePelicula"));
				pelicula.setGenero(resultado.getString("generoPelicula"));
				pelicula.setActores(resultado.getString("actoresPelicula"));
				pelicula.setDirectores(resultado.getString("directoresPelicula"));
				pelicula.setAnioProduccion(Integer.parseInt(resultado.getString("anioPelicula")));
				pelicula.setDescripcion(resultado.getString("descripcionPelicula"));
				pelicula.setImagen(resultado.getBytes("imagenPelicula"));
				if (resultado.getString("temporadasPelicula")!=null) {
					pelicula.setTemporadas(Integer.parseUnsignedInt(resultado.getString("temporadasPelicula")));
				}
				System.out.println("Importado de BBDD: "+pelicula.toString());
			}
			if(pelicula.getNombre().equals("")) {
				pelicula = null;
			}
		} catch (SQLException e) {
			System.out.print("Queryfallida: "+ps.toString());
			e.printStackTrace();
			
			pelicula = null;
		}finally {
			if(ps!=null){
				ps.close();
			}else{
				return null;
			}
			if ( pelicula != null) {
				if(pelicula.getTemporadas()==0) {
					return pelicula.toPelicula();
				}
				return pelicula;
			}else{
				return pelicula;
			}
		}
		
		
	}
}
