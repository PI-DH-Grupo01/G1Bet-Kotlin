package br.com.g1bet.model;

import java.time.LocalDateTime;

public class PartidaModel {

    private int idPartida;

    private int idTimeA;

    private int idTimeB;

    private String resultado;

    private LocalDateTime dataHoraPartida;

    public PartidaModel() {

    }

    public int getIdPartida() {
        return idPartida;
    }
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdTimeA() {
        return idTimeA;
    }

    public void setIdTimeA(int idTimeA) {
        this.idTimeA = idTimeA;
    }

    public int getIdTimeB() {
        return idTimeB;
    }

    public void setIdTimeB(int idTimeB) {
        this.idTimeB = idTimeB;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(LocalDateTime dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

}
