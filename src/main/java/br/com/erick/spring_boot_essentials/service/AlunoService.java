package br.com.erick.spring_boot_essentials.service;

import br.com.erick.spring_boot_essentials.database.model.AlunosEntity;
import br.com.erick.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.erick.spring_boot_essentials.database.model.TreinosEntity;
import br.com.erick.spring_boot_essentials.database.repository.IAlunosRepository;
import br.com.erick.spring_boot_essentials.database.repository.IAvaliacoesFisicasRepository;
import br.com.erick.spring_boot_essentials.database.repository.ITreinosRepository;
import br.com.erick.spring_boot_essentials.dto.AlunoDto;
import br.com.erick.spring_boot_essentials.exeption.BadRequestException;
import br.com.erick.spring_boot_essentials.exeption.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final IAlunosRepository alunosRepository;
    private final ITreinosRepository treinosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException{
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if (aluno != null) {
            throw new BadRequestException("Aluno já cadastrado com esse email");
        }

        alunosRepository.save(AlunosEntity.builder()
                        .nome(alunoDto.getNome())
                        .email(alunoDto.getEmail())
                        .build());
    }

    public AvaliacoesFisicasEntity getAvaliacao(Integer alunoId) throws NotFoundException{
        AlunosEntity aluno = alunosRepository.findByFetch(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacaoFisica();
        if (avaliacao == null) {
            throw new NotFoundException("Avaliação física não encontrada para este aluno");
        }

        return avaliacao;
    }

    public void deletarAluno(Integer alunoId) throws NotFoundException {
        AlunosEntity aluno = alunosRepository.findByFetch(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        List<Integer> treinosAlunosIds = aluno.getTreinos().stream()
                .map(TreinosEntity::getId)
                .toList();

        treinosRepository.deleteAllById(treinosAlunosIds);

        alunosRepository.deleteById(alunoId);

        avaliacoesFisicasRepository.deleteById(aluno.getAvaliacaoFisica().getId());
    }
}
