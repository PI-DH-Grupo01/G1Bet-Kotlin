package br.com.g1bet.model.dto;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.TipoApostaEnum;

import java.time.LocalDateTime;

public class ApostaResponse {
    private Long id;
    private String usuario;
    private PartidaResponse partida;
    private TipoApostaEnum tipoApostaEnum;
    private Double valor;
    private Double odd;

    public static ApostaResponse toApostaResponse(Aposta aposta) {
        PartidaResponse partidaResponse = new PartidaResponse();
        partidaResponse.setResultado(aposta.getPartida().getResultado());
        partidaResponse.setDataHora(aposta.getPartida().getDataHora());
        partidaResponse.setTimeCasa(aposta.getPartida().getTimeCasa().getNome());
        partidaResponse.setTimeVisitante(aposta.getPartida().getTimeVisitante().getNome());
        return new ApostaResponse(
                aposta.getId(),
                aposta.getUsuario().getNome(),
                partidaResponse,
                aposta.getTipo(),
                aposta.getValorApostado(),
                aposta.getOdd()
        );
    }

    public ApostaResponse(Long id, String usuario, PartidaResponse partida, TipoApostaEnum tipoApostaEnum, Double valor, Double odd) {
        this.id = id;
        this.usuario = usuario;
        this.partida = partida;
        this.tipoApostaEnum = tipoApostaEnum;
        this.valor = valor;
        this.odd = odd;
    }

    public ApostaResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public PartidaResponse getPartida() {
        return partida;
    }

    public void setPartida(PartidaResponse partida) {
        this.partida = partida;
    }

    public TipoApostaEnum getTipoApostaEnum() {
        return tipoApostaEnum;
    }

    public void setTipoApostaEnum(TipoApostaEnum tipoApostaEnum) {
        this.tipoApostaEnum = tipoApostaEnum;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}

class PartidaResponse {
    private String timeCasa;
    private String timeVisitante;
    private LocalDateTime dataHora;
    private String resultado;

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getResultado() {
        if (resultado == null) {
            return "Partida iniciará";
        }
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
