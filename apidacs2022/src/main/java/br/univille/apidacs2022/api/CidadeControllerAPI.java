package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.CidadeService;
import br.univille.coredacs2022.entity.Cidade;

@RestController
@RequestMapping("/api/v1/cidades")
public class CidadeControllerAPI {
    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<List<Cidade>> getAll() {
        var listaCidades = service.getAll();

        return new ResponseEntity<List<Cidade>>(listaCidades, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cidade> insertConsulta(@RequestBody Cidade cidade) {
        if (cidade.getId() == 0) {
            service.save(cidade);
            return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> update(@PathVariable long id, @RequestBody Cidade cidade) {
        var cidadeAntigo = service.getById(id);
        if (cidadeAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        cidadeAntigo.setNome(cidade.getNome());

        service.save(cidadeAntigo);

        return new ResponseEntity<Cidade>(cidadeAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cidade> delete(@PathVariable("id") long id) {
        var cidadeAntigo = service.getById(id);
        if (cidadeAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(cidadeAntigo.getId());

        return new ResponseEntity<Cidade>(cidadeAntigo, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable("id") long id) {

        var cidade = service.getById(id);
        return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
    }
}