package br.com.crapnet.rankingprojectbackend.services;


import br.com.crapnet.rankingprojectbackend.domain.competitor.Competitor;
import br.com.crapnet.rankingprojectbackend.domain.competitor.CompetitorResponseDTO;
import br.com.crapnet.rankingprojectbackend.domain.competitor.Weights;
import br.com.crapnet.rankingprojectbackend.repositories.CompetitorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CompetitorService {

    @Autowired
    private CompetitorRepository repository;


    @Transactional
    public Competitor save(Competitor competitor) {
        return repository.save(competitor);
    }

    public Integer update(Competitor competitor) {
        List<Competitor> competitorsList = repository.findByNome(competitor.getNome());
        if(!competitorsList.isEmpty()) {
            return repository.update(competitorsList.get(0).getId(), competitor.getProvas(), competitor.getLumosity(),
                    competitor.getKeybr());
        }
        return 0;
    }

    public List<CompetitorResponseDTO> findAll() {
        List<Competitor> competitors = repository.findAll();
        List<CompetitorResponseDTO> response = competitors.stream()
                .map((competitor) -> new CompetitorResponseDTO(competitor, Weights.getInstance()))
                .toList();
        List<CompetitorResponseDTO> sorted = response.stream()
                .sorted((competitor1, competitor2) -> competitor2.getMedia().compareTo(competitor1.getMedia()))
                .toList();
        IntStream.range(0, sorted.size())
                .boxed()
                .forEach((i) -> sorted.get(i).setRanking(i + 1));
        return sorted;
    }

}
