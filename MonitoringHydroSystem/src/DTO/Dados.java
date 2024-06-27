package DTO;

import java.time.LocalDateTime;

public class Dados {
    // Campos da tabela Dados
    private int id_leitura;
    private int id_edificio;
    private String data_hora;
    private double pressao_entrada;
    private double pressao_saida;
    private double volume_agua; 

    // Métodos Especiais
        // Getters and Setters
    public int getId_leitura() {
        return id_leitura;
    }
    public void setId_leitura(int id_leitura) {
        this.id_leitura = id_leitura;
    }

    public int getId_edificio() {
        return id_edificio;
    }
    public void setId_edificio(int id_edificio) {
        this.id_edificio = id_edificio;
    }

    public String getData_hora() {
        return data_hora;
    }
    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public double getPressao_entrada() {
        return pressao_entrada;
    }
    public void setPressao_entrada(double pressao_entrada) {
        this.pressao_entrada = pressao_entrada;
    }

    public double getPressao_saida() {
        return pressao_saida;
    }
    public void setPressao_saida(double pressao_saida) {
        this.pressao_saida = pressao_saida;
    }

    public double getVolume_agua() {
        return volume_agua;
    }
    public void setVolume_agua(double volume_agua) {
        this.volume_agua = volume_agua;
    }
    
    
    
}
