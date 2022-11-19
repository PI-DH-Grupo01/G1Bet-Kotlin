package br.com.g1bet.model.dto;

import br.com.g1bet.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UsuarioResponse {

    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    private String email;
    private Double saldoUsuario;

    public UsuarioResponse(Long id, String nome, LocalDate dataDeNascimento, String email, Double saldoUsuario) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.saldoUsuario = saldoUsuario;
    }

    public UsuarioResponse() {

    }

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDataDeNascimento(),
                usuario.getEmail(),
                usuario.getSaldoUsuario()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(Double saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }
}
