/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import sph3.Consultas;
import sph3.Principal;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sph3.Perfil;

/**
 * FXML Controller class
 *
 * @author 3040
 */
public class ConsultasController implements Initializable {
    
    @FXML private Button btnConsultaC;

    @FXML private Button btnInicioC;

    @FXML private Button btnPerfilC;
    
    @FXML private Button btnLogout;

    @FXML private AnchorPane panelMenu;
    
    @FXML private AreaChart<?, ?> chartAno;

    @FXML private AreaChart<?, ?> chartDia;

    @FXML private AreaChart<?, ?> chartMes;

    @FXML private AreaChart<?, ?> chartSemana;
    
    @FXML private TextField txtCódigo;

    @FXML private TextField txtNomeEdifcio;

    @FXML private TextField txtNomePerfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnConsultaC.setOnMouseClicked((MouseEvent e) -> {
            Consultas c = new Consultas();
            fecha();
            try {
                c.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex); 
                JOptionPane.showMessageDialog(null, "ConsultasController btnConsultaC.setOnMouseClicked()"+ex);
                
            }
        });
        
        btnInicioC.setOnMouseClicked((MouseEvent e) -> {
             Principal p = new Principal();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ConsultasController btnInicioC.setOnMouseClicked()"+ex);
            }
        });
        
        btnPerfilC.setOnMouseClicked((MouseEvent e) -> {
        Perfil p = new Perfil();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ConsultasController btnPerfilC.setOnMouseClicked()"+ex);
            }
        });
                
            
    }    
    
    private void fecha(){
        Consultas.getStage().close();
    }
}
