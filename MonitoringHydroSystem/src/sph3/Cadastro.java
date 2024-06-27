package sph3;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Cadastro {

    private static Stage stage; //Uma janela
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        launch(args);
    }
    
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Cadastro.fxml"));//Carrega FXMl
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.setTitle("Cadastro");
        stage.setScene(scene);// Coloca a cena em um janela
        stage.show();// Abre a janela2
        setStage(stage);
    }
    
    public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage stage){
        Cadastro.stage = stage;
    }
    
}
