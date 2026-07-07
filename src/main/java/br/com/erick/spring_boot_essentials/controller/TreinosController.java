package br.com.erick.spring_boot_essentials.controller;

import br.com.erick.spring_boot_essentials.dto.TreinoDto;
import br.com.erick.spring_boot_essentials.exeption.BadRequestException;
import br.com.erick.spring_boot_essentials.exeption.NotFoundException;
import br.com.erick.spring_boot_essentials.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinosController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody  TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDto);
    }
}
