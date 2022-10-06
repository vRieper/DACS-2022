package br.univille.apidacs2022.service;

import java.util.List;

import br.univille.coredacs2022.entity.Cidade;

public interface CidadeService {
    public Cidade save(Cidade consulta);

    public List<Cidade> getAll();

    public Cidade delete(long id);

    public Cidade getById(long id);

    public List<Cidade> getByName(String nome);

}