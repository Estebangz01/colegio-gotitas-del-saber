
package main.java.edu.inegz.colegio.gotitas;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.edu.inegz.colegio.gotitas.config.DataBaseConnection;
import main.java.edu.inegz.colegio.gotitas.util.SceneManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MainApp extends Application{
      
    private Stage primaryStage;
   
    @Override
    public void start (Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.showLoginView();
        primaryStage.show();
        
    }
    
    
    public static void main(String[] args) throws Exception {
      launch();
    }
    
}
