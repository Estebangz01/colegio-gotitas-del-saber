package main.java.edu.inegz.colegio.gotitas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.java.edu.inegz.colegio.gotitas.config.DataBaseConnection;
import main.java.edu.inegz.colegio.gotitas.service.AuthService;
import main.java.edu.inegz.colegio.gotitas.util.SceneManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import main.java.edu.inegz.colegio.gotitas.dto.request.LoginRequest;
import main.java.edu.inegz.colegio.gotitas.dto.response.LoginResponse;


public class LoginController implements Initializable {
    //atributos
    private final AuthService authService;
    private final SceneManager sceneManager;
        

    @FXML
    private TextField txtFieldPass;
    @FXML
    private TextField txtFieldEmail;
    
    //
    public LoginController (AuthService authService, SceneManager sceneManager){
        this.authService = authService;
        this.sceneManager = sceneManager;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TODO LO QUE ESTE ACA, SE EJECUTA CAUNDO SE MUESTRA LA VISTA");
    } 
    
    
    
        
    public void handleLogin() throws Exception{
     if(txtFieldEmail.getText().isEmpty() || txtFieldPass.getText().isEmpty()) {
        sceneManager.showInfoAlert("campos informacion", "Revisar informacion", "Uno o mas campos vacios", Alert.AlertType.INFORMATION);
     } else{
         try{
             LoginResponse responseService = authService.login(new LoginRequest(txtFieldEmail.getText(), txtFieldPass.getText()));
         LoginResponse userLogged = new LoginResponse(responseService.getNombre(), responseService.getApellido());
        sceneManager.showInfoAlert("Bienvenido a Gotitas del saber", "inicio exitoso", "Bienvenido" + userLogged.getNombre(), Alert.AlertType.INFORMATION);
        
     }catch(RuntimeException e){
             sceneManager.showInfoAlert("Datos incorrectos", "Revise tu informacion", "Intenta de nuevo", Alert.AlertType.INFORMATION);
             }
         }
         
    }
        
}
        

        
        
          

