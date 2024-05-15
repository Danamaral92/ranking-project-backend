package br.com.crapnet.rankingprojectbackend.repositories;

import br.com.crapnet.rankingprojectbackend.domain.competitor.Competitor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface CompetitorRepository extends JpaRepository<Competitor, String> {


    @Query("SELECT c FROM competitors c WHERE c.nome = ?1")
    List<Competitor> findByNome(String nome);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE competitors c SET c.provas = :provas, c.lumosity = :lumosity, c.keybr = :keybr WHERE c.id = :id")
    Integer update(@Param("id") String id, @Param("provas") BigDecimal provas, @Param("lumosity") BigDecimal lumosity,
                   @Param("keybr") BigDecimal keybr);
}
