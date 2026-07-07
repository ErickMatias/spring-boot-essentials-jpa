package br.com.erick.spring_boot_essentials.database.repository;

import br.com.erick.spring_boot_essentials.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

    @Query(value = """
            SELECT e 
            FROM ExerciciosEntity e
            WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular)
            """)
    List<ExerciciosEntity> findAllByGrupoMuscularJpql(@Param("grupoMuscular") String grupoMuscular);
}
