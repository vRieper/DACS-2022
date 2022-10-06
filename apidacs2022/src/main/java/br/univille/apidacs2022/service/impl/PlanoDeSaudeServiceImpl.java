package br.univille.apidacs2022.service.impl;

import br.univille.coredacs2022.repository.PlanoDeSaudeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.PlanoDeSaudeService;
import br.univille.coredacs2022.entity.PlanoDeSaude;

@Service
public class PlanoDeSaudeServiceImpl implements PlanoDeSaudeService {

    @Autowired
    private PlanoDeSaudeRepository repository;

    @Override
    public List<PlanoDeSaude> getAll() {
        return repository.findAll();
    }

    @Override
    public PlanoDeSaude save(PlanoDeSaude planoDeSaude) {
        repository.save(planoDeSaude);
        return planoDeSaude;
    }

    @Override
    public PlanoDeSaude getById(long id) {
        Optional<PlanoDeSaude> planoDeSaude = repository.findById(id);
        if (planoDeSaude.isPresent()) {
            return planoDeSaude.get();
        }
        return null;
    }

    @Override
    public PlanoDeSaude delete(long id) {
        Optional<PlanoDeSaude> planoDeSaude = repository.findById(id);
        if (planoDeSaude.isPresent()) {
            var plan = planoDeSaude.get();
            repository.delete(plan);
            return plan;
        }
        return null;
    }

    @Override
    public List<PlanoDeSaude> getByName(String nome) {
        return repository.findByNomeIgnoreCaseContaining(nome);
    }

}
