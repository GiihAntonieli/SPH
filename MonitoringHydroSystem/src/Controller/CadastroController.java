package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import DTO.Edificio;
import DAO.EdificioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sph3.Cadastro;
import sph3.Principal;
import sph3.SPH3;

/**
 * FXML Controller class
 *
 * @author 3040
 */
public class CadastroController implements Initializable {
    
    @FXML private Button btnCadastrar;
    
    @FXML private Button btnVoltar;

    @FXML private TextField txtEmail;

    @FXML private TextField txtEndereco;

    @FXML private TextField txtNomeEdificio;

    @FXML private TextField txtNomeUsuario;

    @FXML private TextField txtSenha;

    @FXML void Cadastrar(ActionEvent event) {
        cadastrarEdificio();
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnCadastrar.setOnMouseClicked((MouseEvent e) -> {
            cadastrarEdificio();
            JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!");
                
        });
        btnCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.ENTER){
                cadastrarEdificio();
                JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!");
                
            }
        });
        
        btnVoltar.setOnMouseClicked((MouseEvent d) -> {
            SPH3 l  = new SPH3();
            fecha();
            try {
                l.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "CadastroController btnCadastrar.setOnKeyPressed()"+ex);
            }
        });
    }    
    
    private void cadastrarEdificio(){
        String nomeEdificio, endereco, nomeUsuario, email, senha;
        
        nomeEdificio = txtNomeEdificio.getText();
        endereco = txtEndereco.getText();
        nomeUsuario = txtNomeUsuario.getText();
        email = txtEmail.getText();
        senha = txtSenha.getText();
        
        Edificio e = new Edificio();
        e.setNome_ed(nomeEdificio);
        e.setEndereco(endereco);
        e.setNome_user(nomeUsuario);
        e.setEmail(email);
        e.setSenha(senha);
        
        EdificioDAO edao = new EdificioDAO();
        edao.inserirEdificio(e);
        
        JOptionPane.showMessageDialog(null,"Código do seu Edificio é"+ e.getId_edificio());
    }
    
    
    private void fecha(){
        Cadastro.getStage().close();
    }
}
