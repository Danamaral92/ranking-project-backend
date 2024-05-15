package br.com.crapnet.rankingprojectbackend.domain.competitor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "competitors")
@Table(name = "competitors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private BigDecimal provas;
    private BigDecimal lumosity;
    private BigDecimal keybr;


    public Competitor(CompetitorRequestDTO body) {
        this.nome = body.nome();
        this.provas = body.provas();
        this.lumosity = body.lumosity();
        this.keybr = body.keybr();
    }

}
