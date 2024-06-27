package Model;

import Model.DataSimulator;
import DAO.DadosDAO;
import DAO.DadosDAO;
import DTO.Dados;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class LeituraService {
    
    @FXML private PieChart chartVolume;
    
    @FXML private LineChart<?, ?> lineChartEntrada;

    @FXML private LineChart<?, ?> lineChartSaida;
    
    
    private double volumeAgua;
    
    //Métodos Especiais

    public double getVolumeAgua() {
        return volumeAgua;
    }
    public void setVolumeAgua(double volumeAgua) {
        this.volumeAgua = volumeAgua;
    }
    
    
     //Métodos 
    
    public void registrarLeitura(Dados d) throws InterruptedException{
        //Registra os dados de 5 em 5 segundos
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
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
                
               /* //Gráfico Pizza Volume
                ObservableList<PieChart.Data> chart = FXCollections.observableArrayList(
                new PieChart.Data("Volume", volumeAgua),
                new PieChart.Data("Vazio", 1));

                chartVolume.setData(chart);
                //Gráfico Barra Pressão*/
                
                //Gráficos
                Platform.runLater(() -> {
                    //Gráfico Pizza Volume
                        //Define os dados do gráfico
                        PieChart.Data volume = new PieChart.Data("Água", volumeAgua);
                        PieChart.Data vazio = new PieChart.Data("Vazio", 50000);

                        //Cria o gráfico pizza
                        ObservableList<PieChart.Data> chart = FXCollections.observableArrayList(volume, vazio);
                        
                        //Define os dados no gráfico
                        chartVolume.setData(chart);
                        
                    //Gráfico linha Pressão Entrada
                        //Cria o gráfico 
                        XYChart.Series lineEntrada = new XYChart.Series<>();
                        
                        //Limpa os dados 
                        lineEntrada.getData().clear();
                        
                        //Adicionando elementos
                        lineEntrada.getData().add(new XYChart.Data("", pressaoEntrada));
                        
                        //Define os dados no gráfico
                        lineChartEntrada.getData().addAll(lineEntrada);
                        
                    //Gráfico linha Pressão Saída
                        //cria o gráfico
                        XYChart.Series lineSaida = new XYChart.Series<>();
                        
                        //Limpa os dados
                        lineSaida.getData().clear();
                        
                        //Adicionando elementos
                        lineSaida.getData().add(new XYChart.Data("", pressaoSaida));
                            
                        //Define os dados no gráfico
                        lineChartSaida.getData().addAll(lineSaida);
                    
                    });
                
                DadosDAO dao = new DadosDAO();
                dao.inserirDado(d);
                
            }catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println("LeituraService registrarLeitura: "+ e);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
    
    
}
