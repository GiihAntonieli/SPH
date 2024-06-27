package DAO;

import DTO.Edificio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EdificioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Edificio> lista = new ArrayList<>();
    
    public ResultSet autenticacaoUsuario(Edificio e){
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            String sql = "SELECT * FROM edificio WHERE nome_user = ? and senha = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, e.getNome_user());
            pstm.setString(2, e.getSenha());
            
            rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EdificioDAO autenticacaoEdificio: "+erro);
            return null;
        }

    }
    
    public void inserirEdificio(Edificio e){
        String sql = "INSERT INTO edificio (nome_ed, endereco, nome_user, email, senha) VALUES (?, ?, ?, ?, ?)";
        
        conn = new ConexaoDAO().conectaBD();
       
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, e.getNome_ed());
            pstm.setString(2, e.getEndereco());
            pstm.setString(3, e.getNome_user());
            pstm.setString(4, e.getEmail());
            pstm.setString(5, e.getSenha());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EdificioDAO Inserir: "+erro);
            System.err.println("EdificioDAO Inserir: "+ erro);
        }
       
    }
    
    public ArrayList<Edificio> pesquisarEdificio(){
        String sql = "SELECT * FROM edificio";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Edificio e = new Edificio();
                e.setId_edificio(rs.getInt("id_edificio"));
                e.setNome_ed(rs.getString("nome_ed"));
                e.setNome_user(rs.getString("nome_user"));
                e.setEmail(rs.getString("email"));
                e.setSenha(rs.getString("senha"));
                
                lista.add(e);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EdificioDAO Pesquisar: "+erro);
            System.err.println("EdificioDAO Pesquisar: "+erro);
        }
        
        return lista;
    } 
    
    public ResultSet listarNomeUser(){
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM edificio ORDER BY nome_user;";
        
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
            return null;
        }
    }
    
    public void alterarEdificio(Edificio e){
        String sql = "UPDATE edificio SET nome_ed = ?, endereco = ?, nome_user = ?, email = ?, senha = ? WHERE id_edificio = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, e.getNome_ed());
            pstm.setString(2, e.getEndereco());
            pstm.setString(3, e.getNome_user());
            pstm.setString(4, e.getEmail());
            pstm.setString(5, e.getSenha());
            pstm.setInt(6, e.getId_edificio());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EdificioDAO Alterar: "+erro);
            System.err.println("EdificioDAO Alterar: "+erro);
        }
        
    }
    
    public void excluirEdificio(Edificio e){
        String sql = "DELETE FROM edificio WHERE id_edificio = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, e.getId_edificio());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "EdificioDAO excluirEdificio: "+erro);
        }
    }
}
