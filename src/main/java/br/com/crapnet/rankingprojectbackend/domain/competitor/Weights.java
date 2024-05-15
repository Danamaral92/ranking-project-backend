package br.com.crapnet.rankingprojectbackend.domain.competitor;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Weights {
    private static Weights INSTANCE = new Weights();
    private BigDecimal provas = BigDecimal.valueOf(0.6);
    private BigDecimal lumosity = BigDecimal.valueOf(0.3);
    private BigDecimal keybr = BigDecimal.valueOf(0.1);


    public static Weights getInstance() {
        return INSTANCE;
    }
}
