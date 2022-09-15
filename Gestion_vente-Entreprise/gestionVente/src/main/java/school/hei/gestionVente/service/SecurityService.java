package school.hei.gestionVente.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import school.hei.gestionVente.model.User;
import school.hei.gestionVente.repository.UserRepository;

@Service
@AllArgsConstructor
public class SecurityService implements UserDetailsService {

  private final UserRepository usersRepo;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final static String User_error = "user with name %s not found";

  public String getPassword(String name) {
    return usersRepo.findUsersByUsernameIs(name).get().getPassword();
  }
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    return usersRepo.findByUsername(name)
            .orElseThrow(() -> new UsernameNotFoundException(String.format(User_error, name)));
  }
  public String signUp(User user) {
    boolean exist = usersRepo.findByUsername(user.getUsername())
            .isPresent();
    if (exist) {
      throw new IllegalStateException("name already taken please add number");
    }
    String encryptpassword = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(encryptpassword);
    usersRepo.save(user);
    return "encryptpassword";
  }
}
