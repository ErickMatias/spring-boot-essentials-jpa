package br.com.erick.spring_boot_essentials.exeption;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    private Integer status;
}
