package one.digitalinnovation.gof.dto;

import javax.validation.constraints.NotBlank;

public class EnderecoDTO {
    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
} 