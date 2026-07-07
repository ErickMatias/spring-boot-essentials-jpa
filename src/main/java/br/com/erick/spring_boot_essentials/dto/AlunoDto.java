package br.com.erick.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AlunoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;;
}
