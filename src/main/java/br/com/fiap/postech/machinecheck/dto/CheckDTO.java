package br.com.fiap.postech.machinecheck.dto;

import jakarta.validation.constraints.NotBlank;

public record CheckDTO(
        @NotBlank(message = "Nome da Maquina é obrigatorio")

        String maquina,
        String observacao,

        @NotBlank(message = "Nome do Componente é obrigatorio")
        String componente,

        @NotBlank(message = "Status da checagem é obrigatorio")
        String statusChecagem,

        String dataChecagem,

        String tempoDaChecagem,

        String urlFoto,

        String urlVideo,

        String executante
) {
}
