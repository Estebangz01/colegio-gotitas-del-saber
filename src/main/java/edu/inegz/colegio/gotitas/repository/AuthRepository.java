
package main.java.edu.inegz.colegio.gotitas.repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.java.edu.inegz.colegio.gotitas.config.DataBaseConnection;
import main.java.edu.inegz.colegio.gotitas.dto.request.LoginRequest;
import main.java.edu.inegz.colegio.gotitas.dto.response.LoginResponse;

public class AuthRepository {
    //atributos
    private boolean sqlStatus = false;
    //constructor
    
    /*
    los metodos: son acciones especificas
    son tareas individules, algunos metodos
    solo realizan una tarea, pero no retornan nada
    son "void", otros metodos, realizan tareas, 
    y retornan un tipo de dato primitivo o compuesto (Clase)
    de realizar unicamente una tarea especifica, el nombre de 
    ese metodo debe ser modular, directo
    */
    public LoginResponse findUserByEmail(LoginRequest loginRequest) throws Exception{
        String sql = "select d.nombre, d.apellido, u.contrasena_hash from usuarios as u" +
" right join docentes as d" +
" on d.id_docente = u.id_docente" +
" where email = ? ";
        try(PreparedStatement pstm = DataBaseConnection.getConnectionDataBase().prepareStatement(sql)){
            pstm.setString(1, loginRequest.getEmail());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                return new LoginResponse(rs.getString("nombre"), rs.getString("apellido"),rs.getString("contrasena_hash"));
            }
        }catch (Exception e){
            System.out.println("ERROR AL ENCONTRAR EL EMAIL"+ e.getMessage());
        }
        return null;
    }
                
    }
    
    
    
    
    
    

