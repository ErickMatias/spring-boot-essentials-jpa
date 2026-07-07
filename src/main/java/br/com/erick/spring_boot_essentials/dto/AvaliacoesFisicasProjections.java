package br.com.erick.spring_boot_essentials.dto;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjections {

    Integer getIdAluno();
    String getNomeAluno();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPercentualGorduraCorporal();
}
