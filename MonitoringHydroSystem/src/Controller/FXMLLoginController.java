/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DTO.Edificio;
import DAO.EdificioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sph3.Cadastro;
import sph3.Principal;
import sph3.SPH3;



/**
 * FXML Controller class
 *
 * @author 3040
 */
public class FXMLLoginController implements Initializable {
    
    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void entrar(ActionEvent event) {
        logar();
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtLogin.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.ENTER){
                
            }
        });
        btnEntrar.setOnMouseClicked((MouseEvent e) -> {
            logar();
        });
        txtSenha.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.ENTER){
                logar();
            }
        });
        
        btnCadastro.setOnMouseClicked((event) -> {
            Cadastro c = new Cadastro();
            fecha();
            try {
                c.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "FXMLLoginController btnCadastro.setOnMouseClicked()"+ex);
            }
        });
        // TODO
    }    
    
    private void logar(){
        try {
            //String nome_usuario, senha_usuario;
            
            String nome_usuario = txtLogin.getText();
            String senha_usuario = txtSenha.getText();
            
            Edificio e = new Edificio();
            e.setNome_user(nome_usuario);
            e.setSenha(senha_usuario);
            
            EdificioDAO edao = new EdificioDAO();
            ResultSet rs = edao.autenticacaoUsuario(e);
            
            if (rs.next()){
                //chamar tela que eu quero abrir 
                Principal p = new Principal();
                fecha();
                try {
                    p.start(new Stage());
                } catch (IOException erro) {
                    JOptionPane.showMessageDialog(null, "FXMLLoginController logar() carregaTela: "+erro);
                }
                
                
            }else{
                //enviar mensagem dizendo incorreto 
                JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Erro");
                alert.setTitle("Login Inválido");
                alert.setContentText("Usuário ou Senha Inválida");
                alert.show();
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FXMLLoginController logar() cadastro: "+erro);
            System.err.println("FXMLLoginController logar: "+ erro);
            System.err.println("ERRO"+ erro.getMessage());
        }
    }
    
    private void fecha(){
        SPH3.getStage().close();
    }

}
