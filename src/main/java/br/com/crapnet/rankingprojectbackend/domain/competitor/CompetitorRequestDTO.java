package br.com.crapnet.rankingprojectbackend.domain.competitor;

import java.math.BigDecimal;

public record CompetitorRequestDTO(String nome, BigDecimal provas, BigDecimal lumosity, BigDecimal keybr) {
}
