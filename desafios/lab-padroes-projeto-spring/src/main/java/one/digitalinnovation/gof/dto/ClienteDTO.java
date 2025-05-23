package one.digitalinnovation.gof.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "O endereço é obrigatório.")
    private EnderecoDTO endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
} 