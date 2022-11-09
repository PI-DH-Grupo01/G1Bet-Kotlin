package br.com.g1bet.model;

public class ApostaModel {

    private Long idAposta;
    private Long idUsuario;
    private Long idPartida;
    private String tipoDeAposta;
    private float valorApostado;

    public ApostaModel() {

    }

    public Long getIdAposta() {
        return idAposta;
    }

    public void setIdAposta(Long idAposta) {
        this.idAposta = idAposta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getTipoDeAposta() {
        return tipoDeAposta;
    }

    public void setTipoDeAposta(String tipoDeAposta) {
        this.tipoDeAposta = tipoDeAposta;
    }

    public float getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(float valorApostado) {
        this.valorApostado = valorApostado;
    }
}
