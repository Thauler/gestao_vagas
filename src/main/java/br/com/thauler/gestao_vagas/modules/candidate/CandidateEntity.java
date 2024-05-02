package br.com.thauler.gestao_vagas.modules.candidate;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CandidateEntity {

  private UUID id;
  private String name;

  @Pattern(regexp = "^(?!\\s*$).+", message = "is not allowed blank spaces on [username]")
  private String username;

  @Email(message = "It must be a valid email")
  private String email;

  @Length(min = 10, max = 100)
  private String password;
  private String description;
  private String curriculum;
}
