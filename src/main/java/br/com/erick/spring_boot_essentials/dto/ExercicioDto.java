package br.com.erick.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExercicioDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
