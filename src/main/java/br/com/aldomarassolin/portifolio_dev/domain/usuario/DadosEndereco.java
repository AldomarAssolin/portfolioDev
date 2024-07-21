package br.com.aldomarassolin.portifolio_dev.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record DadosEndereco(

        @NotBlank
        @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres")
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        String cidade,
        @Pattern(regexp = "\\d{2}")
        String uf,
        String numero,
        String complemento
) {

}
