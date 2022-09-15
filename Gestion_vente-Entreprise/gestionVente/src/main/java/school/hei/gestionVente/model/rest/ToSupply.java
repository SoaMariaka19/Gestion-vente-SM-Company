package school.hei.gestionVente.model.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class ToSupply {
  private String name;
  private Double price;
  private Double quantity;
  private LocalDate dateOfselling;
  @Builder.Default
  private boolean availability = true;
  private Long id_seller;
  private Long id_client;
}
