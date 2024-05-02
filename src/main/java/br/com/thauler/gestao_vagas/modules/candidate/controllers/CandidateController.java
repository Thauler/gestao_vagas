package br.com.thauler.gestao_vagas.modules.candidate.controllers;

import br.com.thauler.gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @PostMapping()
  public void create(@Valid @RequestBody CandidateEntity candidate) {
    System.out.println("Candidate");
    System.out.println(candidate.getEmail());
  }
}
