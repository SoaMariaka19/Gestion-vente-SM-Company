package school.hei.gestionVente.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ToSeller {
  private String email;
  private String firstName;
  private String lastName;
  private Long id_supply;
}
