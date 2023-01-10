package br.com.g1bet.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequest {

    private String nome;
    private Long cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    private String email;
    private String senha;
    private String chavePix;
    private Double saldoUsuario;

}
