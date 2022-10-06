package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.PlanoDeSaudeService;
import br.univille.coredacs2022.entity.PlanoDeSaude;

@RestController
@RequestMapping("/api/v1/planosDeSaude")
public class PlanoDeSaudeControllerAPI {

    @Autowired
    private PlanoDeSaudeService service;

    @GetMapping
    public ResponseEntity<List<PlanoDeSaude>> getAll() {
        var listaPlanoDeSaude = service.getAll();
        return new ResponseEntity<List<PlanoDeSaude>>(listaPlanoDeSaude, HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<PlanoDeSaude> insertPaciente(@RequestBody PlanoDeSaude planoDeSaude) {
        if (planoDeSaude.getId() == 0) {
            service.save(planoDeSaude);
            return new ResponseEntity<PlanoDeSaude>(planoDeSaude, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDeSaude> getById(@PathVariable("id") long id) {
        var plano = service.getById(id);
        return new ResponseEntity<PlanoDeSaude>(plano, HttpStatus.OK);
    }//Logica Certa???

}
