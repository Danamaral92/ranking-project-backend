package br.com.crapnet.rankingprojectbackend.controllers;


import br.com.crapnet.rankingprojectbackend.domain.competitor.Competitor;
import br.com.crapnet.rankingprojectbackend.domain.competitor.CompetitorRequestDTO;
import br.com.crapnet.rankingprojectbackend.domain.competitor.CompetitorResponseDTO;
import br.com.crapnet.rankingprojectbackend.domain.competitor.Weights;
import br.com.crapnet.rankingprojectbackend.services.CompetitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/competitors")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CompetitorsController {
    @Autowired
    private CompetitorService competitorService;


    @PostMapping("/save")
    public ResponseEntity<Competitor> saveCompetitor(@RequestBody @Valid CompetitorRequestDTO body) {
        Competitor competitor = new Competitor(body);
        return ResponseEntity.status(HttpStatus.OK).body(competitorService.save(competitor));
    }


    @PostMapping("/update")
    public ResponseEntity<Integer> updateCompetitor(@RequestBody @Valid CompetitorRequestDTO body) {
        Competitor competitor = new Competitor(body);
        if(competitorService.update(competitor) == 1){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping("/weights")
    public ResponseEntity<Weights> updateCompetitor(@RequestBody @Valid Weights body) {
        BigDecimal soma = body.getLumosity().add(body.getKeybr()).add(body.getProvas());
        if(soma.compareTo(BigDecimal.valueOf(1.0)) == 0){
            Weights.getInstance().setKeybr(body.getKeybr());
            Weights.getInstance().setLumosity(body.getLumosity());
            Weights.getInstance().setProvas(body.getProvas());
            return ResponseEntity.status(HttpStatus.OK).body(Weights.getInstance());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Weights.getInstance());
    }

    @GetMapping("/weights")
    public ResponseEntity<Weights> getWeights() {
        return ResponseEntity.status(HttpStatus.OK).body(Weights.getInstance());
    }

    @GetMapping
    public ResponseEntity<List<CompetitorResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(competitorService.findAll());
    }

}
