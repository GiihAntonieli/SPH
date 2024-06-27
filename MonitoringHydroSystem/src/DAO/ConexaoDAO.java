package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author 3040
 */
public class ConexaoDAO {
    
    public Connection conectaBD(){
        Connection conn = null;
        
           //String url = "jdbc:sqlite:sph.db;
        try {
            String url = "jdbc:mysql://localhost:3306/sph?user=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO: "+erro.getMessage());
        }
        return conn;
    }
}
