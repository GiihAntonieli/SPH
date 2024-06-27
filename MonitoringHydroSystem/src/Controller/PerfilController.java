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
import sph3.Perfil;
import sph3.Principal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sph3.Consultas;
import DTO.Edificio;
import DAO.EdificioDAO;

/**
 * FXML Controller class
 *
 * @author 3040
 */
public class PerfilController implements Initializable {
    
    @FXML private Button btnConsulta;

    @FXML private Button btnInicio;

    @FXML private Button btnPerfil;
    
    @FXML private Button btnLogout;

    @FXML private AnchorPane panelMenu;
    
    @FXML private Button btnSalvar;
    
    @FXML private TextField txtCodigo;

    @FXML private TextField txtEmail;

    @FXML private TextField txtEndereco;

    @FXML private TextField txtNomeEdificio;

    @FXML private TextField txtNomeUsuario;

    @FXML private TextField txtSenha;
    
    @FXML private TextField txtCodigoE;
    
    @FXML private TextField txtNomeEd;
    
    @FXML private TextField txtNomePerfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnConsulta.setOnMouseClicked((MouseEvent e) -> {
            Consultas c = new Consultas();
            fecha();
            try {
                c.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex); 
                JOptionPane.showMessageDialog(null, "PerfilController btnConsulta.setOnMouseClicked()"+ex);
                
            }
        });
        
        btnInicio.setOnMouseClicked((MouseEvent e) -> {
            Principal p = new Principal();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PerfilController btnInicio.setOnMouseClicked()"+ex);
            }
        });
        
        btnPerfil.setOnMouseClicked((MouseEvent e) -> {
            Perfil p = new Perfil();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PerfilController btnPerfil.setOnMouseClicked()"+ex);
            }
        });
        
        btnSalvar.setOnMouseClicked((MouseEvent e) -> {
            alterarCadastro();
            JOptionPane.showMessageDialog(null, "Cadastro alterado com Sucesso!");
            Principal p = new Principal();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PerfilController btnInicio.setOnMouseClicked()"+ex);
            }
        });
    }    
    
    private void fecha(){
        Perfil.getStage().close();
    }
    
    private void alterarCadastro(){
        String nomeEdificio, endereco, nomeUsuario, email, senha;
        int codigo;
        
        nomeEdificio = txtNomeEdificio.getText();
        endereco = txtEndereco.getText();
        nomeUsuario = txtNomeUsuario.getText();
        email = txtEmail.getText();
        senha = txtSenha.getText();
        codigo = Integer.parseInt(txtCodigo.getText());
        
        Edificio e = new Edificio();
        e.setNome_ed(nomeEdificio);
        e.setEndereco(endereco);
        e.setNome_user(nomeUsuario);
        e.setEmail(email);
        e.setSenha(senha);
        e.setId_edificio(codigo);
        
        EdificioDAO edao = new EdificioDAO();
        edao.alterarEdificio(e);
        
    }
}
