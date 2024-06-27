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

public class Consultas {

    private static Stage stage; //Uma janela
    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
     public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Consultas.fxml"));//Carrega FXMl
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.setTitle("Consultas");
        stage.setScene(scene);// Coloca a cena em um janela
        stage.show();// Abre a janela3
        setStage(stage);
    }
    
    public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage stage){
        Consultas.stage = stage;
    }
    
}
