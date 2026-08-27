package main.java.edu.inegz.colegio.gotitas.service;

import main.java.edu.inegz.colegio.gotitas.dto.request.LoginRequest;
import main.java.edu.inegz.colegio.gotitas.dto.response.LoginResponse;
import main.java.edu.inegz.colegio.gotitas.repository.AuthRepository;
import org.mindrot.jbcrypt.BCrypt;


public class AuthService {
    //atributos
    private AuthRepository authRepository;
    private boolean status = false;
    //constructor
    public AuthService (AuthRepository authRepository){
        this.authRepository = authRepository;
    }
   public LoginResponse login(LoginRequest loginRequest) throws Exception{
       if(loginRequest == null){
           throw new RuntimeException("Credenciales vacias.");
       }else if(loginRequest.getEmail() == null || loginRequest.getPassword() == null){
           throw new RuntimeException("el correo o la contraseña no puede estar vacios.");
       }
       LoginResponse response = authRepository.findUserByEmail(loginRequest);
       if(response == null){
           throw new RuntimeException("Usuario no encontrado");
       }
       
       String contrasenaHashed = response.getContrasena_hash();
       
       if(contrasenaHashed == null){
           throw new RuntimeException("contrasena no valida");
           
       }else{
           if(BCrypt.checkpw(loginRequest.getPassword(), contrasenaHashed)){
               return response;
           }
       }
       return null;
   }
    
    
}

