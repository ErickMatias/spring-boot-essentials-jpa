package br.com.erick.spring_boot_essentials.controller;

import br.com.erick.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.erick.spring_boot_essentials.dto.AlunoDto;
import br.com.erick.spring_boot_essentials.exeption.BadRequestException;
import br.com.erick.spring_boot_essentials.exeption.NotFoundException;
import br.com.erick.spring_boot_essentials.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunoService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunoService.getAvaliacao(alunoId);
    }

    @GetMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAluno(@PathVariable Integer alunoId) throws NotFoundException {
         alunoService.deletarAluno(alunoId);
    }
}
