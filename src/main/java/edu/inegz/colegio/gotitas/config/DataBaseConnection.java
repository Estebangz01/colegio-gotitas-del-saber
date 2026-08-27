
package main.java.edu.inegz.colegio.gotitas.config;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    //atributos
    private static Connection connection;
     
    /*
    el contructor tiene que ser privado, esto para evitar que
    se crreen instancias de esta clase
    */
    private DataBaseConnection(){}
    
    //metodo
    public static Connection getConnectionDataBase()throws Exception{
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(Credentials.URL_DB, Credentials.USER_DB, Credentials.PASS_DB);
            
        }
        return connection;
    }
    
    
}
