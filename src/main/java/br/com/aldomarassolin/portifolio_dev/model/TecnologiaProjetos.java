package br.com.aldomarassolin.portifolio_dev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "Tecnologia_projeto")
@Table(name = "tb_tecnologias_projetos")
public class TecnologiaProjetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    private String tecnologia;

    @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres")
    private String icone;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projetos projeto;
}
