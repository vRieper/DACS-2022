package br.univille.apidacs2022.service;
import org.springframework.stereotype.Service;
import java.util.List;

import br.univille.coredacs2022.entity.Consulta;

@Service
public interface ConsultaService {
    public List<Consulta> getAll();

    public Consulta save(Consulta consulta);

    public Consulta findById(long id);

    public Consulta delete(long id);

}