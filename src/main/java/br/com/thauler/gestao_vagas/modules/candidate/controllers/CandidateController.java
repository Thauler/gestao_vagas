package br.com.thauler.gestao_vagas.modules.candidate.controllers;

import br.com.thauler.gestao_vagas.exceptions.UserFoundException;
import br.com.thauler.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.thauler.gestao_vagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CandidateRepository candidateRepository;

  @PostMapping()
  public CandidateEntity create(@Valid @RequestBody CandidateEntity candidate) {
    this.candidateRepository
        .findByEmailOrUsername(candidate.getEmail(), candidate.getUsername())
        .ifPresent((user) -> {throw new UserFoundException();
        });
    return this.candidateRepository.save(candidate);
  }
}
