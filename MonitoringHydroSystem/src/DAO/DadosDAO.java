package DAO;

import DTO.Dados;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

public class DadosDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Dados> lista = new ArrayList<>();
    
    public void inserirDado(Dados d){
        String sql = "INSERT INTO dados (data_hora, pressao_entrada, pressao_saida, volume_agua, id_edificio) VALUES (?, ?, ?, ?, ?)";
        
        conn = new ConexaoDAO().conectaBD();
       
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, d.getData_hora());
            pstm.setDouble(2, d.getPressao_entrada());
            pstm.setDouble(3, d.getPressao_saida());
            pstm.setDouble(4, d.getVolume_agua());
            pstm.setInt(5, d.getId_edificio());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Inserir: "+erro);
            System.err.println("DadosDAO Inserir: "+ erro);
        }
       
    }
    
    public ArrayList<Dados> pesquisarDados(){
        String sql = "SELECT * FROM edificio";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Dados d = new Dados();
                d.setId_leitura(rs.getInt("id_leitura"));
                d.setId_edificio(rs.getInt("id_edificio"));
                d.setData_hora(rs.getString("data_hora"));
                d.setPressao_entrada(rs.getDouble("pressao_entrada"));
                d.setPressao_saida(rs.getDouble("pressao_saida"));
                d.setVolume_agua(rs.getDouble("volume_agua"));
                
                lista.add(d);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO Pesquisar: "+erro);
            System.err.println("DadosDAO Pesquisar: "+ erro);
        }
        
        return lista;
    } 
    
    public ArrayList<Dados> pesquisarDadosAno(){
        String sql = "SELECT * FROM edificio";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Dados d = new Dados();
                d.setId_leitura(rs.getInt("id_leitura"));
                d.setId_edificio(rs.getInt("id_edificio"));
                d.setData_hora(rs.getString("data_hora"));
                d.setPressao_entrada(rs.getDouble("pressao_entrada"));
                d.setPressao_saida(rs.getDouble("pressao_saida"));
                d.setVolume_agua(rs.getDouble("volume_agua"));
                
                lista.add(d);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO Pesquisar: "+erro);
            System.err.println("DadosDAO Pesquisar: "+ erro);
        }
        
        return lista;
    } 
    
    public ArrayList<Dados> pesquisarDadosMes(){
        String sql = "SELECT * FROM edificio";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Dados d = new Dados();
                d.setId_leitura(rs.getInt("id_leitura"));
                d.setId_edificio(rs.getInt("id_edificio"));
                d.setData_hora(rs.getString("data_hora"));
                d.setPressao_entrada(rs.getDouble("pressao_entrada"));
                d.setPressao_saida(rs.getDouble("pressao_saida"));
                d.setVolume_agua(rs.getDouble("volume_agua"));
                
                lista.add(d);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO Pesquisar: "+erro);
            System.err.println("DadosDAO Pesquisar: "+ erro);
        }
        
        return lista;
    } 
    
    public ArrayList<Dados> pesquisarDadosSemana(){
        String sql = "SELECT * FROM edificio";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Dados d = new Dados();
                d.setId_leitura(rs.getInt("id_leitura"));
                d.setId_edificio(rs.getInt("id_edificio"));
                d.setData_hora(rs.getString("data_hora"));
                d.setPressao_entrada(rs.getDouble("pressao_entrada"));
                d.setPressao_saida(rs.getDouble("pressao_saida"));
                d.setVolume_agua(rs.getDouble("volume_agua"));
                
                lista.add(d);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO Pesquisar: "+erro);
            System.err.println("DadosDAO Pesquisar: "+ erro);
        }
        
        return lista;
    } 
    
    public ArrayList<Dados> pesquisarDadosDia(){
        String sql = "SELECT * FROM edificio";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Dados d = new Dados();
                d.setId_leitura(rs.getInt("id_leitura"));
                d.setId_edificio(rs.getInt("id_edificio"));
                d.setData_hora(rs.getString("data_hora"));
                d.setPressao_entrada(rs.getDouble("pressao_entrada"));
                d.setPressao_saida(rs.getDouble("pressao_saida"));
                d.setVolume_agua(rs.getDouble("volume_agua"));
                
                lista.add(d);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO Pesquisar: "+erro);
            System.err.println("DadosDAO Pesquisar: "+ erro);
        }
        
        return lista;
    } 
    
    public ResultSet listarEdificio(){
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM edificio ORDER BY id_edificio;";
        
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
            
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
            JOptionPane.showMessageDialog(null, "DadosDAO listarEdificio: "+ erro);
            return null;
        }
    }
    
    public void alterarDados(Dados d){
        String sql = "UPDATE dados SET id_leitura = ?, data_hora = ?, pressao_entrada = ?, pressao_saida = ?, volume_agua = ? WHERE id_edificio = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, d.getId_leitura());
            pstm.setString(2, d.getData_hora());
            pstm.setDouble(3, d.getPressao_entrada());
            pstm.setDouble(4, d.getPressao_saida());
            pstm.setDouble(5, d.getVolume_agua());
            pstm.setInt(6, d.getId_edificio());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO Alterar: "+erro);
            System.err.println("DadosDAO Alterar: "+erro);
        }
        
    }
    
    public void excluirDados(Dados d){
        String sql = "DELETE FROM dados WHERE id_leitura = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, d.getId_edificio());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DadosDAO excluirDados: "+erro);
        }
    }
}
