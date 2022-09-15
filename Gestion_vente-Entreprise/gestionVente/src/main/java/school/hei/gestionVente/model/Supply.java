package school.hei.gestionVente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Supply implements Serializable {

  private String url;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  @NotBlank(message = "must not be blank")
  private String name;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Double quantity;

  @Column(nullable = false)
  private LocalDate dateOfselling;

  private boolean availability = true;
  @ManyToMany
  @JoinColumn(name = "id_supplies")
  private List<Client> clients;
}
