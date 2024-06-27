package sph3;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static sph3.Principal.setStage;

/**
 *
 * @author 3040
 */

public class SPH3 extends Application {
    
    private static Stage stage; //Uma janela
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLLogin_1.fxml"));//Carrega FXMl
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.setTitle("Login");
        stage.setScene(scene);// Coloca a cena em um janela
        stage.show();// Abre a janela2
        setStage(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage stage){
        SPH3.stage = stage;
    }
    
}
