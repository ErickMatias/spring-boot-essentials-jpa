package br.com.erick.spring_boot_essentials.controller;

import br.com.erick.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import br.com.erick.spring_boot_essentials.dto.AvaliacoesFisicasProjections;
import br.com.erick.spring_boot_essentials.exeption.BadRequestException;
import br.com.erick.spring_boot_essentials.exeption.NotFoundException;
import br.com.erick.spring_boot_essentials.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjections> getAllAvaliacoes() {
        return avaliacaoFisicaService.getAllAvaliacoes();
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacoesFisicasProjections> getAllAvaliacoesPageable(@PathVariable Integer page,
                                                                       @PathVariable Integer size) {
        return avaliacaoFisicaService.getAllAvaliacoesPageable(page, size);
    }


}
