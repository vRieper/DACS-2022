package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.PlanoDeSaude;

public interface PlanoDeSaudeService {
    public PlanoDeSaude getById(long id);

    public List<PlanoDeSaude> getAll();

    public PlanoDeSaude save(PlanoDeSaude paciente);

    public PlanoDeSaude delete(long id);

    public List<PlanoDeSaude> getByName(String nome);
}
