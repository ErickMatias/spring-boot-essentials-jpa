package br.com.erick.spring_boot_essentials.database.repository;

import br.com.erick.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.erick.spring_boot_essentials.database.model.ExerciciosEntity;
import br.com.erick.spring_boot_essentials.dto.AvaliacoesFisicasProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {

    @NativeQuery(value = """
        SELECT 
               a.id AS idAluno,
               a.nome AS nomeAluno,
               af.id AS idAvaliacao,
               af.peso AS peso,
               af.altura AS altura,
               af.porcentagem_gordura_corporal AS porcentagemGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a
        ON a.avaliacao_fisica_id = af.id
        """)
    List<AvaliacoesFisicasProjections> getAllAvaliacoes();

    @NativeQuery(value = """
        SELECT 
               a.id AS idAluno,
               a.nome AS nomeAluno,
               af.id AS idAvaliacao,
               af.peso AS peso,
               af.altura AS altura,
               af.porcentagem_gordura_corporal AS porcentagemGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a
        ON a.avaliacao_fisica_id = af.id
        """,
        countQuery = """
                SELECT count(af.id)
                FROM avaliacoes_fisicas af
                INNER JOIN alunos a
                ON a.avaliacao_fisica_id = af.id
                """)
    Page<AvaliacoesFisicasProjections> getAllAvaliacoesPage(Pageable pageable);
}
