package school.hei.gestionVente.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToClient {
  private String email;
  private String address;
  private String phone;
  private Long id_supply;
}
