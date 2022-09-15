package school.hei.gestionVente.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode
@Table(name = "\"user\"")
public class User  implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "must not be blank")
  @Column(nullable = false)
  private String username;
  @NotBlank(message = "must not be blank")
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private boolean locked;
  @Column(nullable = false)
  private boolean enabled;

  @Enumerated(EnumType.STRING)
  private Role role ;
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role);
    return Collections.singletonList(authority);
  }
  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String encryptpassword) {
    this.password = encryptpassword;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
  public enum Role{
    SELLER , CLIENT
  }
}
