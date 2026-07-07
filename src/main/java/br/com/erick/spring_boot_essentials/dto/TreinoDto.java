package br.com.erick.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TreinoDto {

    @NotNull
    private Integer alunoId;

    @NotBlank
    private String nome;

    @NotNull
    private List<Integer> exerciciosId;
}