package br.com.g1bet.model.dto;

import br.com.g1bet.model.TipoApostaEnum;

public class ApostaDTO {

    private Long usuario;
    private Long partida;
    private TipoApostaEnum tipo;
    private Double ValorApostado;

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getPartida() {
        return partida;
    }

    public void setPartida(Long partida) {
        this.partida = partida;
    }

    public TipoApostaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoApostaEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValorApostado() {
        return ValorApostado;
    }

    public void setValorApostado(Double valorApostado) {
        ValorApostado = valorApostado;
    }
}
