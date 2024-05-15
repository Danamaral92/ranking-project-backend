package br.com.crapnet.rankingprojectbackend.domain.competitor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CompetitorResponseDTO {
    private String id;
    private String nome;
    private Integer ranking;
    private BigDecimal provas;
    private BigDecimal lumosity;
    private BigDecimal keybr;
    private BigDecimal media;
    public CompetitorResponseDTO(Competitor competitor , Weights weights) {
        this(competitor.getId(), competitor.getNome(), 0, competitor.getProvas(), competitor.getLumosity(),
                competitor.getKeybr(), (competitor.getProvas().multiply(weights.getProvas())
                        .add(competitor.getLumosity().multiply(weights.getLumosity()))
                        .add(competitor.getKeybr().multiply(weights.getKeybr()))));
    }

}
