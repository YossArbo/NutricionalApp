package nutricionalappfx.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {
    
    private static final Properties propiedades = new Properties(); 
    //Al no ser una clase instanciable no se construyen los atributos del objeto, estatic construye en memoria los datos al crearse
    static { //alternativa == crear un método publico 'public void cargarDtos()'
        //Cargar los datos del database.properties UNA UNICA VEZ
        try {
            InputStream input = ConexionBD.class.getResourceAsStream("database.properties");
            if(input == null) {
                throw new RuntimeException("No se encontro el archivo database.properties");
            }
            propiedades.load(input);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection obtenerConexion()throws SQLException{
        try {
            Class.forName(propiedades.getProperty("db.driver"));
            return DriverManager.getConnection(
                propiedades.getProperty("db.url"),
                propiedades.getProperty("db.user"),
                propiedades.getProperty("db.password")
            );
        } catch(ClassNotFoundException e) {
             throw new SQLException("No se encontró el driver de MySQL:" + e.getMessage());
        }
    }
}
