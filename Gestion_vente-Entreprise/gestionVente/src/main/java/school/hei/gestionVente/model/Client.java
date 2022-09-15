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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode
public class Client implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Email
  @Column(nullable = false)
  private String email;
  @NotBlank(message = "must not be blank")
  @Column(nullable = false)
  private String address;
  @NotBlank(message = "must not be blank")
  @Column(nullable = false)
  private String phone;

  @OneToMany
  @JoinColumn(name = "id_client")
  private List<Supply> supplies;
}
