package br.com.g1bet.model;

import java.time.LocalDate;


public class PartidaModel {

    private int id_partida;

    private int id_timeA;

    private int id_timeB;

    private String resultado;

    private localtime data_hora_partida;

    public PartidaModel() {

    }

    public int getId_partida() {
        return id_partida;
    }
    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getId_timeA() {
        return id_timeA;
    }

    public void setId_timeA(int id_timeA) {
        this.id_timeA = id_timeA;
    }

    public int getId_timeB() {
        return id_timeB;
    }

    public void setId_timeB(int id_timeB) {
        this.id_timeB = id_timeB;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public localtime getData_hora_partida() {
        return data_hora_partida;
    }

    public void setData_hora_partida(localtime data_hora_partida) {
        this.data_hora_partida = data_hora_partida;
    }
}
