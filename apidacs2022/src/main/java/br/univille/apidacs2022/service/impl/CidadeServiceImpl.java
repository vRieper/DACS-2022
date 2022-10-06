package br.univille.apidacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.apidacs2022.service.CidadeService;
import br.univille.coredacs2022.entity.Cidade;
import br.univille.coredacs2022.repository.CidadeRepository;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Override
    public List<Cidade> getAll() {
        return repository.findAll();
    }

    @Override
    public Cidade delete(long id) {
        Optional<Cidade> cidade = repository.findById(id);

        if (cidade.isPresent()) {
            var cid = cidade.get();
            repository.delete(cid);
            ;

            return cid;
        }
        return null;
    }

    @Override
    public Cidade save(Cidade consulta) {
        repository.save(consulta);
        return consulta;
    }

    @Override
    public Cidade getById(long id) {
        Optional<Cidade> cidade = repository.findById(id);

        if (cidade.isPresent()) {
            return cidade.get();
        }

        return new Cidade();
    }



    @Override
    public List<Cidade> getByName(String nome) {
        return repository.findByNomeIgnoreCaseContaining(nome);
    }

}