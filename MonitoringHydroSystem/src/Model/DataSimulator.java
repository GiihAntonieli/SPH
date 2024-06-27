package Model;

import java.util.Random;

public class DataSimulator {
    private double pressaoEntrada;
    private double pressaoSaida;
    private double volumeAgua;

    //Métodos Especiais
        //Getters and Setters
    public double getPressaoEntrada() {
        return pressaoEntrada;
    }
    public void setPressaoEntrada(double pressaoEntrada) {
        this.pressaoEntrada = pressaoEntrada;
    }

    public double getPressaoSaida() {
        return pressaoSaida;
    }
    public void setPressaoSaida(double pressaoSaida) {
        this.pressaoSaida = pressaoSaida;
    }

    public double getVolumeAgua() {
        return volumeAgua;
    }
    public void setVolumeAgua(double volumeAgua) {
        this.volumeAgua = volumeAgua;
    }
    
    //Métodos 
    public double dadosPressaoEntrada(int quant) throws InterruptedException{
        double dadosE = 0;
        Random r = new Random();
        for(int i=0; i < quant; i++){
            double dado = r.nextDouble() * 100;
            dadosE = dado;
        }
        this.setPressaoEntrada(dadosE);
        return dadosE;
        
    }
    
    public double dadosPressaoSaida(int quant) throws InterruptedException{
        double dadosS = 0;
        Random r = new Random();
        for (int i = 0; i < quant; i++){
            double dado = r.nextDouble() *100;
            dadosS = dado;
        }
        this.setPressaoSaida(dadosS);
        return dadosS;
        
    }
    
    public double dadosVolumeAgua(int quant) throws InterruptedException{
        double dadosV = 0;
        Random r = new Random();
        for (int i = 0; i < quant; i++){
            double dado = r.nextDouble() * 50000;
            dadosV = dado;
        }
        this.setVolumeAgua(dadosV);
        return dadosV;
        
    }
}
