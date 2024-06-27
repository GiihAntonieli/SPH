package Controller;

import DAO.DadosDAO;
import DTO.Dados;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sph3.Consultas;
import sph3.Perfil;
import sph3.Principal;
import DTO.Edificio;
import Model.DataSimulator;
import Model.LeituraService;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import sph3.SPH3;


/**
 * FXML Controller class
 *
 * @author 3040
 */
public class PrincipalController implements Initializable {
    
    @FXML private Button btnConsulta;

    @FXML private Button btnInicio;

    @FXML private Button btnPerfil;
    
    @FXML private Button btnLogout;

    @FXML private AnchorPane panelBtn;

    @FXML private AnchorPane panelMenu;

    @FXML private TextField txtNomePerfil;
    
    @FXML private TextField txtCódigo;

    @FXML private TextField txtNomeEdifcio;

    @FXML private PieChart chartVolume;
    
    @FXML private PieChart chartPEntrada;

    @FXML private PieChart chartPSaida;
    
    @FXML private BarChart<?, ?> barChartEntrada;

    @FXML private BarChart<?, ?> barChartSaida;
    
    @FXML private CategoryAxis xEntrada;

    @FXML private CategoryAxis xSaida;

    @FXML private NumberAxis yEntrada;

    @FXML private NumberAxis ySaida;
    
    
    
    private ScheduledExecutorService scheduler;
    
    
  
    

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
                JOptionPane.showMessageDialog(null, "PrincipalController btnConsulta.setOnMouseClicked()"+ex);
                
            }
        });
        
        btnInicio.setOnMouseClicked((MouseEvent e) -> {
            Principal p = new Principal();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PrincipalController btnInicio.setOnMouseClicked()"+ex);
            }
        });
        
        btnPerfil.setOnMouseClicked((MouseEvent e) -> {
            Perfil p = new Perfil();
            fecha();
            try {
                p.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PrincipalController btnPerfil.setOnMouseClicked()"+ex);
            }
        });
        
        btnLogout.setOnMouseClicked((MouseEvent e) -> {
            SPH3 l = new SPH3();
            onCloseRequest();
            fecha();
            try {
                l.start(new Stage());
            } catch (IOException ex) {
                Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PrincipalController btnLogout.setOnMouseClicked()"+ex);
            }
        });
        
        Dados d = new Dados();
        try {
            registrarLeitura(d);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"PrincipalController initialize graficoVolume"+ ex);
        }

    }    
    
    //Fecha a tela 
    private void fecha(){
        Principal.getStage().close();
    }
    
    //Método chamado para gerar os dados, insertar no BD e criar os gráficos
    public void registrarLeitura(Dados d) throws InterruptedException{
        //Registra os dados de 5 em 5 segundos
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            try {
                //Chave Primária
                d.setId_edificio(3);

                //Data e Hora
                LocalDateTime hD = LocalDateTime.now();
                String horaData = hD.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
                d.setData_hora(horaData);

                //pressão da Entrada
                DataSimulator dados = new DataSimulator();
                double pressaoEntrada = dados.dadosPressaoEntrada(1);
                d.setPressao_entrada(pressaoEntrada);


                //pressão da Saída
                double pressaoSaida = dados.dadosPressaoSaida(1);
                d.setPressao_saida(pressaoSaida);


                //volume de Água
                double volumeAgua = dados.dadosVolumeAgua(1);
                d.setVolume_agua(volumeAgua);


                System.out.println("Pressao Entrada: "+ Double.toString(d.getPressao_entrada()));
                System.out.println("Pressao Saida: "+ Double.toString(d.getPressao_saida()));
                System.out.println("Volume: "+ Double.toString(d.getVolume_agua()));
                System.out.println("Data e hora: "+ d.getData_hora());
                System.out.println("----------------------------------");
                
                //Gráficos
                Platform.runLater(() -> {
                    //Gráfico Pizza Volume
                        //Define os dados do gráfico
                        PieChart.Data vazio = new PieChart.Data("Vazio", 50000);
                        PieChart.Data volume = new PieChart.Data("Água", volumeAgua);
                        
                        //Cria o gráfico pizza
                        ObservableList<PieChart.Data> chart = FXCollections.observableArrayList(volume, vazio);
                        
                        //Define os dados no gráfico
                        chartVolume.setData(chart);
                        
                    //Gráfico Pizza PressãoEntrada
                        //Define os dados do gráfico
                        PieChart.Data limiteE = new PieChart.Data("", 71);
                        PieChart.Data pressaoE = new PieChart.Data("Pressão Entrada", pressaoEntrada);
                        
                        //Cria o gráfico pizza
                        ObservableList<PieChart.Data> chartPressaoE = FXCollections.observableArrayList(limiteE, pressaoE);
                        
                        //Define os dados no gráfico
                        chartPEntrada.setData(chartPressaoE);
                        
                    //Gráfico Pizza PressãoSaida
                        //Define os dados do gráfico
                        PieChart.Data limiteS = new PieChart.Data("", 71);
                        PieChart.Data pressaoS = new PieChart.Data("Pressão Saída", pressaoSaida);
                        
                        //Cria o gráfico pizza
                        ObservableList<PieChart.Data> chartPressaoS = FXCollections.observableArrayList(limiteS, pressaoS);
                        
                        //Define os dados no gráfico
                        chartPSaida.setData(chartPressaoS);
                        
                    //Gráfico linha Pressão Entrada
                        //Cria o gráfico 
                        XYChart.Series pE = new XYChart.Series<>();
                        
                        //Adicionando elementos
                        pE.getData().add(new XYChart.Data("", pressaoEntrada));

                        //Define os dados no gráfico
                        barChartEntrada.getData().addAll(pE);
                            
                    //Gráfico linha Pressão Saída
                        //cria o gráfico
                        XYChart.Series pS = new XYChart.Series<>();
                        
                        //Adicionando elementos
                        pS.getData().add(new XYChart.Data("", pressaoSaida));
                            
                        //Define os dados no gráfico
                       barChartSaida.getData().addAll(pS);
                    
                    });
                
                DadosDAO dao = new DadosDAO();
                dao.inserirDado(d);
                
            }catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println("LeituraService registrarLeitura: "+ e);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
    
    
    
    // Método para interromper a execução agendada
    private void pararLeitura(){
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }
    
    // Método chamado quando a janela é fechada
    private void onCloseRequest() {
        // Chame o método para parar a execução agendada
        pararLeitura();
    }
}
